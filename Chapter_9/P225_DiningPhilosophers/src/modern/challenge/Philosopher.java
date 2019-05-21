package modern.challenge;

import java.util.Random;
import java.util.logging.Logger;

public class Philosopher implements Runnable {

    private static final Logger logger = Logger.getLogger(Philosopher.class.getName());
    private static final Random rnd = new Random();

    private final String leftFork;
    private final String rightFork;

    public Philosopher(String leftFork, String rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {

        while (true) {
            logger.info(() -> Thread.currentThread().getName() + ": thinking");
            doIt();
            synchronized (leftFork) {
                logger.info(() -> Thread.currentThread().getName()
                        + ": took the left fork (" + leftFork + ")");
                doIt();
                synchronized (rightFork) {
                    logger.info(() -> Thread.currentThread().getName()
                            + ": took the right fork (" + rightFork + ") and eating");
                    doIt();
                    logger.info(() -> Thread.currentThread().getName()
                            + ": put the right fork ( " + rightFork + ") on the table");
                    doIt();
                }
                logger.info(() -> Thread.currentThread().getName()
                        + ": put the left fork (" + leftFork + ") on the table and thinking");
                doIt();
            }
        }
    }

    private static void doIt() {
        try {
            Thread.sleep(rnd.nextInt(2000));
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception: " + ex);
        }
    }
}
