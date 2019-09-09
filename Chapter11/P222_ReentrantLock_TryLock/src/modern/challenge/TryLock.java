package modern.challenge;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class TryLock {

    private static final Logger logger
            = Logger.getLogger(TryLock.class.getName());

    private static final ReentrantLock lock = new ReentrantLock();

    public boolean execute() throws InterruptedException {

        if (!lock.tryLock(3, TimeUnit.SECONDS)) {
            logger.info(() -> "Acquiring the lock attempt failed via "
                    + Thread.currentThread().getName());
            return false;
        } else {
            logger.info(() -> "The lock  was successfully acquired by "
                    + Thread.currentThread().getName());
        }

        try {
            logger.info(() -> "Thread " + Thread.currentThread().getName()
                    + " started its execution ...");
            Thread.sleep(15000);
            logger.info(() -> "Thread " + Thread.currentThread().getName()
                    + " finished its execution ...");
        } finally {
            lock.unlock();
        }

        return true;
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        TryLock tryLock = new TryLock();

        Runnable task = () -> {
            try {
                while (!tryLock.execute()) {}
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                logger.severe(() -> "Exception: " + ex);
            }
        };

        Thread t1 = new Thread(task, "t1");
        t1.start();

        // give time to thread 't1' to acquire the lock
        Thread.sleep(1000);

        Thread t2 = new Thread(task, "t2");
        t2.start();
    }
}
