package modern.challenge;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String longestCommonPrefixV1(String[] strs) {

        if (strs == null || strs.length == 0) {
            // or throw IllegalArgumentException
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int firstLen = strs[0].length();
        for (int prefixLen = 0; prefixLen < firstLen; prefixLen++) {

            char ch = strs[0].charAt(prefixLen);
            for (int i = 1; i < strs.length; i++) {
                if (prefixLen >= strs[i].length()
                        || strs[i].charAt(prefixLen) != ch) {
                    
                    return strs[i].substring(0, prefixLen);
                }
            }
        }

        return strs[0];
    }

    public static String longestCommonPrefixV2(String[] strs) {

        if (strs == null || strs.length == 0) {
            // or throw IllegalArgumentException
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int minStr = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minStr) {
                minStr = str.length();
            }
        }

        String result = "";
        int left = 0;
        int right = minStr;
        while (left < right) {

            int middle = left + (right - left) / 2;

            if (isPrefixInAll(strs, left, middle)) {

                result = result + strs[0].substring(left, middle + 1);
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return result;
    }

    private static boolean isPrefixInAll(String strs[], int start, int end) {

        String str = strs[0];

        for (String currentStr : strs) {
            for (int j = start; j <= end; j++) {
                if (currentStr.charAt(j) != str.charAt(j)) {

                    return false;
                }
            }
        }

        return true;
    }
}
