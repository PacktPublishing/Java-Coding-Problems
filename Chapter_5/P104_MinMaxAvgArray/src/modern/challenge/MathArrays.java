package modern.challenge;

import java.util.Comparator;

public final class MathArrays {

    private MathArrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int maxV1(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int max = arr[0];

        for (int elem : arr) {
            if (elem > max) {
                max = elem;
            }
        }

        return max;
    }

    public static int maxV2(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int max = arr[0];

        for (int elem : arr) {
            max = Math.max(max, elem);
        }

        return max;
    }

    public static <T> T maxV3(T[] arr, Comparator<? super T> c) {

        if (arr == null || c == null) {
            throw new IllegalArgumentException("Array/Comparator cannot be null");
        }

        T max = arr[0];

        for (T elem : arr) {
            if (c.compare(elem, max) > 0) {
                max = elem;
            }
        }

        return max;
    }

    public static <T extends Comparable<T>> T maxV4(T[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        T max = arr[0];

        for (T elem : arr) {
            if (elem.compareTo(max) > 0) {
                max = elem;
            }
        }
        return max;
    }

    public static double average(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        return sum(arr) / arr.length;
    }

    public static double sum(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        double sum = 0;

        for (int elem : arr) {
            sum += elem;
        }
        return sum;
    }
}
