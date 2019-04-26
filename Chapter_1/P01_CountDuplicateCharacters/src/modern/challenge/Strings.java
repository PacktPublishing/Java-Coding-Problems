package modern.challenge;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }
    
    // Note: For Unicode supplementary characters use codePointAt() instead of charAt()
    //       and codePoints() instead of chars()

    public static Map<Character, Integer> countDuplicateCharactersV1(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Collections.EMPTY_MAP;
        }

        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            
            char ch = str.charAt(i);

            Integer count = result.get(ch);
            if (count != null) {
                result.put(ch, ++count);
            } else {
                result.put(ch, 1);
            }
        }

        return result;
    }

    public static Map<Character, Long> countDuplicateCharactersV2(String str) {
        
        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Collections.EMPTY_MAP;
        }
     
        Map<Character, Long> result = str.chars()                
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }
}