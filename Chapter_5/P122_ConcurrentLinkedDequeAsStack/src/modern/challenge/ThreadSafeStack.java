package modern.challenge;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ThreadSafeStack {

    private static final Logger logger = Logger.getLogger(ThreadSafeStack.class.getName());

    // A ConcurrentLinkedDeque implementation can be used as a Stack (Last-In-First-Out) 
    // Switch to ArrayDeque to see how pop is trying to pop
    // the same item in different threads because ArrayDeque is not thread-safe
    // private static Deque<Integer> stack = new ArrayDeque<>();
    private static Deque<Integer> stack = new ConcurrentLinkedDeque<>();

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        logger.info("Push ...");

        // push values for 1 to 10 using a single thread
        for (int i = 0; i < 10; i++) {
            int item = i + 1;
            logger.info(() -> "Produced: " + item
                    + " by " + Thread.currentThread().getName());
            stack.push(item);
        }

        logger.info("Pop ... ");

        // pop values using 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

                Integer item = stack.pop();
                logger.info(() -> "Consumed: " + item
                        + " by " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);

        logger.info("All the threads have ended successfully");
    }
}
