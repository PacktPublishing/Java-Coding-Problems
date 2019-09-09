package modern.challenge;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public final class AssemblyLine {

    private AssemblyLine() {
        throw new AssertionError("There is a single assembly line!");
    }

    private static final int MAX_NUMBER_OF_CONSUMERS = 50;
    private static final int MAX_QUEUE_SIZE_ALLOWED = 5;
    private static final int MONITOR_QUEUE_INITIAL_DELAY_MS = 5000;
    private static final int MONITOR_QUEUE_RATE_MS = 3000;
    private static final int EXTRA_TIME_MS = 4 * 1000;
    private static final int SLOW_DOWN_PRODUCER_MS = 20 * 1000;

    private static final int MAX_PROD_TIME_MS = 1 * 1000;
    private static final int MAX_CONS_TIME_MS = 10 * 1000;
    private static final int TIMEOUT_MS = MAX_PROD_TIME_MS + MAX_CONS_TIME_MS + 1000;

    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());

    private static final Random rnd = new Random();
    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private static final ThreadGroup threadGroup = new ThreadGroup("consumers");
    private static final AtomicInteger nrOfConsumers = new AtomicInteger();

    private static volatile boolean runningProducer;
    private static volatile boolean runningConsumer;
    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();

    private static int extraProdTime;
    private static ExecutorService producerService;
    private static ExecutorService consumerService;
    private static ScheduledExecutorService monitorService;
    private static ScheduledExecutorService slowdownerService;

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (runningProducer) {
                try {
                    String bulb = "bulb-" + rnd.nextInt(1000);

                    Thread.sleep(rnd.nextInt(MAX_PROD_TIME_MS) + extraProdTime);

                    queue.offer(bulb);

                    logger.info(() -> "Checked: " + bulb);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception: " + ex);
                    break;
                }
            }
        }

    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (runningConsumer && queue.size() > 0
                    || nrOfConsumers.get() == 1) {
                try {
                    String bulb = queue.poll(MAX_PROD_TIME_MS + extraProdTime, TimeUnit.MILLISECONDS);

                    if (bulb != null) {
                        Thread.sleep(rnd.nextInt(MAX_CONS_TIME_MS));
                        logger.info(() -> "Packed: " + bulb + " by consumer: "
                                + Thread.currentThread().getName());
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception close: " + ex);
                    break;
                }
            }

            nrOfConsumers.decrementAndGet();
            logger.warning(() -> "### Thread " + Thread.currentThread().getName()
                    + " is going back to the pool in 60 seconds for now!");
        }

    }

    public static void startAssemblyLine() {

        if (runningProducer || runningConsumer) {
            logger.info("Assembly line is already running ...");
            return;
        }

        logger.info("\n\nStarting assembly line ...");
        logger.info(() -> "Remaining bulbs from previous run: \n" + queue + "\n\n");

        runningProducer = true;
        producerService = Executors.newSingleThreadExecutor();
        producerService.execute(producer);

        runningConsumer = true;
        consumerService = Executors
                .newCachedThreadPool((Runnable r) -> new Thread(threadGroup, r));

        nrOfConsumers.incrementAndGet();
        consumerService.execute(consumer);

        monitorQueueSize();
        slowdownProducer();
    }

    public static void stopAssemblyLine() {

        logger.info("Stopping assembly line ...");

        boolean isProducerDown = shutdownProducer();
        boolean isConsumerDown = shutdownConsumer();
        boolean isSchedulersDown = shutdownSchedulers();

        if (!isProducerDown || !isConsumerDown || !isSchedulersDown) {
            logger.severe("Something abnormal happened during shutting down the assembling line!");
            System.exit(0);
        }

        logger.info("Assembling line was successfully stopped!");
        logger.info("Monitoring queue successfully stopped!");
        logger.info("Slow downer of producer successfully stopped!");
    }

    private static void monitorQueueSize() {
        monitorService = Executors.newSingleThreadScheduledExecutor();
        monitorService.scheduleAtFixedRate(() -> {

            if (queue.size() > MAX_QUEUE_SIZE_ALLOWED 
                    && threadGroup.activeCount() < MAX_NUMBER_OF_CONSUMERS) {
                logger.warning("### Adding a new consumer (command) ...");

                nrOfConsumers.incrementAndGet();
                consumerService.execute(consumer);
            }

            logger.warning(() -> "### Bulbs in queue: " + queue.size()
                    + " | Active threads: " + threadGroup.activeCount()
                    + " | Consumers: " + nrOfConsumers.get()
                    + " | Idle: " + (threadGroup.activeCount() - nrOfConsumers.get()));
        }, MONITOR_QUEUE_INITIAL_DELAY_MS, MONITOR_QUEUE_RATE_MS, TimeUnit.MILLISECONDS);
    }

    private static void slowdownProducer() {
        slowdownerService = Executors.newSingleThreadScheduledExecutor();
        slowdownerService.schedule(() -> {
            logger.warning("### Slow down producer ...");
            extraProdTime = EXTRA_TIME_MS;
        }, SLOW_DOWN_PRODUCER_MS, TimeUnit.MILLISECONDS);
    }

    private static boolean shutdownProducer() {

        runningProducer = false;
        return shutdownExecutor(producerService);
    }

    private static boolean shutdownConsumer() {

        runningConsumer = false;
        nrOfConsumers.set(0);
        return shutdownExecutor(consumerService);
    }

    private static boolean shutdownSchedulers() {
        if (!runningProducer || !runningConsumer) {
            return shutdownExecutor(monitorService) && shutdownExecutor(slowdownerService);
        }

        return false;
    }

    private static boolean shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_MS + extraProdTime, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();

                return executor.awaitTermination(TIMEOUT_MS + extraProdTime, TimeUnit.MILLISECONDS);
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
