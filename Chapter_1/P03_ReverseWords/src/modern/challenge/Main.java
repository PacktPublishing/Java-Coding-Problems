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
        
        System.out.println("Reverse words in String via StringBuilder:");
        long startTimeV1 = System.nanoTime();
        
        String reversedV1 = Strings.reverseWordsV1(TEXT);
        
        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Reversed: \n" + reversedV1);

        System.out.println();        
        System.out.println("Reverse words in String using Java 8 functional-style:");
        long startTimeV2 = System.nanoTime();
        
        String reversedV2 = Strings.reverseWordsV2(TEXT);
        
        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Reversed: \n" + reversedV2);
        
        System.out.println();
        System.out.println("Reverse String via StringBuilder:");
        long startTimeV3 = System.nanoTime();
        
        String reversedV3 = Strings.reverse(TEXT);
        
        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Reversed: \n" + reversedV3);       
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

}
