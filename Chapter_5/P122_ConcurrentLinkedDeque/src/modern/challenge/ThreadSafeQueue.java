package modern.challenge;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ThreadSafeQueue {

    private static final Logger logger = Logger.getLogger(ThreadSafeQueue.class.getName());

    // Switch to ArrayDeque to see how the same item is consumed multiple times.
    // Since poll() retrieves and removes the head of this queue this should not happen.  
    // private static final Queue<Integer> queue = new ArrayDeque<>();
    private static final Queue<Integer> queue = new ConcurrentLinkedDeque<>();

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        logger.info("Enqueue ...");

        // enqueue values 1-10 using a single thread
        for (int i = 0; i < 10; i++) {
            int item = i + 1;            
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
