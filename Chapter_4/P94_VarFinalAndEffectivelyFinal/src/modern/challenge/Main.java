package modern.challenge;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        var ratio = fetchRatio(); // this is effectively final

        var weighter = new Weighter() {
            @Override
            public float getMarginOfError() {
                return ratio * 0.25f;
            }
        };

        // ratio = fetchRatio(); // this reassignment will cause error
        
        System.out.println("Margin of error: " + weighter.getMarginOfError());
    }

    public static float fetchRatio() {

        final var limit = new Random().nextFloat();    // this is final
        final var bmi = 0.00023f;                      // this is final

        // limit = 0.002f; // this reassignment will cause error
        // bmi = 0.25f; // this reassignment will cause error
        
        return limit * bmi / 100.12f;
    }
}
