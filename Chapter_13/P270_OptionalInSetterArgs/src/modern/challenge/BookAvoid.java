package modern.challenge;

import java.util.Objects;
import java.util.Optional;

public class BookAvoid {

    private Optional<String> isbn;

    public Optional<String> getIsbn() {
        return isbn;
    }

    public void setIsbn(Optional<String> isbn) {
        /*
        if (isbn == null) {
            this.isbn = Optional.empty();
        } else {
            this.isbn = isbn;
        }*/
        
        // or 
        this.isbn = Objects.requireNonNullElse(isbn, Optional.empty());
    }
}
