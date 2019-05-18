package modern.challenge;

public class Main {

    public static void main(String[] args) {

        byte byteNumber1 = 25;           // this is of type byte
        short shortNumber1 = 1463;       // this is of type short       
        System.out.println("Explicit types:");
        System.out.println("'byteNumber1' type is: " + typeof(byteNumber1));
        System.out.println("'shortNumber1' type is: " + typeof(shortNumber1));

        var byteNumber2 = 25;            // inferred as int
        var shortNumber2 = 1463;         // inferred as int
        System.out.println("\nUsing var:");
        System.out.println("'byteNumber2' type is: " + typeof(byteNumber2));
        System.out.println("'shortNumber2' type is: " + typeof(shortNumber2));

        var byteNumber3 = (byte) 25;     // inferred as byte
        var shortNumber3 = (short) 1463; // inferred as short
        System.out.println("\nUsing var and explicit downcast:");
        System.out.println("'byteNumber3' type is: " + typeof(byteNumber3));
        System.out.println("'shortNumber3' type is: " + typeof(shortNumber3));
    }

    public static Class<Integer> typeof(final int i) {
        return Integer.TYPE;
    }

    public static Class<Byte> typeof(final byte b) {
        return Byte.TYPE;
    }

    public static Class<Short> typeof(final short s) {
        return Short.TYPE;
    }
}
