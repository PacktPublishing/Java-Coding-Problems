package modern.challenge;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // Avoid
        Optional<Book> book1 = Optional.empty();
        Book theBook1 = book1.get(); // causes java.util.NoSuchElementException: No value present

        // Prefer
        Optional<Book> book2 = Optional.empty();

        if (book2.isPresent()) {
            Book theBook2 = book2.get();
            System.out.println("Book: " + theBook2);
        } else {
            System.out.println("Empty book ...");
        }
    }
}
