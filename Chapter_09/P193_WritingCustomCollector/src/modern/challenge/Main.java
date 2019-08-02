package modern.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );        

        Map<Boolean, List<Melon>> melons2000 = melons.parallelStream()
                .collect(new MelonCollector());

        System.out.println(melons2000 + "\n\n");

        List<String> numbersList = Stream.of("One", "Two", "Three")
                .collect(ArrayList::new, ArrayList::add,
                        ArrayList::addAll);

        System.out.println("Stream collected in ArrayList: " + numbersList);

        Deque<String> numbersDeque = Stream.of("One", "Two", "Three")
                .collect(ArrayDeque::new, ArrayDeque::add,
                        ArrayDeque::addAll);

        System.out.println("Stream collected in Deque: " + numbersDeque);

        String numbersString = Stream.of("One", "Two", "Three")
                .collect(StringBuilder::new, StringBuilder::append,
                        StringBuilder::append).toString();

        System.out.println("Stream collected in String: " + numbersString);
    }

}
