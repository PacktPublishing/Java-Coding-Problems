package modern.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(1, 2, -4, 0, 2, 0, -1, 14, 0, -1);

        List<Integer> result1 = ints.stream()
                .filter(i -> i != 0)
                .collect(Collectors.toList());
        System.out.println("No zeros:" + result1);
       
        List<Integer> result2 = ints.stream()
                .filter(i -> i != 0)
                .distinct()
                .skip(1)
                .limit(2)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("No zeros, no duplicates, skip 1, limit to 2, sort:" 
                + result2);

        List<Integer> result3 = ints.stream()
                .filter(Numbers::evenBetween0And10)
                .collect(Collectors.toList());
        System.out.println("Even numbers and in (0, 10) range: " + result3);
    }

    private static boolean evenBetween0And10(int value) {
        return value > 0 && value < 10 && value % 2 == 0;
    }
}
