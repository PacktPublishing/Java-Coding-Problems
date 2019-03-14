package modern.challenge;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final String TEXT = "ABCDEFEDCBA";

    public static void main(String[] args) {

        System.out.println("Meet-in-the-middle 'while' solution:");
        long startTimeV1 = System.nanoTime();

        boolean resultV1 = Strings.isPalindromeV1(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("'" + TEXT + "' is palindrome? " + resultV1);

        System.out.println();
        System.out.println("Meet-in-the-middle using 'for' solution:");
        long startTimeV2 = System.nanoTime();

        boolean resultV2 = Strings.isPalindromeV2(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("'" + TEXT + "' is palindrome? " + resultV2);

        System.out.println();
        System.out.println("StringBuilder solution:");
        long startTimeV3 = System.nanoTime();

        boolean resultV3 = Strings.isPalindromeV3(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("'" + TEXT + "' is palindrome? " + resultV3);

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV4 = System.nanoTime();

        boolean resultV4 = Strings.isPalindromeV4(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println("'" + TEXT + "' is palindrome? " + resultV4);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

}
