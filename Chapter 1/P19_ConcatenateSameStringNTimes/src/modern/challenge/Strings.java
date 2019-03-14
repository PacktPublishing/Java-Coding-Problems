package modern.challenge;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String concatRepeat(String str, int n) {

        if (str == null || str.isBlank()) {
            return "";
        }

        if (n <= 0) {
            return str;
        }

        if (Integer.MAX_VALUE / n < str.length()) {
            throw new OutOfMemoryError("Maximum size of a String will be exceeded");
        }

        StringBuilder sb = new StringBuilder(str.length() * n);

        for (int i = 1; i <= n; i++) {
            sb.append(str);
        }

        return sb.toString();
    }
}
