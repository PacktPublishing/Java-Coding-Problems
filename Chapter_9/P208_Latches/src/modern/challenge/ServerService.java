package modern.challenge;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

public class ServerService implements Runnable {

    private static final Logger logger = Logger.getLogger(ServerService.class.getName());

    private final String serviceName;
    private final CountDownLatch latch;
    private final Random rnd = new Random();

    public ServerService(CountDownLatch latch, String serviceName) {
        this.latch = latch;
        this.serviceName = serviceName;
    }

    @Override
    public void run() {

        int startingIn = rnd.nextInt(10) * 1000;

        try {
            logger.info(() -> "Starting service '" + serviceName + "' ...");
            Thread.sleep(startingIn);

            logger.info(() -> "Service '" + serviceName
                    + "' has successfully started in " + startingIn / 1000 + " seconds");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // log ex
        } finally {
            latch.countDown();
            logger.info(() -> "Service '" + serviceName + "' running ...");
        }
    }

}
