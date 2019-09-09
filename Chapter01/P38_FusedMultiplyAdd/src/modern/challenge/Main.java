package modern.challenge;

public class Main {

    public static void main(String[] args) {

        double x = 49.29d;
        double y = -28.58d;
        double z = 33.63d;
        
        double q = (x * y) + z;        
        double fma = Math.fma(x, y, z);

        System.out.println("non-fma: " + q);
        System.out.println("fma: " + fma);
    }

}
