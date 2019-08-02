package modern.challenge;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {

        Random rnd = new Random();
        int[] intValues = new int[10];
        double[] doubleValues = new double[10];

        Arrays.setAll(intValues, (t) -> rnd.nextInt(100_000));
        Arrays.setAll(doubleValues, (t) -> rnd.nextDouble());

        Path path1 = Paths.get("noformatter.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(
                path1, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            for (int i = 0; i < 10; i++) {
                bw.write("| " + intValues[i] + " | " + doubleValues[i] + " | ");
                bw.newLine();
            }
        }

        Path path2 = Paths.get("withformatter1.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(
                path2, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            for (int i = 0; i < 10; i++) {
                bw.write(String.format("| %6s | %.3f |", intValues[i], doubleValues[i]));
                bw.newLine();
            }
        }

        Path path3 = Paths.get("withformatter2.txt");
        try (Formatter output = new Formatter(path3.toFile())) {

            for (int i = 0; i < 10; i++) {
                output.format("| %6s | %.3f |%n", intValues[i], doubleValues[i]);
            }
        }

        Path path4 = Paths.get("withformatter3.txt");
        DecimalFormat formatter = new DecimalFormat("###,### bytes");
        try (Formatter output = new Formatter(path4.toFile())) {

            for (int i = 0; i < 10; i++) {
                output.format("%12s%n", formatter.format(intValues[i]));
            }
        }
    }

}
