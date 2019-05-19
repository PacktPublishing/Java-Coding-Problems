package modern.challenge;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ThreadSafeSet {

    private static final Logger logger = Logger.getLogger(ThreadSafeSet.class.getName());

    // Switch to HashSet to see how java.util.ConcurrentModificationException.
    // This is caused by the iteration of the set during adding more elements
    // private static Set<Integer> set = new HashSet<>();
    private static Set<Integer> set = new CopyOnWriteArraySet<>();

    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();
    private static ExecutorService producerService
            = Executors.newSingleThreadExecutor();
    private static ExecutorService consumerService
            = Executors.newSingleThreadExecutor();

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                int item = (int) (Math.random() * 1000);
                set.add(item);
                logger.info(() -> "Produced: " + item
                        + " by " + Thread.currentThread().getName());
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                Iterator<Integer> iterator = set.iterator();
                while (iterator.hasNext()) {
                    try {
                        logger.info(() -> "Consumed: " + iterator.next()
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
