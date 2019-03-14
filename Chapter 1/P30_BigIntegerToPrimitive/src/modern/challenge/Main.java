package modern.challenge;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        BigInteger nr = BigInteger.valueOf(Long.MAX_VALUE);
               
        long nrLong = nr.longValue();        
        System.out.println(nr + " as long is: " + nrLong);
        
        int nrInt = nr.intValue();
        System.out.println(nr + " as int is: " + nrInt);
        
        short nrShort = nr.shortValue();
        System.out.println(nr + " as short is: " + nrShort);
        
        byte nrByte = nr.byteValue();                                
        System.out.println(nr + " as byte is: " + nrByte);
                
        long nrExactLong = nr.longValueExact(); // ok       
        System.out.println(nr + " as exact long is: " + nrExactLong);
        
        int nrExactInt = nr.intValueExact(); // ArithmeticException
        System.out.println(nr + " as exact int is: " + nrExactInt);
        
        short nrExactShort = nr.shortValueExact(); // ArithmeticException
        System.out.println(nr + " as exact short is: " + nrExactShort);
        
        byte nrExactByte = nr.byteValueExact(); // ArithmeticException                        
        System.out.println(nr + " as exact byte is: " + nrExactByte);
    }
    
}

