package modern.challenge;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ThreadSafeQueue {

    private static final Logger logger = Logger.getLogger(ThreadSafeQueue.class.getName());

    private static final BlockingQueue<String> queue = new SynchronousQueue<>();

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> {

            try {
                String item = queue.take();
                logger.info(() -> "Consumed: " + item
                        + " by " + Thread.currentThread().getName());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        });

        logger.info("Sleep 5 seconds ...");
        // take a sleep
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        logger.info("Enqueue ...");
        // only this will be enqueue, since there is a single consumer waiting
        queue.offer("Rafael Nadal");
        // the following two will not be enqueue
        queue.offer("Roger Federer");
        queue.offer("David Ferer");
        logger.info("Done ...");

        // this will return 0
        logger.info(() -> "Queue size: " + queue.size());

        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);

        logger.info("All the threads have ended successfully");
    }

}
