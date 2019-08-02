package modern.challenge;

import java.util.Objects;
import java.util.Optional;

public class BookAvoid {

    private final String title;          // cannot be null
    private final Optional<String> isbn; // optional field, thus may be empty

    public BookAvoid(String title, Optional<String> isbn) {
        this.title = Objects.requireNonNull(title, () -> "Title cannot be null");
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public Optional<String> getIsbn() {
        return isbn;
    }
}
