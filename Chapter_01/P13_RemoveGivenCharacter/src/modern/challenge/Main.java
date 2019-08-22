package modern.challenge;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final String TEXT = "oobotooorogshŜoootorgo";
    private static final char CHAR = 'Ŝ';
       
    private static final String TEXT_CP = "😍 I love 💕 you Ӝ so much 💕 😍";
    private static final String CHAR_CP = "Ӝ";   // Unicode: \u04DC, Code Point: 1244
    private static final String CHAR_CPS = "💕"; // Unicode: \uD83D\uDC95, Code Point: 128149

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
        
        System.out.println();
        System.out.println("Java 8, function-style solution (code point)");  
        System.out.println("Input text: \n" + TEXT_CP);
        System.out.println("Character to remove: " + CHAR_CP + "\n");
        long startTimeV4 = System.nanoTime();
       
        String resultV4 = Strings.removeCharacterV4(TEXT_CP, CHAR_CP);
        
        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println("Result: \n" + resultV4);               
        
        System.out.println();
        System.out.println("Java 8, function-style solution (code point)");  
        System.out.println("Input text: \n" + TEXT_CP);
        System.out.println("Character to remove: " + CHAR_CPS + "\n");
        long startTimeV5 = System.nanoTime();
       
        String resultV5 = Strings.removeCharacterV4(TEXT_CP, CHAR_CPS);
        
        displayExecutionTime(System.nanoTime() - startTimeV5);
        System.out.println("Result: \n" + resultV5);               
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
