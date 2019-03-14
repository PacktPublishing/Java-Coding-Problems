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

        System.out.println("HashMap based solution:");
        long startTimeV1 = System.nanoTime();

        Pair pairV1 = Strings.maxOccurenceCharacterV1(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Character: " + pairV1.character);
        System.out.println("Occurrences :" + pairV1.occurrences);

        System.out.println();
        System.out.println("ASCII codes based solution:");
        long startTimeV2 = System.nanoTime();

        Pair pairV2 = Strings.maxOccurenceCharacterV2(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Character: " + pairV2.character);
        System.out.println("Occurrences :" + pairV2.occurrences);

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV3 = System.nanoTime();

        Pair pairV3 = Strings.maxOccurenceCharacterV3(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Character: " + pairV3.character);
        System.out.println("Occurrences :" + pairV3.occurrences);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
