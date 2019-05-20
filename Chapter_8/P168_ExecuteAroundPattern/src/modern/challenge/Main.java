package modern.challenge;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        double singleDouble = Doubles.read((Scanner sc) -> getFirst(sc));
        System.out.println("Single double: " + singleDouble);

        double sumAllDoubles = Doubles.read((Scanner sc) -> sumAll(sc));
        System.out.println("Sum all doubles: " + sumAllDoubles);
    }

    private static double getFirst(Scanner scanner) {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        }

        return Double.NaN;
    }

    private static double sumAll(Scanner scanner) {

        double sum = 0.0d;
        while (scanner.hasNextDouble()) {
            sum += scanner.nextDouble();
        }

        return sum;
    }

}
