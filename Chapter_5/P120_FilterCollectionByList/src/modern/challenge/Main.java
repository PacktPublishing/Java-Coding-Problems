package modern.challenge;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {

    private static final int ARRAY_SIZE = 10_000;
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
                    MELON_TYPES[rnd.nextInt(MELON_TYPES.length)], 1000 + rnd.nextInt(10000)));
        }

        List<String> melonsByType = Arrays.asList("Apollo", "Gac", "Crenshaw", "Hami");

        System.out.println("Solution based on looping both collections:");
        long startTimeV1 = clock.millis();
        List<Melon> resultsV1 = new ArrayList<>();
        for (Melon melon : melons) {
            for (String type : melonsByType) {
                if (melon.getType().equals(type)) {
                    resultsV1.add(melon);                    
                }
            }
        }
        displayExecutionTime(clock.millis() - startTimeV1);
        System.out.println("Result: " + resultsV1);

        System.out.println("\nSolution based on List.contains():");
        long startTimeV2 = clock.millis();
        List<Melon> resultsV2 = melons.stream()
                .filter(t -> melonsByType.contains(t.getType()))
                .collect(Collectors.toList());
        displayExecutionTime(clock.millis() - startTimeV2);
        System.out.println("Result: " + resultsV2);

        System.out.println("\nSolution based on HashSet:");
        long startTimeV3 = clock.millis();
        Set<String> melonsSetByType = melonsByType.stream().collect(Collectors.toSet());
        List<Melon> resultsV3 = melons.stream()
                .filter(t -> melonsSetByType.contains(t.getType()))
                .collect(Collectors.toList());
        displayExecutionTime(clock.millis() - startTimeV3);
        System.out.println("Result: " + resultsV3);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ms" + " ("
                + TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS) + " s)");
    }
}
