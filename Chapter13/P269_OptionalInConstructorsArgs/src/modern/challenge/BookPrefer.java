package modern.challenge;

import java.util.Objects;
import java.util.Optional;

public class BookPrefer {

    private final String title; // cannot be null
    private final String isbn;  // can be null

    public BookPrefer(String title, String isbn) {
        this.title = Objects.requireNonNull(title, () -> "Title cannot be null");
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public Optional<String> getIsbn() {
        return Optional.ofNullable(isbn);
    }
}
