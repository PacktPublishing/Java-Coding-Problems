package modern.challenge;

public class Main {
   
    public static void main(String[] args) {
        
        int resultSigned = Integer.compare(Integer.MIN_VALUE, Integer.MAX_VALUE);
        int resultUnsigned = Integer.compareUnsigned(Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        System.out.println("Signed ints: " + Integer.MIN_VALUE + ", " + Integer.MAX_VALUE);
        System.out.println("-----------------------------------------------");        
        System.out.println("Result of comparing signed: " + resultSigned);  // Why we have to compare the signed value?Do the result is the same as in the unsigned result?      
        System.out.println("Result of comparing unsigned: " + resultUnsigned);        
    }
    
}
;
