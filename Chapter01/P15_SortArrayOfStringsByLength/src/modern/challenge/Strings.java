package modern.challenge;

import java.util.Arrays;
import java.util.Comparator;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public enum Sort {
        ASC, DESC
    }

    public static void sortArrayByLengthV1(String[] strs, Sort direction) {

        if (strs == null || direction == null || strs.length == 0) {
            // or throw IllegalArgumentException
            return;
        }

        if (direction.equals(Sort.ASC)) {
            Arrays.sort(strs, (String s1, String s2)
                    -> Integer.compare(s1.length(), s2.length()));
        } else {
            Arrays.sort(strs, (String s1, String s2)
                    -> (-1) * Integer.compare(s1.length(), s2.length()));
        }
    }

    public static void sortArrayByLengthV2(String[] strs, Sort direction) {

        if (strs == null || direction == null || strs.length == 0) {
            // or throw IllegalArgumentException
            return;
        }

        if (direction.equals(Sort.ASC)) {
            Arrays.sort(strs, Comparator.comparingInt(String::length));
        } else {
            Arrays.sort(strs, Comparator.comparingInt(String::length).reversed());
        }
    }

    public static String[] sortArrayByLengthV3(String[] strs, Sort direction) {

        if (strs == null || direction == null || strs.length == 0) {
            // or throw IllegalArgumentException
            return new String[0];
        }

        if (direction.equals(Sort.ASC)) {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length))
                    .toArray(String[]::new);
        } else {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .toArray(String[]::new);
        }
    }

}
