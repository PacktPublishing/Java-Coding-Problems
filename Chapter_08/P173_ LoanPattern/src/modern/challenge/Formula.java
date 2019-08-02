package modern.challenge;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.function.Function;

public class Formula {

    private final Scanner scanner;
    private double result;

    private Formula() throws IOException {
        result = 0.0d;
        scanner = new Scanner(Path.of("doubles.txt"), StandardCharsets.UTF_8);
    }

    public Formula add() {

        if (scanner.hasNextDouble()) {
            result += scanner.nextDouble();
        }

        return this;
    }

    public Formula minus() {

        if (scanner.hasNextDouble()) {
            result -= scanner.nextDouble();
        }

        return this;
    }

    public Formula multiplyWithSqrt() {

        if (scanner.hasNextDouble()) {
            result *= Math.sqrt(scanner.nextDouble());
        }

        return this;
    }

    public double result() {
        return result;
    }

    private void close() {
        try (scanner) {
            result = 0.0d;
        }
    }

    public static double compute(Function<Formula, Double> f) throws IOException {

        Formula formula = new Formula();

        double result = 0.0d;
        try {
            result = f.apply(formula);
        } finally {
            formula.close();
        }

        return result;
    }
}
