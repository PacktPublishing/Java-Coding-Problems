package modern.challenge;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("Loop and break solution:");
        long startTimeV1 = System.nanoTime();

        char firstcharV1 = Strings.firstNonRepeatedCharacterV1(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Found character: " + firstcharV1);

        System.out.println();
        System.out.println(" 256 ASCII codes solution:");
        long startTimeV2 = System.nanoTime();

        char firstcharV2 = Strings.firstNonRepeatedCharacterV2(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Found character: " + firstcharV2);

        System.out.println();
        System.out.println("LinkedHashMap based solution:");
        long startTimeV3 = System.nanoTime();

        char firstcharV3 = Strings.firstNonRepeatedCharacterV3(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Found character: " + firstcharV3);

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV4 = System.nanoTime();

        char firstcharV4 = Strings.firstNonRepeatedCharacterV4(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println("Found character: " + firstcharV4);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
