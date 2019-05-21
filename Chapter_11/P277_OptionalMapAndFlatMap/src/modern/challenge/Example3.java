package modern.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Example3 {

    private static final String NOT_FOUND = "NOT FOUND";

    public void example3() {
        
        List<Book> books = Arrays.asList();

        // Avoid        
        Optional<Book> book = books.stream()
                .filter(b -> b.getPrice() < 50)
                .findFirst();

        String title1 = null;
        if (book.isPresent()) {
            title1 = book.get().getTitle().orElse(NOT_FOUND).toUpperCase();
        }

        // Prefer
        String title2 = books.stream()
                .filter(b -> b.getPrice() < 50)
                .findFirst()
                .flatMap(Book::getTitle)
                .map(String::toUpperCase)
                .orElse(NOT_FOUND);
    }

    public class Book {

        // getTitle() returns a dummy title
        public Optional<String> getTitle() {
            return Optional.of("title");
        }

        // getPrice() returns a dummy price
        public int getPrice() {
            return 10;
        }
    }
}
