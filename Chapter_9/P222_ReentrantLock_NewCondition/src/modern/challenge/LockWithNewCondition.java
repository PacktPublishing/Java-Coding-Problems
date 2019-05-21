package modern.challenge;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class LockWithNewCondition {

    private static final Logger logger
            = Logger.getLogger(LockWithNewCondition.class.getName());

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    public void executeByT1() throws InterruptedException {

        lock.lock();

        try {
            logger.info(() -> "Thread " + Thread.currentThread().getName()
                    + " waits for 't2' to signal the condition ...");

            // When await() is called the thread releases the lock.
            // After getting the signal to continue the thread must acquire the lock again.
            condition.await(); 

            Thread.sleep(2000);
            logger.info(() -> "Thread " + Thread.currentThread().getName()
                    + " has finished its execution ...");
        } finally {
            lock.unlock();
        }       
    }

    public void executeByT2() throws InterruptedException {

        lock.lock();

        try {
            logger.info(() -> "Thread " + Thread.currentThread().getName()
                    + " signaled the condition ...");
            
            // The condition signal() is triggered. This thread holds the lock,
            // therefore 't1' will wait until this thread finishes is tasks.
            condition.signal();

            Thread.sleep(2000);
            logger.info(() -> "Thread " + Thread.currentThread().getName()
                    + " has finished its execution ...");
        } finally {
            lock.unlock();
        }        
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        LockWithNewCondition lockWithNewCondition = new LockWithNewCondition();

        Runnable taskT1 = () -> {
            try {
                lockWithNewCondition.executeByT1();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                logger.severe(() -> "Exception: " + ex);
            }
        };

        Runnable taskT2 = () -> {
            try {
                lockWithNewCondition.executeByT2();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                logger.severe(() -> "Exception: " + ex);
            }
        };

        Thread t1 = new Thread(taskT1, "t1");
        t1.start();

        // give time to thread 't1' to acquire the lock
        Thread.sleep(2000);

        Thread t2 = new Thread(taskT2, "t2");
        t2.start();
    }
}
