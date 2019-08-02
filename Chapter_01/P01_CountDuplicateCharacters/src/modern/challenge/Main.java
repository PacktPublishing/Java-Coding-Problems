package modern.challenge;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final String TEXT = "Be strong, be fearless, be beautiful. "
            + "And believe that anything is possible when you have the right "
            + "people there to support you.";
       
    public static void main(String[] args) {
        
        System.out.println("Input text: \n" + TEXT + "\n");
        
        System.out.println("HashMap based solution:");
        long startTimeV1 = System.nanoTime();
        
        Map<Character, Integer> duplicatesV1 = Strings.countDuplicateCharactersV1(TEXT);
        
        displayExecutionTime(System.nanoTime()-startTimeV1);
        System.out.println(Arrays.toString(duplicatesV1.entrySet().toArray()));
        // or: duplicatesV1.forEach( (k, v) -> System.out.print(k + "="+ v + ", "));
        
        System.out.println();        
        System.out.println("Java 8, functional-style solution:");
        long startTimeV2 = System.nanoTime();
        
        Map<Character, Long> duplicatesV2 = Strings.countDuplicateCharactersV2(TEXT);
        
        displayExecutionTime(System.nanoTime()-startTimeV2);
        System.out.println(Arrays.toString(duplicatesV2.entrySet().toArray()));
        // or: duplicatesV2.forEach( (k, v) -> System.out.print(k + "="+ v + ", "));
    }
    
    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " (" +
                TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

}