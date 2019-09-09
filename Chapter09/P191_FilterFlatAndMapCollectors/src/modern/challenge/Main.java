package modern.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Hemi", 2000), new Melon("Crenshaw", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600));

        Map<String, Set<Melon>> melonsFiltering1 = melons.stream()
                .collect(groupingBy(Melon::getType,
                        filtering(m -> m.getWeight() > 2000, toSet())));

        Map<String, Set<Melon>> melonsFiltering2 = melons.stream()
                .filter(m -> m.getWeight() > 2000)
                .collect(groupingBy(Melon::getType, toSet()));

        System.out.println("Grouping by type the melons heavier "
                + "than 2000 grams via filtering():\n" + melonsFiltering1);
        System.out.println("Grouping by type the melons heavier "
                + "than 2000 grams via filter():\n" + melonsFiltering2);

        Map<Boolean, Set<Melon>> melonsFiltering3 = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000,
                        filtering(m -> m.getType().equals("Hemi"), toSet())));

        Map<Boolean, Set<Melon>> melonsFiltering4 = melons.stream()
                .filter(m -> m.getType().equals("Hemi"))
                .collect(partitioningBy(m -> m.getWeight() > 2000, toSet()));

        System.out.println("\nPartitioning melons heavier than 2000 grams "
                + "and filtering them by type, Hemi, via filtering():\n" + melonsFiltering3);
        System.out.println("Partitioning melons heavier than 2000 grams "
                + "and filtering them by type, Hemi, via filter():\n" + melonsFiltering4);

        Map<String, TreeSet<Integer>> melonsMapping1 = melons.stream()
                .collect(groupingBy(Melon::getType,
                        mapping(Melon::getWeight, toCollection(TreeSet::new))));

        Map<Boolean, Set<String>> melonsMapping2 = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000,
                        mapping(Melon::getType, toSet())));

        System.out.println("\nGrouping the weights of melons by type via mapping():\n" + melonsMapping1);
        System.out.println("Partitioning melons heavier than 2000 grams "
                + "and collect only their types via mapping():\n" + melonsMapping2);

        List<Melon> melonsGrown = Arrays.asList(
                new Melon("Honeydew", 5600, Arrays.asList("Spider Mites", "Melon Aphids", "Squash Bugs")),
                new Melon("Crenshaw", 2000, Arrays.asList("Pickleworms")),
                new Melon("Crenshaw", 1000, Arrays.asList("Cucumber Beetles", "Melon Aphids")),
                new Melon("Gac", 4000, Arrays.asList("Spider Mites", "Cucumber Beetles")),
                new Melon("Gac", 1000, Arrays.asList("Squash Bugs", "Squash Vine Borers"))
        );

        Map<String, Set<String>> pestsFlatMapping1 = melonsGrown.stream()
                .collect(groupingBy(Melon::getType,
                        flatMapping(m -> m.getPests().stream(), toSet())));

        Map<Boolean, Set<String>> pestsFlatMapping2 = melonsGrown.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000,
                        flatMapping(m -> m.getPests().stream(), toSet())));

        System.out.println("\nGrouping melons by type and collecting "
                + "the pests via flatMapping():\n" + pestsFlatMapping1);

        System.out.println("Partitioning melons by type and collecting "
                + "the pests via flatMapping():\n" + pestsFlatMapping2);
    }

}
