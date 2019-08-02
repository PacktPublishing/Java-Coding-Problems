package modern.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Numbers {

    private Numbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int sumIntegers(List<Integer> integers) {

        if (Objects.isNull(integers)) {
            throw new IllegalArgumentException("List cannot be null");
        }

        return integers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue).sum();
    }

    public static boolean integersContainsNulls(List<Integer> integers) {

        if (Objects.isNull(integers)) {
            return false;
        }

        return integers.stream()
                .anyMatch(Objects::isNull);
    }

    public static List<Integer> evenIntegers(List<Integer> integers) {

        if (integers == null) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> evens = new ArrayList<>();
        for (Integer nr : integers) {
            if (nr != null && nr % 2 == 0) {
                evens.add(nr);
            }
        }

        return evens;
    }

}
