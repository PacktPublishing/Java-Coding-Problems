package modern.challenge;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Book {

    // Avoid
    public String findStatusAvoid() {

        // fetch an Optional prone to be empty
        Optional<String> status = Optional.empty();

        if (status.isPresent()) {
            return status.get();
        } else {
            throw new NoSuchElementException("Status cannot be found");
        }
    }

    // Prefer (before Java 10)
    public String findStatusPrefer1() {

        // fetch an Optional prone to be empty
        Optional<String> status = Optional.empty();

        return status.orElseThrow(
               () -> new NoSuchElementException("Status cannot be found"));
        // or without message
        // return status.orElseThrow(NoSuchElementException::new);
    }

    // Prefer (Java 10+)
    public String findStatusPrefer2() {

        // fetch an Optional prone to be empty
        Optional<String> status = Optional.empty();

        return status.orElseThrow(); // NoSuchElementException 
    }
    
    // Throw another exception
    public String findStatusPrefer3() {

        // fetch an Optional prone to be empty
        Optional<String> status = Optional.empty();

        return status.orElseThrow(
                () -> new IllegalStateException("Status cannot be found"));
    }   
}
