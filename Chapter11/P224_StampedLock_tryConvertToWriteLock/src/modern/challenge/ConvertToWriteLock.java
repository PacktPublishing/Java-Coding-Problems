package modern.challenge;

import java.util.concurrent.locks.StampedLock;

public class ConvertToWriteLock {

    private final StampedLock lock = new StampedLock();

    private int balance = 1000;

    public void withdraw(int amount) {

        long stamp = lock.readLock();
        try {
            while (amount <= balance) {
                long convertStamp = lock.tryConvertToWriteLock(stamp);

                if (convertStamp != 0L) {
                    System.out.println("Lock successfully converted ...");
                    
                    stamp = convertStamp;
                    balance = balance - amount;

                    System.out.println("New balance: " + balance);
                    break;
                } else {
                    lock.unlockRead(stamp);
                    stamp = lock.writeLock();
                }
            }
        } finally {
            lock.unlock(stamp);
        }
    }
}
