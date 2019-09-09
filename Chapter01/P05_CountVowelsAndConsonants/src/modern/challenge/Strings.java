package modern.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public final class Strings {

    private static final Set<Character> allVowels
            = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    // Note: For Unicode supplementary characters use codePointAt() instead of charAt()
    //       and codePoints() instead of chars()
    //       Also, note that languages can have a different number of vowels and consonants
    //       (e.g., in Romanian there are 7 vowels: a, e, i, o, u, ă, î (â). Therefore, 
    //       consider adjust the code accordingly.
    public static Pair<Integer, Integer> countVowelsAndConsonantsV1(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Pair.of(-1, -1);
        }

        str = str.toLowerCase();

        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z')) {
                consonants++;
            }
        }

        return Pair.of(vowels, consonants);
    }

    public static Pair<Long, Long> countVowelsAndConsonantsV2(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Pair.of(-1L, -1L);
        }

        str = str.toLowerCase();

        /*
        long vowels = str.chars()
                .filter(c -> allVowels.contains((char) c))
                .count();

        long consonants = str.chars()
                .filter(c -> !allVowels.contains((char) c))
                .filter(ch -> (ch >= 'a' && ch <= 'z'))
                .count();

        return Pair.of(vowels, consonants);
        */
        
        // or via partitioningBy()
        Map<Boolean, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> (ch >= 'a' && ch <= 'z'))
                .collect(partitioningBy(c -> allVowels.contains(c), counting()));

        return Pair.of(result.get(true), result.get(false));
    }
}
