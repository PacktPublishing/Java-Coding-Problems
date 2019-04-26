package modern.challenge;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }
    
    // Note: For Unicode supplementary characters use codePointAt() instead of charAt()
    //       and codePoints() instead of chars()
    //       Also note that languages can have different number of vowels and consonants
    //       (e.g., in Roumanian there are 7 vowels: a, e, i, o, u, ă, î (â). Therefore, 
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
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
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

        long vowels = str.chars()
                .filter(ch -> (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'))
                .count();

        long consonants = str.chars()
                .filter(ch -> (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'))
                .filter(ch -> (ch >= 'a' && ch <= 'z'))
                .count();

        return Pair.of(vowels, consonants);
    }
}