package modern.challenge;

import java.util.Optional;

public class Bookstore {

    // Avoid
    public boolean validateIsbnLengthAvoid(Book book) {

        Optional<String> isbn = book.getIsbn();

        if (isbn.isPresent()) {
            return isbn.get().length() > 10;
        }

        return false;
    }

    // Prefer
    public boolean validateIsbnLengthPrefer(Book book) {

        Optional<String> isbn = book.getIsbn();

        return isbn.filter((i) -> i.length() > 10)
                .isPresent();
    }
}
