package modern.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        CountSum countsum = Stream.of(2, 11, 1, 5, 7, 8, 12)
                .collect(Collectors.teeing(
                        counting(),
                        summingInt(e -> e),
                        CountSum::new));

        System.out.println(countsum);

        MinMax minmax = Stream.of(2, 11, 1, 5, 7, 8, 12)
                .collect(Collectors.teeing(
                        minBy(Comparator.naturalOrder()),
                        maxBy(Comparator.naturalOrder()),
                        (Optional<Integer> a, Optional<Integer> b) -> new MinMax(
                                a.orElse(Integer.MIN_VALUE), b.orElse(Integer.MAX_VALUE))));
                
        System.out.println(minmax);

        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );

        WeightsAndTotal weightsAndTotal = melons.stream()
                .collect(Collectors.teeing(
                        summingInt(Melon::getWeight),
                        mapping(m -> m.getWeight(), toList()),
                        WeightsAndTotal::new
                ));

        System.out.println(weightsAndTotal);
    }

}
