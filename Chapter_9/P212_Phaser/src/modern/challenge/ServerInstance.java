package modern.challenge;

import java.util.concurrent.Phaser;
import java.util.logging.Logger;

public class ServerInstance implements Runnable {

    private static final Logger logger = Logger.getLogger(ServerInstance.class.getName());

    private final Phaser phaser = new Phaser(1) {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {

            logger.warning(() -> "Phase:" + phase
                    + " Registered parties: " + registeredParties);

            return registeredParties == 0;
        }
    };

    @Override
    public void run() {
        long starting = System.currentTimeMillis();

        logger.info("The server is getting ready to start\n");

        logger.info("Starting the first three services ...");
        startFirstThreeServices();
        
        logger.info("Starting the next two services ...");
        startNextTwoServices();

        logger.info("All services are running ... final check in ...\n");
        finalCheckIn();

        logger.info(() -> "Server was successfully started in "
                + (System.currentTimeMillis() - starting) / 1000 + " seconds");

        logger.warning(() -> "Phaser is terminated: " + phaser.isTerminated()
                + " | " + phaser.getRegisteredParties());
    }

    private void startFirstThreeServices() {
        Thread service1 = new Thread(new ServerService(phaser, "HTTP Listeners"));
        Thread service2 = new Thread(new ServerService(phaser, "JMX"));
        Thread service3 = new Thread(new ServerService(phaser, "Connectors"));

        service1.start();
        service2.start();
        service3.start();

        phaser.arriveAndAwaitAdvance(); // phase 0
    }

    private void startNextTwoServices() {
        Thread service4 = new Thread(new ServerService(phaser, "Virtual Hosts"));
        Thread service5 = new Thread(new ServerService(phaser, "Ports"));

        service4.start();
        service5.start();

        phaser.arriveAndAwaitAdvance(); // phase 1
    }

    private void finalCheckIn() {
        try {
            logger.info("Finalizing process (should take 2 seconds) ...");
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception: " + ex);
        } finally {
            phaser.arriveAndDeregister(); // phase 2
        }
    }
}
