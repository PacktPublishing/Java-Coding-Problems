package modern.challenge;

import java.util.Optional;

public class Book {

    // Avoid
    public void displayStatusAvoid() {

        // fetch an Optional prone to be empty
        Optional<String> status = Optional.of("AVAILABLE");

        if (status.isPresent()) {
            System.out.println(status.get());
        }
    }

    // Avoid
    public void displayStatusAlsoAvoid() {

        // fetch an Optional prone to be empty
        Optional<String> status = Optional.empty();

        if (status.isPresent()) {
            System.out.println(status.get());
        } else {
            System.out.println("Status not found ...");
        }
    }

    // Prefer
    public void displayStatusPrefer() {

        // fetch an Optional prone to be empty
        Optional<String> status = Optional.of("AVAILABLE");

        status.ifPresent(System.out::println);
    }

    // Prefer
    public void displayStatusAlsoPrefer() {

        // fetch an Optional prone to be empty
        Optional<String> status = Optional.empty();

        status.ifPresentOrElse(System.out::println,
                () -> System.out.println("Status not found ..."));
    }
}
