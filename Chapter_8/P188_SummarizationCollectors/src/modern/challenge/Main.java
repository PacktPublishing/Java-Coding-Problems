package modern.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600)
        );

        int sumWeightsGrams = melons.stream()
                .collect(Collectors.summingInt(Melon::getWeight));

        double sumWeightsKg1 = melons.stream()
                .collect(Collectors.summingDouble(m -> (double) m.getWeight() / 1000.0d));

        double sumWeightsKg2 = melons.stream()
                .collect(Collectors.summingInt(Melon::getWeight)) / 1000.0d;

        double sumWeightsKg3 = melons.stream()
                .collect(Collectors.reducing(0.0,
                        m -> (double) m.getWeight() / 1000.0d, (m1, m2) -> m1 + m2));

        double sumWeightsKg4 = melons.stream()
                .collect(Collectors.reducing(0,
                        m -> m.getWeight(), (m1, m2) -> m1 + m2)) / 1000.0d;

        System.out.println("Sum melons weights in grams: " + sumWeightsGrams + " grams");
        System.out.println("Sum melons weights in kg (v1): " + sumWeightsKg1 + " kg");
        System.out.println("Sum melons weights in kg (v2): " + sumWeightsKg2 + " kg");
        System.out.println("Sum melons weights in kg (v3): " + sumWeightsKg3 + " kg");
        System.out.println("Sum melons weights in kg (v4): " + sumWeightsKg4 + " kg");

        double avgWeights = melons.stream()
                .collect(Collectors.averagingInt(Melon::getWeight));
        System.out.println("\nAvg melons weights: " + avgWeights + " grams");

        long nrOfMelon1 = melons.stream()
                .filter(m -> m.getWeight() == 3000)
                .count();

        long nrOfMelon2 = melons.stream()
                .filter(m -> m.getWeight() == 3000)
                .collect(Collectors.counting());

        long nrOfMelon3 = melons.stream()
                .filter(m -> m.getWeight() == 3000)
                .collect(Collectors.reducing(0L, m -> 1L, Long::sum));

        System.out.println("\nNumber of melons of 3000g (v1): " + nrOfMelon1);
        System.out.println("Number of melons of 3000g (v2): " + nrOfMelon2);
        System.out.println("Number of melons of 3000g (v3): " + nrOfMelon3);

        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);

        Melon heaviestMelon = melons.stream()
                .collect(Collectors.maxBy(byWeight))
                .orElseThrow();

        Melon lightestMelon = melons.stream()
                .collect(Collectors.minBy(byWeight))
                .orElseThrow();

        System.out.println("\nHeaviest melon: " + heaviestMelon);
        System.out.println("Lightest melon: " + lightestMelon);

        IntSummaryStatistics melonWeightsStatistics
                = melons.stream().collect(Collectors.summarizingInt(Melon::getWeight));
        System.out.println("\nMelons weights statistics: " + melonWeightsStatistics);

        System.out.println("Weight of the heaviest melon: " + melonWeightsStatistics.getMax() + " grams");
    }

}
