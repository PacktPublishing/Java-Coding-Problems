package modern.challenge;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

// this code should produce a java.lang.InterruptedException

public class LockInterruptibly {

    private static final Logger logger 
            = Logger.getLogger(LockInterruptibly.class.getName());

    private static final ReentrantLock lock = new ReentrantLock();
    
    public void infiniteRun() throws InterruptedException {
        
        // switching to lock() will ignore the interruption
        lock.lockInterruptibly(); 

        try {
            while (true) {                
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        LockInterruptibly lockInterruptibly = new LockInterruptibly();

        Runnable task = () -> {
            try {
                lockInterruptibly.infiniteRun();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                logger.severe(() -> "Exception: " + ex);
            }
        };

        Thread t = new Thread(task);
        t.start();

        // the main thread interrupts 't'
        t.interrupt();
    }

}
