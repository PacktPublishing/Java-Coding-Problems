package modern.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class AssemblyLine {

    private AssemblyLine() {
        throw new AssertionError("There is a single assembly line!");
    }

    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());

    private static final int PROCESSORS = Runtime.getRuntime().availableProcessors();
    private static final int MAX_PROD_BULBS = 100;

    private static final Random rnd = new Random();
    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    
    private static final Consumer consumer = new Consumer();
    
    private static ExecutorService consumerService;

    private static class Consumer implements Callable {

        @Override
        public String call() throws InterruptedException {

            String bulb = queue.poll();

            Thread.sleep(100);

            if (bulb != null) {
                logger.info(() -> "Packed: " + bulb + " by consumer: "
                        + Thread.currentThread().getName());

                return bulb;
            }

            return "";
        }

    }

    public static void startAssemblyLine() {
        simulatingProducers();
        startConsumers();
    }

    private static void startConsumers() {

        logger.info(() -> "We have a consumers team of "
                + PROCESSORS + " members ...");

        consumerService = Executors.newWorkStealingPool();
        // consumerService = Executors.newCachedThreadPool();
        // consumerService = Executors.newWorkStealingPool(PROCESSORS);
        // consumerService = Executors.newFixedThreadPool(PROCESSORS);
                       
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < queue.size(); i++) {            
            tasks.add(consumer);
        }

        logger.info("Submit all tasks and wait for all of them to complete ...");

        try {
            List<Future<String>> futures = consumerService.invokeAll(tasks);

            for (Future<String> future : futures) {
                String bulb = future.get();
                logger.info(() -> "Future done: " + bulb);
            }

            consumerService.shutdown();
            consumerService.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception: " + ex);
        } catch (ExecutionException ex) {
            logger.severe(() -> "Exception: " + ex.getCause());
        }

    }

    private static void simulatingProducers() {

        logger.info("Simulating the job of the producers overnight ...");
        logger.info(() -> "The producers checked " + MAX_PROD_BULBS + " bulbs ...");

        for (int i = 0; i < MAX_PROD_BULBS; i++) {
            queue.offer("bulb-" + rnd.nextInt(1000));
        }
    }

}
