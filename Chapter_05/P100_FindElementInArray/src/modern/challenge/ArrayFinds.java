package modern.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public final class ArrayFinds {

    private ArrayFinds() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean findElementV1(int[] arr, int find) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        for (int elem : arr) {
            if (elem == find) {
                return true;
            }
        }

        return false;
    }

    public static boolean findElementV2(int[] arr, int find) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, find);

        return (index >= 0);
    }

    public static boolean findElementV3(int[] arr, int find) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        return Arrays.stream(arr)
                .anyMatch(e -> e == find);
    }

    public static <T> boolean findElementObjectV1(T[] arr, T find) {

        if (arr == null || find == null) {
            throw new IllegalArgumentException("None of the arguments can be null");
        }

        for (T elem : arr) {
            if (elem.equals(find)) {
                return true;
            }
        }

        return false;
    }

    public static <T> boolean findElementObjectV2(T[] arr, T find, Comparator<? super T> c) {

        if (arr == null || find == null || c == null) {
            throw new IllegalArgumentException("None of the arguments can be null");
        }

        for (T elem : arr) {
            if (c.compare(elem, find) == 0) {
                return true;
            }
        }

        return false;
    }

    public static <T> boolean findElementObjectV3(T[] arr, T find, Comparator<? super T> c) {

        if (arr == null || find == null || c == null) {
            throw new IllegalArgumentException("None of the arguments can be null");
        }

        Arrays.sort(arr, c);
        int index = Arrays.binarySearch(arr, find, c);

        return (index >= 0);
    }

    public static int findIndexOfElementV1(int[] arr, int find) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == find) {
                return i;
            }
        }

        return -1;
    }

    public static int findIndexOfElementV2(int[] arr, int find) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        return IntStream.range(0, arr.length)
                .filter(i -> find == arr[i])
                .findFirst()
                .orElse(-1);
    }

    public static <T> int findIndexOfElementObjectV1(T[] arr, T find) {

        if (arr == null || find == null) {
            throw new IllegalArgumentException("None of the arguments can be null");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(find)) {
                return i;
            }
        }

        return -1;
    }

    public static <T> int findIndexOfElementObjectV2(T[] arr, T find, Comparator<? super T> c) {

        if (arr == null || find == null || c == null) {
            throw new IllegalArgumentException("None of the arguments can be null");
        }

        for (int i = 0; i < arr.length; i++) {
            if (c.compare(arr[i], find) == 0) {
                return i;
            }
        }

        return -1;
    }

    public static <T> int findIndexOfElementObjectV3(T[] arr, T find, Comparator<? super T> c) {

        if (arr == null || find == null || c == null) {
            throw new IllegalArgumentException("None of the arguments can be null");
        }

        return IntStream.range(0, arr.length)
                .filter(i -> c.compare(find, arr[i]) == 0)
                .findFirst()
                .orElse(-1);
    }

}
