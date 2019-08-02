package modern.challenge;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Logger;

public class ServerService implements Runnable {

    private static final Logger logger = Logger.getLogger(ServerService.class.getName());

    private final String serviceName;
    private final CyclicBarrier barrier;
    private final Random rnd = new Random();

    public ServerService(CyclicBarrier barrier, String serviceName) {
        this.barrier = barrier;
        this.serviceName = serviceName;
    }

    @Override
    public void run() {

        int startingIn = rnd.nextInt(10) * 1000;

        try {
            logger.info(() -> "Preparing service '" + serviceName + "' ...");
            Thread.sleep(startingIn);

            logger.info(() -> "Service '" + serviceName
                    + "' was prepared in " + startingIn / 1000 
                    + " seconds (waiting for remaining services)");
            
            barrier.await();

            logger.info(() -> "The service '" + serviceName + "' is running ...");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception: " + ex);
        } catch (BrokenBarrierException ex) {
            logger.severe(() -> "Exception ... barrier is broken! " + ex);
        }
    }

}
