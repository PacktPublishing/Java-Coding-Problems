package modern.challenge;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        Thread thread = new Thread(() -> {

            TransferQueue<String> queue = new LinkedTransferQueue<>();

            while (!Thread.currentThread().isInterrupted()) {

                try {
                    logger.info(() -> "For 3 seconds the thread "
                            + Thread.currentThread().getName()
                            + " will try to poll an element from queue ...");

                    queue.poll(3000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException ex) {
                    logger.severe(() -> "InterruptedException! The thread "
                            + Thread.currentThread().getName() + " was intrrupted!");
                    Thread.currentThread().interrupt(); // comment this line to see the effect
                }
            }

            logger.info(() -> "The execution was stopped!");
        });

        thread.start();
        Thread.sleep(1500);
        thread.interrupt();
    }

}
