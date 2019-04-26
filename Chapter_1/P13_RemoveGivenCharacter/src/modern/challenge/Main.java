package modern.challenge;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final String TEXT = "oobotooorogshoootorgo";
    private static final char CHAR = 'o';

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT);
        System.out.println("Character to remove: " + CHAR + "\n");

        System.out.println("StringBuilder based solution:");
        long startTimeV1 = System.nanoTime();

        String resultV1 = Strings.removeCharacterV1(TEXT, CHAR);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Result: \n" + resultV1);

        System.out.println();
        System.out.println("Regular expression based solution:");
        long startTimeV2 = System.nanoTime();

        String resultV2 = Strings.removeCharacterV2(TEXT, CHAR);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Result: \n" + resultV2);

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV3 = System.nanoTime();

        String resultV3 = Strings.removeCharacterV3(TEXT, CHAR);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Result: \n" + resultV3);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
