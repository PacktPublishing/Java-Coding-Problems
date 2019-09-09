package modern.challenge;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import static java.util.stream.Collectors.joining;
import java.util.stream.Stream;

public class Main {

    private static final String TEXT = "hello";

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("StringBuilder solution:");
        long startTimeV1 = System.nanoTime();

        String resultV1 = Strings.concatRepeat(TEXT, 5);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Result: \n" + resultV1);
        System.out.println("Contains only substrings: " + Strings.hasOnlySubstrings(resultV1));

        System.out.println();
        System.out.println("String.repeat() solution:");
        long startTimeV2 = System.nanoTime();

        String resultV2 = TEXT.repeat(5);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Result: \n" + resultV2);
        System.out.println("Contains only substrings: " + Strings.hasOnlySubstrings(resultV2));

        System.out.println();
        System.out.println("String.join() solution:");
        long startTimeV3 = System.nanoTime();

        String resultV3 = String.join("", Collections.nCopies(5, TEXT));

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Result: \n" + resultV3);
        System.out.println("Contains only substrings: " + Strings.hasOnlySubstrings(resultV3));

        System.out.println();
        System.out.println("Stream.generate() solution:");
        long startTimeV4 = System.nanoTime();

        String resultV4 = Stream.generate(() -> TEXT)
                .limit(5)
                .collect((joining()));

        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println("Result: \n" + resultV4);
        System.out.println("Contains only substrings: " + Strings.hasOnlySubstrings(resultV4));

        System.out.println();
        System.out.println("String.format() solution:");
        long startTimeV5 = System.nanoTime();

        String resultV5 = String.format("%0" + 5 + "d", 0).replace("0", TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV5);
        System.out.println("Result: \n" + resultV5);
        System.out.println("Contains only substrings: " + Strings.hasOnlySubstrings(resultV5));

        System.out.println();
        System.out.println("char[] solution:");
        long startTimeV6 = System.nanoTime();

        String resultV6 = new String(new char[5]).replace("\0", TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV6);
        System.out.println("Result: \n" + resultV6);
        System.out.println("Contains only substrings: " + Strings.hasOnlySubstrings(resultV6));
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
