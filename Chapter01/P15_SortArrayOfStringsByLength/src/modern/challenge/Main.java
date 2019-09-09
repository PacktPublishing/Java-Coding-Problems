package modern.challenge;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {

    private static String[] strs = {"one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine", "ten"};

    public static void main(String[] args) {

        System.out.println("Initial (unsorted):" + Arrays.toString(strs));

        System.out.println("Integer.compare() based solution:");
        long startTimeV1 = System.nanoTime();

        Strings.sortArrayByLengthV1(strs, Strings.Sort.DESC);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Sorted desc: " + Arrays.toString(strs));

        System.out.println();
        System.out.println("Comparator.comparingInt() based solution:");
        long startTimeV2 = System.nanoTime();

        Strings.sortArrayByLengthV2(strs, Strings.Sort.ASC);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Sorted asc: " + Arrays.toString(strs));

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV3 = System.nanoTime();

        String[] resultV3 = Strings.sortArrayByLengthV3(strs, Strings.Sort.DESC);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Sorted desc: " + Arrays.toString(resultV3));
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
