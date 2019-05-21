package modern.challenge;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // Avoid
        BookAvoid bookAvoid1 = new BookAvoid("Title", Optional.of("123-456-789"));
        BookAvoid bookAvoid2 = new BookAvoid("Title", Optional.empty());

        // Prefer
        BookPrefer bookPrefer1 = new BookPrefer("Title", "123-456-789");
        BookPrefer bookPrefer2 = new BookPrefer("Title", null);
    }

}
