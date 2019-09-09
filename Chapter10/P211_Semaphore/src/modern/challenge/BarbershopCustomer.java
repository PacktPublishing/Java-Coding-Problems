package modern.challenge;

import java.util.Random;
import java.util.logging.Logger;

public class BarbershopCustomer implements Runnable {

    private static final Logger logger = Logger.getLogger(BarbershopCustomer.class.getName());
    private static final Random rnd = new Random();

    private final Barbershop barbershop;
    private final int customerId;

    public BarbershopCustomer(Barbershop barbershop, int customerId) {
        this.barbershop = barbershop;
        this.customerId = customerId;
    }

    @Override
    public void run() {

        boolean acquired = barbershop.acquireSeat(customerId);

        if (acquired) {
            try {
                Thread.sleep(rnd.nextInt(10 * 1000));
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                logger.severe(() -> "Exception: " + ex);
            } finally {
                barbershop.releaseSeat(customerId);
            }
        } else {
            Thread.currentThread().interrupt();
        }
    }

}
