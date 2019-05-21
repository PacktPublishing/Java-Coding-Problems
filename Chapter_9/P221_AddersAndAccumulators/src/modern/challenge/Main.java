package modern.challenge;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        AtomicAdder atomicAdder = new AtomicAdder();
        AtomicAccumulator atomicAcc = new AtomicAccumulator();
        
        ExecutorService executor = Executors.newFixedThreadPool(5);

        System.out.println("Counting via atomic adder ...");
        for (int i = 0; i < 1_000_000; i++) {
            executor.execute(atomicAdder);
        }
        
        System.out.println("Counting via atomic accumulator ...");
        for (int i = 0; i < 1_000_000; i++) {
            executor.execute(atomicAcc);
        }

        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);

        System.out.println("Atomic adder counting result (expected 1_000_000): "
                + atomicAdder.getCount());
        System.out.println("Atomic accumultor counting result (expected 1_000_000): "
                + atomicAcc.getCount());
    }

}
