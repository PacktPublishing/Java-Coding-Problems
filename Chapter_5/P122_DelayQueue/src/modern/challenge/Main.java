package modern.challenge;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final long LOS_ANGELES_DELAY_MS = 10000L; // delay 10s
        final long DETROIT_DELAY_MS = 15000L; // delay 15s        
        final long HUSTON_DELAY_MS = 30000L; // delay 30s

        final long WAIT_MS = 16000; // wait 16s

        BlockingQueue<TrainDelay> queue = new DelayQueue<>();

        // produce 3 trains with different delays 
        TrainDelay trainToDetroit
                = new TrainDelay(UUID.randomUUID().toString(), "Detroit", DETROIT_DELAY_MS);
        TrainDelay trainToLosAngeles
                = new TrainDelay(UUID.randomUUID().toString(), "Los Angeles", LOS_ANGELES_DELAY_MS);
        TrainDelay trainToHuston
                = new TrainDelay(UUID.randomUUID().toString(), "Huston", HUSTON_DELAY_MS);

        // enqueue the trains order ascending by delay
        // the order is ensured by the TrainDelay#compareTo() implementation
        // use put() if you want to wait for space to be available
        queue.offer(trainToDetroit); // delay 15s               
        queue.offer(trainToLosAngeles); // delay: 10s   
        queue.offer(trainToHuston); // delay 30s                  

        // consume trains, we arbitrary decided to wait 16s until polling
        // after 16s, we can access the Los Angeles and Detroit trains, 
        // but not the Huston (this train still has 14s delay)
        System.out.println("Waiting 16s ...");
        Thread.sleep(WAIT_MS);

        System.out.println("Train: " + queue.poll()); // Los Angeles        
        System.out.println("Train: " + queue.poll()); // Detroit
        // use take() to wait until a train is available
        System.out.println("Train: " + queue.poll()); // null
    }
}
