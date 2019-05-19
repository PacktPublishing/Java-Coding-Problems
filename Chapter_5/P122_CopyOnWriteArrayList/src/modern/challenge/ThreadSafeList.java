package modern.challenge;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ThreadSafeList {

    private static final Logger logger = Logger.getLogger(ThreadSafeList.class.getName());

    // Switch to ArrayList to generate a java.util.ConcurrentModificationException.
    // This is caused by the iteration of the list during adding more items
    // private static final List<Integer> list = new ArrayList<>();
    private static final List<Integer> list = new CopyOnWriteArrayList<>();

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
                list.add(item);
                logger.info(() -> "Produced: " + item
                        + " by " + Thread.currentThread().getName());
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                Iterator<Integer> iterator = list.listIterator();
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

        public void consume(Integer value) {

            String threadName = Thread.currentThread().getName();
            System.out.printf("[%s] consumed: %s\n", threadName, value);
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
