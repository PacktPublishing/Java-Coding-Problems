package modern.challenge;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";

    private static final String SUBTEXT = "programmer";

    public static void main(String[] args) {

        System.out.println("Initial text: \n" + TEXT + "\n");
        System.out.println("Text to search: \n" + SUBTEXT + "\n");

        System.out.println("String.contains() solution:");
        long startTimeV1 = System.nanoTime();

        boolean containsV1 = TEXT.contains(SUBTEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Contained? " + containsV1);

        System.out.println();
        System.out.println("Regular expression solution:");
        long startTimeV2 = System.nanoTime();

        boolean containsV2 = Strings.containsV1(TEXT, SUBTEXT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Contained? " + containsV2);
        System.out.println();

        System.out.println("String.indexOf() solution:");
        long startTimeV3 = System.nanoTime();

        boolean containsV3 = Strings.containsV2(TEXT, SUBTEXT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Contained? " + containsV3);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

}
