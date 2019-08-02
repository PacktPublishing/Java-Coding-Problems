package modern.challenge;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final char space = '\u2002';
    private static final String TEXT1 = "\n \n\n  hello  \t \n \r";
    private static final String TEXT2 = space + "\n \n\n  hello  \t \n \r" + space;

    public static void main(String[] args) {

        System.out.println("\\u2002 is whitespace? " + Character.isWhitespace(space));

        System.out.println("\nSolution based on String.trim():");
        long startTimeV1 = System.nanoTime();

        String trimmedV1 = TEXT1.trim();
        String trimmedV2 = TEXT2.trim();

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Trimmed text 1:" + trimmedV1);
        System.out.println("Trimmed text 2:" + trimmedV2);

        System.out.println("\nSolution based on String.strip():");
        long startTimeV2 = System.nanoTime();

        String strippedV1 = TEXT1.strip();
        String strippedV2 = TEXT2.strip();

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Stripped text 1:" + strippedV1);
        System.out.println("Stripped text 2:" + strippedV2);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
