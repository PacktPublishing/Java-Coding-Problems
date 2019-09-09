package modern.challenge;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final String TEXT_1 = "Illinois";
    private static final String TEXT_2 = "Mathematics";
    private static final String TEXT_3 = "and";
    private static final String TEXT_4 = "Science";
    private static final String TEXT_5 = "Academy";

    public static void main(String[] args) {

        System.out.println("Join multiple string via Java 8, String.join():");
        long startTimeV1 = System.nanoTime();

        String stringV1 = String.join(" ", TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("String: " + stringV1);

        System.out.println();
        System.out.println("Join multiple string via StringBuilder:");
        long startTimeV2 = System.nanoTime();

        String stringV2 = Strings.joinByDelimiterV1(' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("String: " + stringV2);

        System.out.println();
        System.out.println("Join multiple string via Java 8, Collectors.joining():");
        long startTimeV3 = System.nanoTime();

        String stringV3 = Strings.joinByDelimiterV2(' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("String: " + stringV3);

        System.out.println();
        System.out.println("Join multiple string via Java 8, StringJoiner:");
        long startTimeV4 = System.nanoTime();

        String stringV4 = Strings.joinByDelimiterV3(' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);

        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println("String: " + stringV4);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

}
