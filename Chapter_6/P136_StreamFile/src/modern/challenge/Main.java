package modern.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    
    private static final String FILE_PATH = "D:/learning/packt/resources.txt";

    public static void main(String[] args) {

        System.out.println("Using Files.lines(): ");
        try (Stream<String> filesStream = Files.lines(
                Paths.get(FILE_PATH), StandardCharsets.UTF_8)) {

            filesStream.forEach(System.out::println);

        } catch (IOException e) {
            // handle IOException if needed, otherwise remove the catch block
        }

        System.out.println("\nUsing BufferedReader.lines(): ");
        try (BufferedReader brStream = Files.newBufferedReader(
                Paths.get(FILE_PATH), StandardCharsets.UTF_8)) {

            brStream.lines().forEach(System.out::println);

        } catch (IOException e) {
            // handle IOException if needed, otherwise remove the catch block
        }

    }

}
