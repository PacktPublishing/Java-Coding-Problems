package modern.challenge;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class Main {

    public static void main(String[] args) {

        // Avoid
        Optional<Integer> priceInt1 = Optional.of(50);
        Optional<Long> priceLong1 = Optional.of(50L);
        Optional<Double> priceDouble1 = Optional.of(49.99d);

        // Prefer
        OptionalInt priceInt2 = OptionalInt.of(50);              // unwrap via getAsInt()
        OptionalLong priceLong2 = OptionalLong.of(50L);          // unwrap via getAsLong()
        OptionalDouble priceDouble2 = OptionalDouble.of(49.99d); // unwrap via getAsDouble()
    }

}
