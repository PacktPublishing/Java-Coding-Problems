package modern.challenge;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public final class MappingCount {

    private MappingCount() {
        throw new AssertionError("Cannot be instantiated");
    }

    private static final Logger logger = Logger.getLogger(MappingCount.class.getName());
    
    private static final ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
    private static final AtomicInteger count = new AtomicInteger();

    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();
    private static final ExecutorService producerService
            = Executors.newFixedThreadPool(10);
    private static final ExecutorService consumerService
            = Executors.newSingleThreadExecutor();

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                int item = (int) (Math.random() * 1000);
                // logger.info(() -> "Produced: " + item
                //        + " by " + Thread.currentThread().getName());
                map.put(count.incrementAndGet(), item);
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                logger.info(()
                        -> "Mapping count: " + map.mappingCount()
                        + " | Count via atomic variable: " + count.get()
                        + " | Size: " + map.size());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        for (int i = 0; i < 10; i++) {
            producerService.execute(producer);
        }
        
        consumerService.execute(consumer);

        // since the producer and consumer run in a while(true) the application must be stopped manually
    }
}
