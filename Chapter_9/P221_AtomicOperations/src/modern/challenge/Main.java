package modern.challenge;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("updateAndGet(), accumulateAndGet():");
        AtomicIntegerArray atomicArray = new AtomicIntegerArray(new int[]{3, 4, 2, 5});
        for (int i = 0; i < atomicArray.length(); i++) {
            atomicArray.updateAndGet(i, elem -> elem * elem);
        }
        System.out.println("Result: " + atomicArray);

        AtomicInteger nr1 = new AtomicInteger(3);
        int result1 = nr1.accumulateAndGet(5, (x, y) -> x * y); // x = 3, y = 5

        AtomicInteger nr2 = new AtomicInteger(3);
        int result2 = nr2.updateAndGet(x -> 5 * x);

        System.out.println("Result (nr1): " + result1);
        System.out.println("Result (nr2): " + result2);

        System.out.println("\naddAndGet():");
        AtomicInteger nr3 = new AtomicInteger(3);
        int result3 = nr3.addAndGet(4);
        System.out.println("Result (nr3): " + result3);

        System.out.println("\ncompareAndSet():");
        AtomicInteger nr4 = new AtomicInteger(3);
        boolean wasSet = nr4.compareAndSet(3, 5);
        System.out.println("Result (nr4): " + nr4.get() + " Was set: " + wasSet);
    }

}
