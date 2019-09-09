package modern.challenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int countStringInStringV1(String string, String toFind) {

        if (string == null || toFind == null) {
            throw new IllegalArgumentException("The given strings cannot be null");
        }

        if (string.isBlank() || toFind.isBlank()) {
            return 0;
        }

        int position = 0;
        int count = 0;
        int n = toFind.length();

        while ((position = string.indexOf(toFind, position)) != -1) {
            position = position + n;
            count++;
        }

        return count;
    }

    public static int countStringInStringV2(String string, String toFind) {

        if (string == null || toFind == null) {
            throw new IllegalArgumentException("The given strings cannot be null");
        }

        if (string.isBlank() || toFind.isBlank()) {
            return 0;
        }

        return string.split(Pattern.quote(toFind), -1).length - 1;
    }

    public static int countStringInStringV3(String string, String toFind) {

        if (string == null || toFind == null) {
            throw new IllegalArgumentException("The given strings cannot be null");
        }

        if (string.isBlank() || toFind.isBlank()) {
            return 0;
        }

        Pattern pattern = Pattern.compile(Pattern.quote(toFind));
        Matcher matcher = pattern.matcher(string);

        int position = 0;
        int count = 0;
        while (matcher.find(position)) {           
            position = matcher.start() + 1;
            count++;
        }

        return count;
    }
}
