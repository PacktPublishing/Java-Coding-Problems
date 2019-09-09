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

    public static boolean hasOnlySubstrings(String str) {

        if (str == null || str.length() < 2) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() / 2; i++) {
            sb.append(str.charAt(i));

            String resultStr = str.replaceAll(sb.toString(), "");

            if (resultStr.length() == 0) {
                return true;
            }
        }

        return false;
    }
}
