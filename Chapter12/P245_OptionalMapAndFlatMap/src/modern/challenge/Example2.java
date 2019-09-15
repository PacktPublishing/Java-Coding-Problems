package modern.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Example2 {

    private static final String NOT_FOUND = "NOT FOUND";
    
    public void example2() {

        List<Book> books = Arrays.asList();

        // Avoid        
        Optional<Book> book = books.stream()
                .filter(b -> b.getPrice() < 50)
                .findFirst();

        String title1;
        if (book.isPresent()) {
            title1 = book.get().getTitle().toUpperCase();
        } else {
            title1 = NOT_FOUND;
        }

        // Prefer
        String title2 = books.stream()
                .filter(b -> b.getPrice() < 50)
                .findFirst()
                .map(Book::getTitle)
                .map(String::toUpperCase)
                .orElse(NOT_FOUND);
    }

    public class Book {

        // getTitle() returns a dummy title
        public String getTitle() {
            return "title";
        }

        // getPrice() returns a dummy price
        public int getPrice() {
            return 10;
        }
    }
}
