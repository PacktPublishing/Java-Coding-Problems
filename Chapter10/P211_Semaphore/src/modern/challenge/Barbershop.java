package modern.challenge;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Barbershop {

    private static final Logger logger = Logger.getLogger(Barbershop.class.getName());

    private final Semaphore seats;

    public Barbershop(int seatsCount) {
        this.seats = new Semaphore(seatsCount, true);
    }

    public boolean acquireSeat(int customerId) {
        logger.info(() -> "Customer #" + customerId + " is trying to get a seat");

        try {
            boolean acquired = seats.tryAcquire(5 * 1000, TimeUnit.MILLISECONDS);

            if (!acquired) {
                logger.info(() -> "Customer #" + customerId + " has left the barbeshop");
                return false;
            }

            logger.info(() -> "Customer #" + customerId + " got a seat");

            return true;
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception: " + ex);
        }

        return false;
    }

    public void releaseSeat(int customerId) {

        logger.info(() -> "Customer #" + customerId + " has released a seat");
        seats.release();
    }
}
