package modern.challenge;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Author {

    // Avoid
    public Optional<List<Book>> fetchBooksByYearAvoid(int year) {

        // fetching the books may return null
        List<Book> books = null;

        return Optional.ofNullable(books);
    }

    // Avoid
    public Optional<Book[]> fetchBooksByYearAlsoAvoid(int year) {

        // fetching the books may return null
        Book[] books = null;

        return Optional.ofNullable(books);
    }

    // Prefer
    public List<Book> fetchBooksByYearPrefer(int year) {

        // fetching the books may return null
        List<Book> books = null;

        return books == null ? Collections.emptyList() : books;
    }

    // Prefer
    public Book[] fetchBooksByYearAlsoPrefer(int year) {

        // fetching the books may return null
        Book[] books = null;

        return books == null ? new Book[0] : books;
    }
}
