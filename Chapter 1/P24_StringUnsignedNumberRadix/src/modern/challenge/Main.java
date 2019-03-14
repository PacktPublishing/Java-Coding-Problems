package modern.challenge;

public class Main {

    private static final String NRI = "255500";
    private static final String NRL = "25550049303";

    public static void main(String[] args) {

        int result1i = Integer.parseUnsignedInt(NRI);
        int result2i = Integer.parseUnsignedInt(NRI, Character.MAX_RADIX);
        int result3i = Integer.parseUnsignedInt(NRI, 1, 4, Character.MAX_RADIX);

        System.out.println("Result 1i: " + result1i);
        System.out.println("Result 2i: " + result2i);
        System.out.println("Result 3i: " + result3i);

        long result1l = Long.parseUnsignedLong(NRL);
        long result2l = Long.parseUnsignedLong(NRL, Character.MAX_RADIX);
        long result3l = Long.parseUnsignedLong(NRL, 1, 4, Character.MAX_RADIX);

        System.out.println("Result 1l: " + result1l);
        System.out.println("Result 2l: " + result2l);
        System.out.println("Result 3l: " + result3l);
        
        // 2147483648 is Integer.MAX_VALUE + 1
        int maxValuePlus = Integer.parseUnsignedInt("2147483648");
        System.out.println("Result maxValuePlus: " + maxValuePlus);        
    }

}
