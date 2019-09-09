package modern.challenge;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ThreadSafeMap {

    private static final Logger logger = Logger.getLogger(ThreadSafeMap.class.getName());

    // Switch to HashMap to generate a java.util.ConcurrentModificationException.
    // This is caused by the iteration of the map during adding more items
    // private static final Map<Integer, Integer> map = new HashMap<>();
    private static final ConcurrentMap<Integer, Integer> map = new ConcurrentHashMap<>();

    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();
    private static final ExecutorService producerService
            = Executors.newSingleThreadExecutor();
    private static final ExecutorService consumerService
            = Executors.newSingleThreadExecutor();

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                int item = (int) (Math.random() * 1000);
                map.put(item, item);
                logger.info(() -> "Produced: " + item
                        + " by " + Thread.currentThread().getName());
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                Iterator<Integer> iterator = map.keySet().iterator();
                while (iterator.hasNext()) {
                    try {
                        Integer item = iterator.next();
                        logger.info(() -> "Consumed: " + item
                                + " by " + Thread.currentThread().getName());
                    } catch (ConcurrentModificationException e) {
                        logger.severe(() -> "Exception: " + e);
                        System.exit(0);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        producerService.execute(producer);
        consumerService.execute(consumer);

        // since the producer and consumer run in a while(true) the application must be stopped manually
    }
}
