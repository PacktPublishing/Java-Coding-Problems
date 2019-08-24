package modern.challenge;

import java.util.Objects;
import java.util.Optional;

public class BookAvoid {

    private final String title;          // cannot be null
    private final Optional<String> isbn; // optional field, cannot be null

    public BookAvoid(String title, Optional<String> isbn) {
        this.title = Objects.requireNonNull(title, () -> "Title cannot be null");

        /*
        if (isbn == null) {
            this.isbn = Optional.empty();
        } else {
            this.isbn = isbn;
        }*/
        
        // or
        this.isbn = Objects.requireNonNullElse(isbn, Optional.empty());
    }

    public String getTitle() {
        return title;
    }

    public Optional<String> getIsbn() {
        return isbn;
    }
}
