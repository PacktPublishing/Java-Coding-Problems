package modern.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(
                new Melon("Crenshaw", 1200), new Melon("Gac", 3000),
                new Melon("Hemi", 2600), new Melon("Hemi", 1600));

        System.out.println("Method reference to static method:");

        melons.forEach(m -> Melon.growing100g(m));
        melons.forEach(Melon::growing100g);

        System.out.println(melons);
        melons.forEach(System.out::println);

        System.out.println("\nMethod reference to an instance method:");

        MelonComparator mc = new MelonComparator();
        List<Melon> sorted1 = melons.stream()
                .sorted((Melon m1, Melon m2) -> mc.compare(m1, m2))
                .collect(Collectors.toList());

        List<Melon> sorted2 = melons.stream()
                .sorted(mc::compare)
                .collect(Collectors.toList());

        System.out.println(sorted1);
        System.out.println(sorted2);

        List<Integer> sorted3 = melons.stream()
                .map(m -> m.getWeight())
                .sorted((m1, m2) -> Integer.compare(m1, m2))
                .collect(Collectors.toList());

        List<Integer> sorted4 = melons.stream()
                .map(m -> m.getWeight())
                .sorted(Integer::compare)
                .collect(Collectors.toList());

        System.out.println(sorted3);
        System.out.println(sorted4);
        
        System.out.println("\nMethod reference to a constructor:");
        
        BiFunction<String, Integer, Melon> melonFactory = Melon::new;
        Melon hemi1300 = melonFactory.apply("Hemi", 1300);
        
        System.out.println(hemi1300);
    }

}
