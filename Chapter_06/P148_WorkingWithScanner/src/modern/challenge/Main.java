package modern.challenge;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        System.out.println("Read a file of double values:");
        try (Scanner scanDoubles = new Scanner(
                Path.of("doubles.txt"), StandardCharsets.UTF_8)) {
            while (scanDoubles.hasNextDouble()) {
                double number = scanDoubles.nextDouble();
                System.out.println(number);
            }
        }

        System.out.println("\nRead a file of people:");
        try (Scanner scanPeople = new Scanner(Path.of("people.txt"), StandardCharsets.UTF_8)
                .useDelimiter(";|,")) {
            while (scanPeople.hasNextLine()) {
                System.out.println("Name: " + scanPeople.next().trim());
                System.out.println("Surname: " + scanPeople.next());
                System.out.println("Age: " + scanPeople.nextInt());
                System.out.println("City: " + scanPeople.next());
            }
        }

        System.out.println("\nRead a file of people via tokens():");
        try (Scanner scanPeople = new Scanner(Path.of("people.txt"), StandardCharsets.UTF_8)
                .useDelimiter(";|,")) {
            scanPeople.tokens().forEach(t -> System.out.println(t.trim()));
        }

        System.out.println("\nRead a file of people via tokens() and join the result via space:");
        try (Scanner scanPeople = new Scanner(Path.of("people.txt"), StandardCharsets.UTF_8)
                .useDelimiter(";|,")) {
            String result = scanPeople.tokens()
                    .map(t -> t.trim())
                    .collect(Collectors.joining(" "));

            System.out.println(result);
        }

        System.out.println("\nRead a file of people via findAll():");
        try (Scanner sc = new Scanner(Path.of("people.txt"))) {
            Pattern pattern = Pattern.compile("4[0-9]");
            List<String> ages = sc.findAll(pattern)
                    .map(MatchResult::group)
                    .collect(Collectors.toList());
            System.out.println("Ages: " + ages);
        }

        System.out.println("Enter a new person as (name, surname and age):\n");
        Scanner scanConsole = new Scanner(System.in);
        String name = scanConsole.nextLine();
        String surname = scanConsole.nextLine();
        int age = scanConsole.nextInt();
        // an int cannot include "\n" so we need the next line just to consume the "\n"
        scanConsole.nextLine();
        String city = scanConsole.nextLine();

        System.out.println("\nName: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
    }
}
