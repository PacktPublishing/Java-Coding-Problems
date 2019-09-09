package modern.challenge;

import java.util.Optional;

public class Book {

    // Avoid
    public String findStatusAvoid() {

        // fetch an Optional prone to be empty
        Optional<String> status = Optional.empty();

        if (status.isPresent()) {
            return status.get();
        } else {
            return computeStatus();
        }
    }

    // Avoid
    public String findStatusAlsoAvoid() {

        // fetch an Optional prone to be empty
        Optional<String> status = Optional.of("AVAILABLE");

        // computeStatus() is called even if "status" is not empty
        return status.orElse(computeStatus());
    }
    
    // Prefer
    public String findStatusPrefer() {

        // fetch an Optional prone to be empty
        Optional<String> status = Optional.of("AVAILABLE");

        // computeStatus() is called only if "status" is empty
        return status.orElseGet(this::computeStatus);
    }    

    private String computeStatus() {
        // some code used to compute status
        System.out.println("Computing status ...");
        
        return "THE_COMPUTED_STATUS";
    }
}