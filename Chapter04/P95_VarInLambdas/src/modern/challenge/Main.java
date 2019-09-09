package modern.challenge;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Function<Integer, Integer> incrementX = x -> x + 1;
        Supplier<IllegalArgumentException> exceptionIAE = IllegalArgumentException::new;
        
        // var incrementX = x -> x + 1;                      // cannot infer
        // var exceptionIAE = IllegalArgumentException::new; // cannot infer

        Square square = (var x) -> x * x;

        // var square = (var x) -> x * x; // cannot infer
    }

}
