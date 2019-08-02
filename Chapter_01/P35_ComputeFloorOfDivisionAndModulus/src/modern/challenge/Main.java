package modern.challenge;

public class Main {

    public static void main(String[] args) {

        int x = -222;
        int y = 14;

        System.out.println("Dividend: " + x + " Divisor: " + y);
        
        System.out.println();
        int z = Math.floorDiv(x, y); // -222/14 = -15.85, so output is -16
        System.out.println("Floor division via '/' is: " + (x / y));
        System.out.println("Floor division via 'floorDiv()' is: " + z);

        System.out.println();
        int m = Math.floorMod(x, y); 
        System.out.println("Floor modulus vis '%' is: " + (x % y));
        System.out.println("Floor modulus via 'floorMod()' is: " + m);
    }

}
