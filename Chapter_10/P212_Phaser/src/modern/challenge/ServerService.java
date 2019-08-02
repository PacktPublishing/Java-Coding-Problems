package modern.challenge;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.logging.Logger;

public class ServerService implements Runnable {

    private static final Logger logger = Logger.getLogger(ServerService.class.getName());

    private final String serviceName;
    private final Phaser phaser;
    private final Random rnd = new Random();

    public ServerService(Phaser phaser, String serviceName) {
        this.phaser = phaser;
        this.serviceName = serviceName;
        this.phaser.register();
    }

    @Override
    public void run() {

        int startingIn = rnd.nextInt(10) * 1000;

        try {
            logger.info(() -> "Starting service '" + serviceName + "' ...");
            Thread.sleep(startingIn);

            logger.info(() -> "Service '" + serviceName
                    + "' was started in " + startingIn / 1000
                    + " seconds (waiting for remaining services)");

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception: " + ex);
        } finally {
            phaser.arriveAndDeregister();
        }
    }

}
