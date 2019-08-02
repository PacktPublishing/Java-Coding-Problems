package modern.challenge;

public class Main {

    public static void main(String[] args) {

        // signed division 
        System.out.println("Division:\n--------------");
        int divisionSignedMinMax = Integer.MIN_VALUE / Integer.MAX_VALUE;
        int divisionSignedMaxMin = Integer.MAX_VALUE / Integer.MIN_VALUE;
        
        System.out.println("Division signed MIN/MAX: " + divisionSignedMinMax);
        System.out.println("Division signed MAX/MIN: " + divisionSignedMaxMin);
        
        // unsigned division
        int divisionUnsignedMinMax = Integer.divideUnsigned(Integer.MIN_VALUE, Integer.MAX_VALUE);
        int divisionUnsignedMaxMin = Integer.divideUnsigned(Integer.MAX_VALUE, Integer.MIN_VALUE);
        
        System.out.println("Division unsigned MIN/MAX: " + divisionUnsignedMinMax);
        System.out.println("Division unsigned MAX/MIN: " + divisionUnsignedMaxMin);
        
        // signed modulo 
        System.out.println("\nModulo:\n--------------");
        int moduloSignedMinMax = Integer.MIN_VALUE % Integer.MAX_VALUE;
        int moduloSignedMaxMin = Integer.MAX_VALUE % Integer.MIN_VALUE;
        
        System.out.println("Modulo signed MIN/MAX: " + moduloSignedMinMax);
        System.out.println("Modulo signed MAX/MIN: " + moduloSignedMaxMin);
        
        // unsigned modulo
        int moduloUnsignedMinMax = Integer.remainderUnsigned(Integer.MIN_VALUE, Integer.MAX_VALUE);
        int moduloUnsignedMaxMin = Integer.remainderUnsigned(Integer.MAX_VALUE, Integer.MIN_VALUE);
        
        System.out.println("Modulo unsigned MIN/MAX: " + moduloUnsignedMinMax);
        System.out.println("Modulo unsigned MAX/MIN: " + moduloUnsignedMaxMin);
    }
    
}
