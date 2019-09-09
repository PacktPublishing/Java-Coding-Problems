package modern.challenge;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public final class Strings {

    private static final int EXTENDED_ASCII_CODES = 256;

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static Pair<Character, Integer> maxOccurenceCharacterV1(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Pair.of(Character.MIN_VALUE, -1);
        }

        Map<Character, Integer> counter = new HashMap<>();
        char[] chStr = str.toCharArray();
        for (int i = 0; i < chStr.length; i++) {

            char currentCh = chStr[i];
            if (!Character.isWhitespace(currentCh)) { // ignore spaces
                Integer noCh = counter.get(currentCh);
                if (noCh == null) {
                    counter.put(currentCh, 1);
                } else {
                    counter.put(currentCh, ++noCh);
                }
            }
        }

        int maxOccurrences = Collections.max(counter.values());

        char maxCharacter = Character.MIN_VALUE;
        for (Entry<Character, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == maxOccurrences) {
                maxCharacter = entry.getKey();
            }
        }

        return Pair.of(maxCharacter, maxOccurrences);
    }

    public static Pair<Character, Integer> maxOccurenceCharacterV2(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Pair.of(Character.MIN_VALUE, -1);
        }

        int maxOccurrences = -1;
        char maxCharacter = Character.MIN_VALUE;

        char[] chStr = str.toCharArray();
        int[] asciiCodes = new int[EXTENDED_ASCII_CODES];

        for (int i = 0; i < chStr.length; i++) {
            char currentCh = chStr[i];
            if (!Character.isWhitespace(currentCh)) { // ignoring space

                int code = (int) currentCh;
                asciiCodes[code]++;
                if (asciiCodes[code] > maxOccurrences) {
                    maxOccurrences = asciiCodes[code];
                    maxCharacter = currentCh;
                }
            }

        }

        return Pair.of(maxCharacter, maxOccurrences);
    }

    public static Pair<Character, Long> maxOccurenceCharacterV3(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Pair.of(Character.MIN_VALUE, -1L);
        }

        return str.chars()
                .filter(c -> Character.isWhitespace(c) == false) // ignoring space
                .mapToObj(c -> (char) c)
                .collect(groupingBy(c -> c, counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .map(p -> Pair.of(p.getKey(), p.getValue()))
                .orElse(Pair.of(Character.MIN_VALUE, -1L));
    }
}
