package modern.challenge;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final String ONLY_DIGITS = "45566336754493420932877387482372374982374823"
            + "749823283974232237238472392309230923849023848234580383485342234287943943094"
            + "234745374657346578465783467843653748654376837463847654382382938793287492326";
    
    private static final String NOT_ONLY_DIGITS = "45566336754493420932877387482372374982374823"
            + "749823283974232237238472392309230923849023848234580383485342234287943943094"
            + "234745374657346578465783467843653748654376837463847654382382938793287492326A";
    
    public static void main(String[] args) {

        System.out.println("Input text with only digits: \n" + ONLY_DIGITS + "\n");
        System.out.println("Input text with other characters: \n" + NOT_ONLY_DIGITS + "\n");
                
        System.out.println("Character.isDigit() solution:");
        long startTimeV1 = System.nanoTime();
        
        boolean onlyDigitsV11 = Strings.containsOnlyDigitsV1(ONLY_DIGITS);
        boolean onlyDigitsV12 = Strings.containsOnlyDigitsV1(NOT_ONLY_DIGITS);
        
        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Contains only digits: " + onlyDigitsV11);
        System.out.println("Contains only digits: " + onlyDigitsV12);
        
        System.out.println();        
        System.out.println("String.matches() solution:");
        long startTimeV2 = System.nanoTime();
        
        boolean onlyDigitsV21 = Strings.containsOnlyDigitsV2(ONLY_DIGITS);
        boolean onlyDigitsV22 = Strings.containsOnlyDigitsV2(NOT_ONLY_DIGITS);
        
        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Contains only digits: " + onlyDigitsV21);
        System.out.println("Contains only digits: " + onlyDigitsV22);
        
        System.out.println();                
        System.out.println("Java 8, functional-style solution:");
        long startTimeV3 = System.nanoTime();
        
        boolean onlyDigitsV31 = Strings.containsOnlyDigitsV3(ONLY_DIGITS);
        boolean onlyDigitsV32 = Strings.containsOnlyDigitsV3(NOT_ONLY_DIGITS);
        
        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Contains only digits: " + onlyDigitsV31);
        System.out.println("Contains only digits: " + onlyDigitsV32);        
    }
    
    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
    
}