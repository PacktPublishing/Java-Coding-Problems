package modern.challenge;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ThreadSafeQueue {

    private static final Logger logger = Logger.getLogger(ThreadSafeQueue.class.getName());

    // Switching to PriorityQueue will cause NullPointerException    
    // private static final Queue<Integer> queue = new PriorityQueue<>();
    private static final BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        logger.info("Enqueue ...");

        // enqueue 10 values using a single thread
        for (int i = 0; i < 10; i++) {

            int item = (int) (Math.random() * 1000);
            logger.info(() -> "Produced: " + item 
                    + " by " + Thread.currentThread().getName());

            queue.offer(item);
        }

        logger.info("Dequeue ...");

        // dequeue values using 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {                
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                Integer item = queue.poll();
                if (item != null) {
                    logger.info(() -> "Consumed: " + item
                            + " by " + Thread.currentThread().getName());
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);

        logger.info("All the threads have ended successfully");
    }
}
