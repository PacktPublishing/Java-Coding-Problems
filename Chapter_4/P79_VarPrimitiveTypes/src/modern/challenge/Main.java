package modern.challenge;

public class Main {

    public static void main(String[] args) {

        var valid = true;       // inferred as boolean
        var c = 'c';            // inferred as char

        // Prefer
        var intNumber = 10;     // inferred as int
        var longNumber = 10L;   // inferred as long
        var floatNumber = 10F;  // inferred as float, 10.0
        var doubleNumber = 10D; // inferred as double, 10.0

        System.out.println("'valid' is of type: " + typeof(valid));
        System.out.println("'c' is of type: " + typeof(c));
        System.out.println("'intNumber' is of type: " + typeof(intNumber));
        System.out.println("'longNumber' is of type: " + typeof(longNumber));
        System.out.println("'floatNumber' is of type: " + typeof(floatNumber));
        System.out.println("'doubleNumber' is of type: " + typeof(doubleNumber));
    }

    public static Class<Integer> typeof(final int i) {
        return Integer.TYPE;
    }

    public static Class<Long> typeof(final long l) {
        return Long.TYPE;
    }

    public static Class<Double> typeof(final double d) {
        return Double.TYPE;
    }

    public static Class<Float> typeof(final float f) {
        return Float.TYPE;
    }

    public static Class<Character> typeof(final char c) {
        return Character.TYPE;
    }

    public static Class<Boolean> typeof(final boolean b) {
        return Boolean.TYPE;
    }
}
