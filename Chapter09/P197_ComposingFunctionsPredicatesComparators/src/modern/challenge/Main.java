package modern.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons1 = Arrays.asList(new Melon("Gac", 2000),
                new Melon("Horned", 1600), new Melon("Apollo", 3000),
                new Melon("Gac", 3000), new Melon("Hemi", 1600));

        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);
        Comparator<Melon> byType = Comparator.comparing(Melon::getType);

        Comparator<Melon> byWeightAndType = Comparator.comparing(Melon::getWeight)
                .thenComparing(Melon::getType);               

        List<Melon> sortedMelons1 = melons1.stream()
                .sorted(byWeight)               
                .collect(Collectors.toList());

        List<Melon> sortedMelons2 = melons1.stream()
                .sorted(byType)
                .collect(Collectors.toList());

        List<Melon> sortedMelons3 = melons1.stream()
                .sorted(byWeightAndType)
                .collect(Collectors.toList());

        System.out.println("Unsorted melons: " + melons1);
        System.out.println("\nSorted by weight melons: " + sortedMelons1);
        System.out.println("Sorted by type melons: " + sortedMelons2);
        System.out.println("Sorted by weight and type melons: " + sortedMelons3);
        
        List<Melon> melons2 = Arrays.asList(new Melon("Gac", 2000),
                new Melon("Horned", 1600), new Melon("Apollo", 3000),
                new Melon("Gac", 3000), new Melon("hemi", 1600));
        
        Comparator<Melon> byWeightAndType2 = Comparator.comparing(Melon::getWeight)
                .thenComparing(Melon::getType, String.CASE_INSENSITIVE_ORDER);

        List<Melon> sortedMelons4 = melons2.stream()
                .sorted(byWeightAndType2)
                .collect(Collectors.toList());
        
        System.out.println("\nSorted by weight and type (case insensitive) melons: " + sortedMelons4);
        
        Predicate<Melon> p2000 = m -> m.getWeight() > 2000;
        Predicate<Melon> p2000GacApollo = p2000.and(m -> m.getType().equals("Gac"))
                .or(m -> m.getType().equals("Apollo"));
        Predicate<Melon> restOf = p2000GacApollo.negate();
        Predicate<Melon> pNot2000 = Predicate.not(m -> m.getWeight() > 2000);        

        List<Melon> result1 = melons1.stream()
                .filter(p2000GacApollo)
                .collect(Collectors.toList());

        List<Melon> result2 = melons1.stream()
                .filter(restOf)
                .collect(Collectors.toList());
        
        List<Melon> result3 = melons1.stream()
                .filter(pNot2000)
                .collect(Collectors.toList());

        System.out.println("\nAll melons of type Apollo or Gac heavier than 2000 grams:\n" + result1);       
        System.out.println("\nNegation of the above predicate:\n" + result2);
        System.out.println("\nAll melons lighter than (or equal to) 2000 grams:\n" + result3);

        Function<Double, Double> f = x -> x * 2;
        Function<Double, Double> g = x -> Math.pow(x, 2);
        Function<Double, Double> gf = f.andThen(g);
        Function<Double, Double> fg = f.compose(g);
        double resultgf = gf.apply(4d);
        double resultfg = fg.apply(4d);

        System.out.println("\ng(f(x)): " + resultgf);
        System.out.println("f(g(x)): " + resultfg);
                
        Function<String, String> introduction = Editor::addIntroduction;
        Function<String, String> editor = introduction.andThen(Editor::addBody)
                .andThen(Editor::addConclusion);

        String article = editor.apply("\nArticle name\n");

        System.out.println(article);
    }

}
