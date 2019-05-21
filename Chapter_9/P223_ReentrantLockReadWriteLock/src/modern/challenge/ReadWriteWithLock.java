package modern.challenge;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;

public class ReadWriteWithLock {

    private static final Logger logger = Logger.getLogger(ReadWriteWithLock.class.getName());
    private static final Random rnd = new Random();

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);    
    private static final Reader reader = new Reader();
    private static final Writer writer = new Writer();
    
    private static int amount;

    private static class Reader implements Runnable {

        @Override
        public void run() {
            if (lock.isWriteLocked()) {
                logger.warning(() -> Thread.currentThread().getName() 
                        + " reports that the lock is hold by a writer ...");                
            }

            lock.readLock().lock();
            try {
                logger.info(() -> "Read amount: " + amount 
                        + " by "+ Thread.currentThread().getName());
            } finally {
                lock.readLock().unlock();
            }
        }
    }

    private static class Writer implements Runnable {

        @Override
        public void run() {

            lock.writeLock().lock();
            try {                                
                Thread.sleep(rnd.nextInt(2000));

                logger.info(() -> "Increase amount with 10 by " + Thread.currentThread().getName());
                amount += 10;

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                logger.severe(() -> "Exception: " + ex);
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        // perform 10 reads and 10 writes with 2 readers and 4 writers
        ExecutorService readerService = Executors.newFixedThreadPool(2);
        ExecutorService writerService = Executors.newFixedThreadPool(4);
        
        for (int i = 0; i < 10; i++) {
            readerService.execute(reader);
            writerService.execute(writer);
        }

        readerService.shutdown();
        writerService.shutdown();
        readerService.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        writerService.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

}
