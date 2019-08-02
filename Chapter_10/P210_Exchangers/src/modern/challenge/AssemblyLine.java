package modern.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class AssemblyLine {

    private AssemblyLine() {
        throw new AssertionError("There is a single assembly line!");
    }

    private static final int BASKET_CAPACITY = 5;

    private static final int MAX_PROD_TIME_MS = 2 * 1000;
    private static final int MAX_CONS_TIME_MS = 5 * 1000;
    private static final int TIMEOUT_MS = (MAX_PROD_TIME_MS + MAX_CONS_TIME_MS) * BASKET_CAPACITY;

    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());

    private static final Random rnd = new Random();

    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();
    private static final Exchanger<List<String>> exchanger = new Exchanger<>();

    private static volatile boolean runningProducer;
    private static volatile boolean runningConsumer;

    private static ExecutorService producerService;
    private static ExecutorService consumerService;

    private static class Producer implements Runnable {

        private List<String> basket = new ArrayList<>(BASKET_CAPACITY);

        @Override
        public void run() {
            while (runningProducer) {
                try {
                    for (int i = 0; i < BASKET_CAPACITY; i++) {
                        String bulb = "bulb-" + rnd.nextInt(1000);
                        Thread.sleep(rnd.nextInt(MAX_PROD_TIME_MS));

                        basket.add(bulb);
                        logger.info(() -> "Checked and added in the basket: " + bulb);
                    }

                    logger.info("Producer: Waiting to exchange baskets ...");
                    basket = exchanger.exchange(basket);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception: " + ex);
                    break;
                }
            }
        }

    }

    private static class Consumer implements Runnable {

        private List<String> basket = new ArrayList<>(BASKET_CAPACITY);

        @Override
        public void run() {
            while (runningConsumer) {
                try {
                    logger.info("Consumer: Waiting to exchange baskets ...");
                    basket = exchanger.exchange(basket);
                    logger.info(() -> "Consumer: Received the following bulbs: " + basket);

                    for (String bulb : basket) {
                        if (bulb != null) {
                            Thread.sleep(rnd.nextInt(MAX_CONS_TIME_MS));
                            logger.info(() -> "Packed from basket: " + bulb);
                        }
                    }

                    basket.clear();
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception: " + ex);
                    break;
                }
            }
        }

    }

    public static void startAssemblyLine() {

        if (runningProducer || runningConsumer) {
            logger.info("Assembly line is already running ...");
            return;
        }

        logger.info("\n\nStarting assembly line ...");

        runningProducer = true;
        producerService = Executors.newSingleThreadExecutor();
        producerService.execute(producer);

        runningConsumer = true;
        consumerService = Executors.newSingleThreadExecutor();
        consumerService.execute(consumer);
    }

    public static void stopAssemblyLine() {

        logger.info("Stopping assembly line ...");

        boolean isProducerDown = shutdownProducer();
        boolean isConsumerDown = shutdownConsumer();

        if (!isProducerDown || !isConsumerDown) {
            logger.severe("Something abnormal happened during shutting down the assembling line!");
            System.exit(0);
        }

        logger.info("Assembling line was successfully stopped!");
    }

    private static boolean shutdownProducer() {

        runningProducer = false;
        return shutdownExecutor(producerService);
    }

    private static boolean shutdownConsumer() {

        runningConsumer = false;
        return shutdownExecutor(consumerService);
    }

    private static boolean shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();

                return executor.awaitTermination(TIMEOUT_MS, TimeUnit.MILLISECONDS);
            }

            return true;
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception: " + ex);
        }
        return false;
    }
}
