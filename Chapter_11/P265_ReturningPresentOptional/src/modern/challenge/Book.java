package modern.challenge;

import java.util.Optional;

public class Book {

    private final static String BOOK_STATUS = "UNKNOWN";
    
    // Avoid
    public Optional<String> findStatusAvoid() {

        // fetch an Optional prone to be empty
        Optional<String> status = Optional.empty();

        if (status.isPresent()) {
            return status;
        } else {
            return Optional.of(BOOK_STATUS);
        }
    }

    // Prefer
    public Optional<String> findStatusPrefer() {

        // fetch an Optional prone to be empty
        Optional<String> status = Optional.empty();

        return status.or(() -> Optional.of(BOOK_STATUS));
    }
}
