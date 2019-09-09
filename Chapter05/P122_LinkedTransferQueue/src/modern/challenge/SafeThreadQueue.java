package modern.challenge;

import com.sun.tools.javac.Main;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.logging.Logger;

public class SafeThreadQueue {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static final TransferQueue<String> queue = new LinkedTransferQueue<>();

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        // Prepare 5 producers as threads.
        // These will use transfer() in order to block until the items are consumed.
        // At this moment there are no consumers, so 5 threads will produce 5 of 10 items
        // and block until they are free by consumers; once the items starts to be consumed
        // they will continue to produce the remaining 5 items.
        ExecutorService executorProducer = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executorProducer.execute(() -> {
                try {
                    String item = UUID.randomUUID().toString();
                    logger.info(() -> " Produced: " + item
                            + " by " + Thread.currentThread().getName());

                    queue.transfer(item);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        };

        // prepare 3 consumers as threads        
        ExecutorService executorConsumer = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executorConsumer.execute(() -> {
                try {
                    String item = queue.take();
                    logger.info(() -> " Consumed: " + item
                            + " by " + Thread.currentThread().getName());
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executorProducer.shutdown();
        executorConsumer.shutdown();

        executorProducer.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        executorConsumer.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        
        logger.info("All the threads have ended successfully");
    }
}
