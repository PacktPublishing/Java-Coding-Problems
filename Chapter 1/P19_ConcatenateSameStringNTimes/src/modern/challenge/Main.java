package modern.challenge;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final String TEXT = "hello";

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("StringBuilder solution:");
        long startTimeV1 = System.nanoTime();

        String resultV1 = Strings.concatRepeat(TEXT, 5);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Result: \n" + resultV1);

        System.out.println();
        System.out.println("String.repeat() solution:");
        long startTimeV2 = System.nanoTime();

        String resultV2 = TEXT.repeat(5);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Result: \n" + resultV2);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
