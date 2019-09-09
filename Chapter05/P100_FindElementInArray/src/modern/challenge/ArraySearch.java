package modern.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public final class ArraySearch {

    private ArraySearch() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean containsElementV1(int[] arr, int toContain) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        for (int elem : arr) {
            if (elem == toContain) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsElementV2(int[] arr, int toContain) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, toContain);

        return (index >= 0);
    }

    public static boolean containsElementV3(int[] arr, int toContain) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        return Arrays.stream(arr)
                .anyMatch(e -> e == toContain);
    }

    public static <T> boolean containsElementObjectV1(T[] arr, T toContain) {

        if (arr == null || toContain == null) {
            throw new IllegalArgumentException("None of the arguments can be null");
        }

        for (T elem : arr) {
            if (elem.equals(toContain)) {
                return true;
            }
        }

        return false;
    }

    public static <T> boolean containsElementObjectV2(T[] arr, T toContain, Comparator<? super T> c) {

        if (arr == null || toContain == null || c == null) {
            throw new IllegalArgumentException("None of the arguments can be null");
        }

        for (T elem : arr) {
            if (c.compare(elem, toContain) == 0) {
                return true;
            }
        }

        return false;
    }

    public static <T> boolean containsElementObjectV3(T[] arr, T toContain, Comparator<? super T> c) {

        if (arr == null || toContain == null || c == null) {
            throw new IllegalArgumentException("None of the arguments can be null");
        }

        Arrays.sort(arr, c);
        int index = Arrays.binarySearch(arr, toContain, c);

        return (index >= 0);
    }

    public static int findIndexOfElementV1(int[] arr, int toFind) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == toFind) {
                return i;
            }
        }

        return -1;
    }

    public static int findIndexOfElementV2(int[] arr, int toFind) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        return IntStream.range(0, arr.length)
                .filter(i -> toFind == arr[i])
                .findFirst()
                .orElse(-1);
    }

    public static <T> int findIndexOfElementObjectV1(T[] arr, T toFind) {

        if (arr == null || toFind == null) {
            throw new IllegalArgumentException("None of the arguments can be null");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(toFind)) {
                return i;
            }
        }

        return -1;
    }

    public static <T> int findIndexOfElementObjectV2(T[] arr, T toFind, Comparator<? super T> c) {

        if (arr == null || toFind == null || c == null) {
            throw new IllegalArgumentException("None of the arguments can be null");
        }

        for (int i = 0; i < arr.length; i++) {
            if (c.compare(arr[i], toFind) == 0) {
                return i;
            }
        }

        return -1;
    }

    public static <T> int findIndexOfElementObjectV3(T[] arr, T toFind, Comparator<? super T> c) {

        if (arr == null || toFind == null || c == null) {
            throw new IllegalArgumentException("None of the arguments can be null");
        }

        return IntStream.range(0, arr.length)
                .filter(i -> c.compare(toFind, arr[i]) == 0)
                .findFirst()
                .orElse(-1);
    }

}