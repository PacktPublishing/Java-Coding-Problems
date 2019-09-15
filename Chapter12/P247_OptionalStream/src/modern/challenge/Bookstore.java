package modern.challenge;

import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;

public class Bookstore {

    // Avoid
    public List<Book> fetchBooksAvoid(List<String> isbns) {
        return isbns.stream()
                .map(this::fetchBookByIsbn)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toList());
    }

    // Prefer
    public List<Book> fetchBooksPrefer(List<String> isbns) {
        return isbns.stream()
                .map(this::fetchBookByIsbn)                
                .flatMap(Optional::stream)
                .collect(toList());
    }

    public Optional<Book> fetchBookByIsbn(String isbn) {

        // fetching book by the given "isbn" can return null
        Book book = null;

        return Optional.ofNullable(book);
    }
}
