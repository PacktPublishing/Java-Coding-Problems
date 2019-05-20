package modern.challenge;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(new Melon("Gac", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700));

        int total1 = melons.stream()
                .mapToInt(Melon::getWeight)
                .sum();

        int total2 = melons.stream()
                .map(Melon::getWeight)
                .reduce(0, (m1, m2) -> m1 + m2);

        System.out.println("The total1 weight is: " + total1);
        System.out.println("The total2 weight is: " + total2);

        int max1 = melons.stream()
                .mapToInt(Melon::getWeight)
                .max()
                .orElse(-1);

        int max2 = melons.stream()
                .map(Melon::getWeight)
                .reduce(Integer::max)
                .orElse(-1);

        System.out.println("Max1: " + max1);
        System.out.println("Max2: " + max2);

        int min1 = melons.stream()
                .mapToInt(Melon::getWeight)
                .min()
                .orElse(-1);

        int min2 = melons.stream()
                .map(Melon::getWeight)
                .reduce(Integer::min)
                .orElse(-1);

        System.out.println("Min1: " + min1);
        System.out.println("Min2: " + min2);

        List<Double> numbers = Arrays.asList(1.0d, 5.0d, 8.0d, 10.0d);

        double total3 = numbers.stream()                
                .reduce(1.0d, (x1, x2) -> x1 * x2);

        System.out.println("Product: " + total3);

        double hm = numbers.size() / numbers.stream()
                .mapToDouble(x -> 1.0d / x)
                .reduce((x1, x2) -> (x1 + x2))
                .orElseThrow();

        System.out.println("Harmonic mean: " + hm);
    }

}
