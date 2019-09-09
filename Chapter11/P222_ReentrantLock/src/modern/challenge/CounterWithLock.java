package modern.challenge;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class CounterWithLock {

    private static final Logger logger = Logger.getLogger(CounterWithLock.class.getName());

    private static final Lock lock = new ReentrantLock();
    private static int count;

    public void counter() {
        lock.lock();

        try {
            count++;
            // logger.info(() -> "Count value: " + count
            //        + " | Thread: " + Thread.currentThread().getName());                       
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        CounterWithLock counterWithLock = new CounterWithLock();

        Runnable task = () -> {
            counterWithLock.counter();
        };

        ExecutorService executor = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 1_000_000; i++) {
            executor.execute(task);
        }

        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);

        logger.info(() -> "Final result: " + count);
    }

}
