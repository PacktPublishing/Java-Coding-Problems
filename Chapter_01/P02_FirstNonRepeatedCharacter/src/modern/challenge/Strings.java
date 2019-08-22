package modern.challenge;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Strings {

    // http://www.alansofficespace.com/unicode/unicd99.htm
    private static final int EXTENDED_ASCII_CODES = 256; // can be increased to 65535

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static char firstNonRepeatedCharacterV1(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Character.MIN_VALUE;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (ch == str.charAt(j) && i != j) {
                    count++;
                    break;
                }
            }

            if (count == 0) {
                return ch;
            }
        }

        return Character.MIN_VALUE;
    }

    public static char firstNonRepeatedCharacterV2(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Character.MIN_VALUE;
        }

        int[] flags = new int[EXTENDED_ASCII_CODES];

        for (int i = 0; i < flags.length; i++) {
            flags[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {

            if (flags[str.charAt(i)] == -1) {
                flags[str.charAt(i)] = i;
            } else {
                flags[str.charAt(i)] = -2;
            }
        }

        int position = Integer.MAX_VALUE;
        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (flags[i] >= 0) {
                position = Math.min(position, flags[i]);
            }
        }

        return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
    }

    public static char firstNonRepeatedCharacterV3(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Character.MIN_VALUE;
        }

        Map<Character, Integer> chars = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            Integer count = chars.get(ch);
            if (count == null) {
                chars.put(ch, 1);
            } else {
                chars.put(ch, ++count);
            }
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }

    public static char firstNonRepeatedCharacterV4(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Character.MIN_VALUE;
        }

        Map<Integer, Long> chs = str.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));

        return (char) (int) chs.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));
    }

    public static String firstNonRepeatedCharacterVCP4(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return String.valueOf(Character.MIN_VALUE);
        }

        Map<Integer, Long> chs = str.codePoints()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));

        int cp = chs.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));

        return String.valueOf(Character.toChars(cp));
    }
}
