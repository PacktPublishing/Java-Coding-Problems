package modern.challenge;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(
                new Melon("Gac", 5500, "Europe"), new Melon("Bailan", 6000, "China"),
                new Melon("Watermelon", 1200, "Europe"), new Melon("Gac", 3400, "US"),
                new Melon("Bailan", 1300, "China"));

        List<Melon> bailans = Filters.filterByType(melons, "Bailan");
        System.out.println("Bailans: " + bailans);

        List<Melon> melonsOf1200g = Filters.filterByWeight(melons, 1200);
        System.out.println("Melons of 1200 grams: " + melonsOf1200g);

        List<Melon> bailansOf1300g = Filters.filterByTypeAndWeight(melons, "Bailan", 1300);
        System.out.println("Bailans of 1300 grams: " + bailansOf1300g);

        List<Melon> gacs = Filters.filterMelons(melons, new GacMelonPredicate());
        List<Melon> huge = Filters.filterMelons(melons, new HugeMelonPredicate());
        System.out.println("Gacs: " + gacs);
        System.out.println("Huge: " + huge);

        List<Melon> europeans = Filters
                .filterMelons(melons, new MelonPredicate() {

                    @Override
                    public boolean test(Melon melon) {
                        return "europe".equalsIgnoreCase(melon.getOrigin());
                    }
                });
        System.out.println("Europeans: " + europeans);

        List<Melon> europeansLambda = Filters
                .filterMelons(melons, m -> "europe".equalsIgnoreCase(m.getOrigin()));
        System.out.println("Europeans (via lambda): " + europeansLambda);

        List<Melon> watermelons = Filters
                .filter(melons, (Melon m) -> "Watermelon".equalsIgnoreCase(m.getType()));
        System.out.println("Watermelons: " + watermelons);

        List<Integer> numbers = Arrays.asList(1, 13, 15, 2, 67);
        List<Integer> smallThan10 = Filters
                .filter(numbers, (Integer i) -> i < 10);
        System.out.println("Numbers < 10: " + smallThan10);
    }

}
