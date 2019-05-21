package modern.challenge;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Incrementator nonAtomicInc = new Incrementator();
        AtomicIncrementator atomicInc = new AtomicIncrementator();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        System.out.println("Counting via non atomic incrementator ...");
        for (int i = 0; i < 1_000_000; i++) {
            executor.execute(nonAtomicInc);
        }

        System.out.println("Counting via atomic incrementator ...");
        for (int i = 0; i < 1_000_000; i++) {
            executor.execute(atomicInc);
        }

        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);

        System.out.println("Non atomic counting result (expected 1_000_000): " + nonAtomicInc.getCount());
        System.out.println("Atomic counting result (expected 1_000_000): " + atomicInc.getCount());
    }

}
