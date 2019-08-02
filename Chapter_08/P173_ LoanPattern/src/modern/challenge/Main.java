package modern.challenge;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // x + y - z
        double xPlusYMinusZ = Formula.compute((sc)
                -> sc.add().add().minus().result());
        System.out.println("\nResult of x + y - z computation: " + xPlusYMinusZ);

        // x - y * sqrt(z)
        double xMinusYMultiplySqrtZ = Formula.compute((sc)
                -> sc.add().minus().multiplyWithSqrt().result());
        System.out.println("Result of x - y * sqrt(z) computation: " + xMinusYMultiplySqrtZ);
    }

}
