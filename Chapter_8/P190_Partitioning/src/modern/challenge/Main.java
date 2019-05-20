package modern.challenge;

import java.util.Arrays;
import static java.util.Comparator.comparingInt;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );

        Map<Boolean, List<Melon>> byWeight1 = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000));

        System.out.println("Partitioning melons by weight of 2000g with duplicates:\n" + byWeight1);

        Map<Boolean, Set<Melon>> byWeight2 = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000, toSet()));

        System.out.println("\nPartitioning melons by weight of 2000g with no duplicates:\n" + byWeight2);

        Map<Boolean, Long> byWeightAndCount1 = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000, counting()));

        Map<Boolean, Long> byWeightAndCount2 = melons.stream()
                .distinct()
                .collect(partitioningBy(m -> m.getWeight() > 2000, counting()));

        System.out.println("\nPartitioning melons by weight of 2000g "
                + "and count with duplicates:\n" + byWeightAndCount1);
        System.out.println("\nPartitioning melons by weight of 2000g "
                + "and count without duplicates:\n" + byWeightAndCount2);

        Map<Boolean, Melon> byWeightMax = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000,
                        collectingAndThen(maxBy(comparingInt(Melon::getWeight)), Optional::get)));

        System.out.println("\nPartitioning melons by weight "
                + "of 2000g and keep only the heaviest from each partition:\n" + byWeightMax);
    }

}
