package modern.challenge;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

public class Main {

    private static final int ARRAY_SIZE = 10_000_000;
    private static final String[] MELON_TYPES
            = {"Watermelon", "Cantaloupe", "Horned", "Crenshaw", "Honeydew",
                "Gac", "Bitter", "Winter", "Sprite", "Korean", "Canary", "Charentais",
                "Bailan", "Hami", "Santa Claus", "Sky Rocket", "Golden Langkawi", "Apollo",
                "Honey Globe", "Autumn Sweet", "Jade Dew", "Golden Prize", "Ten Me", "New Century"};

    public static void main(String[] args) {

        Clock clock = Clock.systemUTC();
        Random rnd = new Random();

        // initialize an array of Melons
        List<Melon> melons = new ArrayList<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            melons.add(new Melon(
                    MELON_TYPES[rnd.nextInt(MELON_TYPES.length)], 100 + rnd.nextInt(4000)));
        }

        System.out.println("Simple solution:");
        List<Melon> copyOfMelons1 = new ArrayList<>(melons);
        long startTimeV1 = clock.millis();
        for (int i = 0; i < copyOfMelons1.size(); i++) {
            if (copyOfMelons1.get(i).getWeight() < 3000) {
                copyOfMelons1.set(i, new Melon(copyOfMelons1.get(i).getType(), 3000));
            }
        }
        displayExecutionTime(clock.millis() - startTimeV1);
        System.out.println("Result (first 100): " + copyOfMelons1.subList(0, 100) + " ...");

        System.out.println("\nSolution based on UnaryOperator:");
        List<Melon> copyOfMelons2 = new ArrayList<>(melons);
        UnaryOperator<Melon> operator
                = t -> (t.getWeight() < 3000) ? new Melon(t.getType(), 3000) : t;
        long startTimeV2 = clock.millis();
        copyOfMelons2.replaceAll(operator);
        displayExecutionTime(clock.millis() - startTimeV2);
        System.out.println("Result (first 100): " + copyOfMelons2.subList(0, 100) + " ...");
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ms" + " ("
                + TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS) + " s)");
    }

}
