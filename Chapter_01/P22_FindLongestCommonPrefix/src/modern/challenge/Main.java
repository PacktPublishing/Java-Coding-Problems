package modern.challenge;

import java.util.concurrent.TimeUnit;

public class Main {

    private static String[] texts = {"abc", "abcd", "abcde", "ab", "abcd", "abcdef"};

    public static void main(String[] args) {

        System.out.println("Simple comparison solution:");
        long startTimeV1 = System.nanoTime();

        String resultV1 = Strings.longestCommonPrefixV1(texts);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Result: " + resultV1);

        System.out.println();
        System.out.println("Binary Search solution:");
        long startTimeV2 = System.nanoTime();

        String resultV2 = Strings.longestCommonPrefixV2(texts);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Result: " + resultV2);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
