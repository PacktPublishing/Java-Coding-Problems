package modern.challenge;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // Avoid
        BookAvoid bookAvoid = new BookAvoid();
        bookAvoid.setIsbn(null);        
        bookAvoid.setIsbn(Optional.empty());        
        bookAvoid.setIsbn(Optional.of("123-456-789"));

        // Prefer
        BookPrefer bookPrefer = new BookPrefer();
        bookPrefer.setIsbn(null);
        bookPrefer.setIsbn("123-456-789");
    }

}
