package modern.challenge;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> ints = List.of(1, 1, 2, 3, 4, 4, 6, 2, 1, 5, 4, 5);

        // Avoid
        int result = ints.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0))
                .values()
                .stream()
                .max(Comparator.comparing(List::size))
                .orElse(Collections.emptyList())
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Result of large expression: " + result);

        var intList = List.of(1, 1, 2, 3, 4, 4, 6, 2, 1, 5, 4, 5);

        // Prefer
        var evenAndOdd = intList.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0))
                .values();

        var evenOrOdd = evenAndOdd.stream()
                .max(Comparator.comparing(List::size))
                .orElse(Collections.emptyList());

        var sumEvenOrOdd = evenOrOdd.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Result of expression using LVTI: " + sumEvenOrOdd);
    }

}
