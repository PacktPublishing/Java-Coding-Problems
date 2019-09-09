package modern.challenge;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final String TEXT = "!ABCBA;C D E-D  D  DFA;";

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("StringBuilder and indexOf() solution:");
        long startTimeV1 = System.nanoTime();

        String resultV1 = Strings.removeDuplicatesV1(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("String with no duplicates: \n" + resultV1);

        System.out.println();
        System.out.println("LinkedHashSet and StringBuilder solution:");
        long startTimeV2 = System.nanoTime();

        String resultV2 = Strings.removeDuplicatesV2(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("String with no duplicates: \n" + resultV2);

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV3 = System.nanoTime();

        String resultV3 = Strings.removeDuplicatesV3(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("String with no duplicates: \n" + resultV3);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
