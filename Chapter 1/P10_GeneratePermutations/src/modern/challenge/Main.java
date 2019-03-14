package modern.challenge;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {

    private static final String TEXT = "ABC";

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("Permute and store in Set - recursive solution:");
        long startTimeV1 = System.nanoTime();

        Set<String> collector = Strings.permuteAndStore(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println(collector);

        System.out.println();
        System.out.println("Permute and print - recursive solution:");
        long startTimeV2 = System.nanoTime();

        Strings.permuteAndPrint(TEXT);

        System.out.println();
        displayExecutionTime(System.nanoTime() - startTimeV2);

        System.out.println();
        System.out.println("Permute and return Stream - recursive solution:");
        long startTimeV3 = System.nanoTime();

        Stream<String> result = Strings.permuteAndReturnStream(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        result.forEach(System.out::println);

        System.out.println();
        System.out.println("Permute and print Stream - recursive solution:");
        long startTimeV4 = System.nanoTime();

        Strings.permuteAndPrintStream(TEXT);

        System.out.println();
        displayExecutionTime(System.nanoTime() - startTimeV4);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

}
