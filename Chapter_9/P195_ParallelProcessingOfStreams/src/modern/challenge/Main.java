package modern.challenge;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int noOfProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("This machine has " + noOfProcessors + " processors\n");

        Clock clock = Clock.systemUTC();
        Random rnd = new Random();
        List<Double> numbers = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            numbers.add(rnd.nextDouble());
        }

        long startTimeV1 = clock.millis();
        double result1 = numbers.stream()
                .reduce((a, b) -> a + b).orElse(-1d);
        displayExecutionTime(clock.millis() - startTimeV1);
        System.out.println("Sequential sum: " + result1);

        long startTimeV2 = clock.millis();
        double result2 = numbers.parallelStream()
                .reduce((a, b) -> a + b).orElse(-1d);
        displayExecutionTime(clock.millis() - startTimeV2);
        System.out.println("Parallel sum: " + result2);

        long startTimeV3 = clock.millis();
        double result3 = numbers.stream()
                .parallel()
                .reduce((a, b) -> a + b).orElse(-1d);
        displayExecutionTime(clock.millis() - startTimeV3);
        System.out.println("Parallel sum: " + result3);

        ForkJoinPool customThreadPool = new ForkJoinPool(5);
        long startTimeV4 = clock.millis();
        double result4 = customThreadPool.submit(
                () -> numbers.parallelStream().reduce((a, b) -> a + b)).get().orElse(-1d);
        displayExecutionTime(clock.millis() - startTimeV4);
        System.out.println("Parallel sum: " + result4);

    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ms" + " ("
                + TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS) + " s)");
    }
}
