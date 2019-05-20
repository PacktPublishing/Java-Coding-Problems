package modern.challenge;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringOperations {

    public static final Function<String, String> firstAndLastChar
            = (String s) -> String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(s.length() - 1));

    public List<String> rndStringFromStrings(List<String> strs) {

        return strs.stream()
                .map(StringOperations::extractCharacter)
                .collect(Collectors.toList());
    }

    public static String extractCharacter(String str) {
        Random rnd = new Random();
        int nr = rnd.nextInt(str.length());
        String chAsStr = String.valueOf(str.charAt(nr));

        return chAsStr;
    }

    public static void main(String[] args) {
    }

}
