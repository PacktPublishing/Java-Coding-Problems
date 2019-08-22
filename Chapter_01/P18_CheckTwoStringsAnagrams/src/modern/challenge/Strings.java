package modern.challenge;

import java.util.Arrays;

public final class Strings {

    private static final int EXTENDED_ASCII_CODES = 256;

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean isAnagramV1(String str1, String str2) {

        if (str1 == null || str2 == null
                || str1.isBlank() || str2.isBlank()) {
            // throw IllegalArgumentException
            return false;
        }

        char[] chStr1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] chStr2 = str2.replaceAll("\\s", "").toLowerCase().toCharArray();

        if (chStr1.length != chStr2.length) {
            return false;
        }

        Arrays.sort(chStr1);
        Arrays.sort(chStr2);

        return Arrays.equals(chStr1, chStr2);
    }

    public static boolean isAnagramV2(String str1, String str2) {

        if (str1 == null || str2 == null
                || str1.isBlank() || str2.isBlank()) {
            // throw IllegalArgumentException
            return false;
        }

        int[] chCounts = new int[EXTENDED_ASCII_CODES];
        char[] chStr1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] chStr2 = str2.replaceAll("\\s", "").toLowerCase().toCharArray();

        if (chStr1.length != chStr2.length) {
            return false;
        }

        for (int i = 0; i < chStr1.length; i++) {
            chCounts[chStr1[i]]++;
            chCounts[chStr2[i]]--;
        }

        for (int i = 0; i < chCounts.length; i++) {

            if (chCounts[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagramV3(String str1, String str2) {

        if (str1 == null || str2 == null
                || str1.isBlank() || str2.isBlank()) {
            // throw IllegalArgumentException
            return false;
        }

        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        return Arrays.equals(
                str1.chars().sorted().toArray(),
                str2.chars().sorted().toArray()
        );
    }

}
