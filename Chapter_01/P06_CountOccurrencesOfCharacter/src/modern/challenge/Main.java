package modern.challenge;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";
    private static final char CHAR_TO_COUNT = 'u';

    private static final String TEXT_CP = "😍 I love 💕 you Ӝ so much 💕 😍";
    private static final String CHAR_TO_COUNT_CP = "Ӝ";   // Unicode: \u04DC, Code Point: 1244
    private static final String CHAR_TO_COUNT_CPS = "💕"; // Unicode: \uD83D\uDC95, Code Point: 128149

    public static void main(String[] args) {
        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("\n\nASCII or 16 bits Unicode characters (less than 65,535 (0xFFFF)) examples:\n");

        System.out.println("replace() based solution:");
        long startTimeV1 = System.nanoTime();

        int countV1 = Strings
                .countOccurrencesOfACertainCharacterV1(TEXT, CHAR_TO_COUNT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Character '" + CHAR_TO_COUNT + "' occured " + countV1 + " time(s)");

        System.out.println();
        System.out.println("charAt() based solution:");
        long startTimeV2 = System.nanoTime();

        int countV2 = Strings
                .countOccurrencesOfACertainCharacterV2(TEXT, CHAR_TO_COUNT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Character '" + CHAR_TO_COUNT + "' occured " + countV2 + " time(s)");

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV3 = System.nanoTime();

        long countV3 = Strings
                .countOccurrencesOfACertainCharacterV3(TEXT, CHAR_TO_COUNT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Character '" + CHAR_TO_COUNT + "' occured " + countV3 + " time(s)");

        System.out.println("\n--------------------------------------\n");
        
        System.out.println("Input text: \n" + TEXT_CP + "\n");
        
        System.out.println("\n\nIncluding Unicode surrogate pairs examples:\n");

        System.out.println("replace() based solution:");
        long startTimeV4 = System.nanoTime();

        int countV4 = Strings
                .countOccurrencesOfACertainCharacterVCP1(TEXT_CP, CHAR_TO_COUNT_CP);

        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println("Character '" + CHAR_TO_COUNT_CP + "' occured " + countV4 + " time(s)");

        System.out.println();
        System.out.println("replace() based solution:");
        long startTimeV5 = System.nanoTime();

        int countV5 = Strings
                .countOccurrencesOfACertainCharacterVCP1(TEXT_CP, CHAR_TO_COUNT_CPS);

        displayExecutionTime(System.nanoTime() - startTimeV5);
        System.out.println("Character '" + CHAR_TO_COUNT_CPS + "' occured " + countV5 + " time(s)");

        System.out.println();
        System.out.println("codePointAt() based solution:");
        long startTimeV6 = System.nanoTime();

        int countV6 = Strings
                .countOccurrencesOfACertainCharacterVCP2(TEXT_CP, CHAR_TO_COUNT_CP);

        displayExecutionTime(System.nanoTime() - startTimeV6);
        System.out.println("Character '" + CHAR_TO_COUNT_CP + "' occured " + countV6 + " time(s)");

        System.out.println();
        System.out.println("codePointAt() based solution:");
        long startTimeV7 = System.nanoTime();

        int countV7 = Strings
                .countOccurrencesOfACertainCharacterVCP2(TEXT_CP, CHAR_TO_COUNT_CPS);

        displayExecutionTime(System.nanoTime() - startTimeV7);
        System.out.println("Character '" + CHAR_TO_COUNT_CPS + "' occured " + countV7 + " time(s)");

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV8 = System.nanoTime();

        long countV8 = Strings
                .countOccurrencesOfACertainCharacterVCP3(TEXT_CP, CHAR_TO_COUNT_CP);

        displayExecutionTime(System.nanoTime() - startTimeV8);
        System.out.println("Character '" + CHAR_TO_COUNT_CP + "' occured " + countV8 + " time(s)");

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV9 = System.nanoTime();

        long countV9 = Strings
                .countOccurrencesOfACertainCharacterVCP3(TEXT_CP, CHAR_TO_COUNT_CPS);

        displayExecutionTime(System.nanoTime() - startTimeV9);
        System.out.println("Character '" + CHAR_TO_COUNT_CPS + "' occured " + countV9 + " time(s)");
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
