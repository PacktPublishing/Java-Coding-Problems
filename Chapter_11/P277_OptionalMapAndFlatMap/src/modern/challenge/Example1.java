package modern.challenge;

import java.util.Optional;

public class Example1 {

    public void example1() {
        
        Optional<String> lowername = Optional.of("hello world"); // may be empty as well

        // Avoid               
        Optional<String> uppername1;
        if (lowername.isPresent()) {
            uppername1 = Optional.of(lowername.get().toUpperCase());
        } else {
            uppername1 = Optional.empty();
        }

        // Prefer
        Optional<String> uppername2 = lowername.map(String::toUpperCase);
    }

}
