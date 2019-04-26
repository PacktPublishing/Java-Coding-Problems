package modern.challenge;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final String TEXT1 = "hello world";
    private static final String TEXT2 = "dh\n le rlo l wo";

    public static void main(String[] args) {

        System.out.println("First text: \n" + TEXT1 + "\n");
        System.out.println("Second text: \n" + TEXT2 + "\n");

        System.out.println("Arrays.sort() solution:");
        long startTimeV1 = System.nanoTime();

        boolean anagramV1 = Strings.isAnagramV1(TEXT1, TEXT2);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Is anagram? " + anagramV1);

        System.out.println();
        System.out.println("ASCII codes solution:");
        long startTimeV2 = System.nanoTime();

        boolean anagramV2 = Strings.isAnagramV2(TEXT1, TEXT2);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Is anagram? " + anagramV2);

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV3 = System.nanoTime();

        boolean anagramV3 = Strings.isAnagramV3(TEXT1, TEXT2);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Is anagram? " + anagramV3);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
