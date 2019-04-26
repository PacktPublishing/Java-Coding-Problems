package modern.challenge;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void permuteAndPrint(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return;
        }

        permuteAndPrint("", str);
    }

    private static void permuteAndPrint(String prefix, String str) {

        int n = str.length();
        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            for (int i = 0; i < n; i++) {
                permuteAndPrint(prefix + str.charAt(i),
                        str.substring(i + 1, n) + str.substring(0, i));
            }
        }
    }

    public static Set<String> permuteAndStore(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Collections.emptySet();
        }

        return permuteAndStore("", str);
    }

    private static Set<String> permuteAndStore(String prefix, String str) {

        Set<String> permutations = new HashSet<>();

        int n = str.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutations.addAll(permuteAndStore(prefix + str.charAt(i),
                        str.substring(i + 1, n) + str.substring(0, i)));
            }
        }
        return permutations;
    }

    public static void permuteAndPrintStream(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return;
        }

        permuteAndPrintStream("", str);

    }

    private static void permuteAndPrintStream(String prefix, String str) {

        int n = str.length();
        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            IntStream.range(0, n)
                    .parallel()
                    .forEach(i -> permuteAndPrintStream(prefix + str.charAt(i),
                    str.substring(i + 1, n) + str.substring(0, i)));
        }
    }

    public static Stream<String> permuteAndReturnStream(String str) {

        if (str == null || str.isBlank()) {
            return Stream.of("");
        }

        return IntStream.range(0, str.length())
                .parallel()
                .boxed()
                .flatMap(i -> permuteAndReturnStream(str.substring(0, i) + str.substring(i + 1))
                .map(c -> str.charAt(i) + c)
                );
    }
}
