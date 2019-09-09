package modern.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import static java.util.Comparator.comparingInt;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.toSet;
import modern.challenge.Melon.Sugar;
import static modern.challenge.Melon.Sugar.HIGH;
import static modern.challenge.Melon.Sugar.LOW;
import static modern.challenge.Melon.Sugar.MEDIUM;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );

        Map<String, List<Melon>> byTypeInList = melons.stream()
                .collect(groupingBy(Melon::getType));

        Map<Integer, List<Melon>> byWeightInList = melons.stream()
                .collect(groupingBy(Melon::getWeight));

        System.out.println("Melons grouped by type with duplicates:\n" + byTypeInList);
        System.out.println("\nMelons grouped by weight with duplicates:\n" + byWeightInList);

        Map<String, Set<Melon>> byTypeInSet = melons.stream()
                .collect(groupingBy(Melon::getType, toSet()));

        Map<Integer, Set<Melon>> byWeightInSet = melons.stream()
                .collect(groupingBy(Melon::getWeight, toSet()));

        System.out.println("\nMelons grouped by type without duplicates:\n" + byTypeInSet);
        System.out.println("\nMelons grouped by weight without duplicates:\n" + byWeightInSet);

        Map<Integer, Set<Melon>> byWeightInSetOrdered1 = melons.stream()
                .collect(groupingBy(Melon::getWeight, TreeMap::new, toSet()));

        Map<Integer, Set<String>> byWeightInSetOrdered2 = melons.stream()
                .collect(groupingBy(Melon::getWeight, TreeMap::new,
                        mapping(Melon::getType, toSet())));

        System.out.println("\nMelons grouped and ordered by "
                + "weight without duplicates:\n" + byWeightInSetOrdered1);
        System.out.println("\nTypes of melons grouped and ordered "
                + "by weight without duplicates:\n" + byWeightInSetOrdered2);

        Map<Integer, Long> weightsCount = melons.stream()
                .collect(groupingBy(Melon::getWeight, counting()));

        Map<String, Long> typesCount = melons.stream()
                .collect(groupingBy(Melon::getType, counting()));

        System.out.println("\nGroup melons by type and count:\n" + typesCount);
        System.out.println("\nGroup melons by weight and count:\n" + weightsCount);

        Map<String, Optional<Melon>> minMelonByType1 = melons.stream()
                .collect(groupingBy(Melon::getType, minBy(comparingInt(Melon::getWeight))));

        Map<String, Optional<Melon>> maxMelonByType1 = melons.stream()
                .collect(groupingBy(Melon::getType, maxBy(comparingInt(Melon::getWeight))));

        System.out.println("\nLightest melons by type:\n" + minMelonByType1);
        System.out.println("\nHeaviest melons by type:\n" + maxMelonByType1);

        Map<String, Integer> minMelonByType2 = melons.stream()
                .collect(groupingBy(Melon::getType,
                        collectingAndThen(minBy(comparingInt(Melon::getWeight)),
                                m -> m.orElseThrow().getWeight())));

        Map<String, Integer> maxMelonByType2 = melons.stream()
                .collect(groupingBy(Melon::getType,
                        collectingAndThen(maxBy(comparingInt(Melon::getWeight)),
                                m -> m.orElseThrow().getWeight())));

        System.out.println("\nLightest weight by type:\n" + minMelonByType2);
        System.out.println("\nHeaviest weight by type:\n" + maxMelonByType2);

        Map<String, Melon[]> byTypeArray = melons.stream()
                .collect(groupingBy(Melon::getType, collectingAndThen(
                        Collectors.toList(), l -> l.toArray(Melon[]::new))));

        // Map<String, Melon[]> byTypeArray = melons.stream()
        //        .collect(groupingBy(Melon::getType, toArray(Melon[]::new)));
        
        System.out.println();
        byTypeArray.forEach((t, m) -> {
            System.out.println("Melon type: " + t);
            System.out.println("Array of melons of this type: " + Arrays.toString(m));
        });

        List<Melon> melonsSugar = Arrays.asList(new Melon("Crenshaw", 1200, HIGH),
                new Melon("Gac", 3000, LOW), new Melon("Hemi", 2600, HIGH),
                new Melon("Hemi", 1600), new Melon("Gac", 1200, LOW),
                new Melon("Cantaloupe", 2600, MEDIUM), new Melon("Cantaloupe", 3600, MEDIUM),
                new Melon("Apollo", 2600, MEDIUM), new Melon("Horned", 1200, HIGH),
                new Melon("Gac", 3000, LOW), new Melon("Hemi", 2600, HIGH)
        );

        Map<Sugar, Map<Integer, Set<String>>> bySugarAndWeight = melonsSugar.stream()
                .collect(groupingBy(Melon::getSugar,
                        groupingBy(Melon::getWeight, TreeMap::new,
                                mapping(Melon::getType, toSet()))));

        System.out.println("\nTypes of melon grouped by sugar level and weights:\n" + bySugarAndWeight);

        System.out.println("\nSplit a list of 100 weights in multiple 10 lists of 10 elements each");

        Random rnd = new Random();
        List<Integer> allWeights = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            allWeights.add(1000 + rnd.nextInt(6000));
        }

        System.out.println("\nAll weights:\n" + allWeights);

        final AtomicInteger count = new AtomicInteger();
        Collection<List<Integer>> chunkWeights = allWeights.stream()
                .collect(Collectors.groupingBy(c -> count.getAndIncrement() / 10))
                .values();

        System.out.println("\nAll chunks: ");
        chunkWeights.forEach(System.out::println);
    }

    private static <T> Collector<T, ?, T[]> toArray(IntFunction<T[]> func) {
        return Collectors.collectingAndThen(
                Collectors.toList(), l -> l.toArray(func.apply(l.size())));
    }
}
