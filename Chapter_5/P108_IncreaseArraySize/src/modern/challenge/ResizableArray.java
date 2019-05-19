package modern.challenge;

import java.util.Arrays;

public final class ResizableArray {

    private ResizableArray() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int[] add(int[] arr, int item) {

        if (arr == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = item;

        // or, using System.arraycopy()
        // int[] newArr = new int[arr.length + 1];
        // System.arraycopy(arr, 0, newArr, 0, arr.length);
        // newArr[newArr.length - 1] = item;
        return newArr;
    }

    public static int[] remove(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        if (arr.length < 1) {
            throw new IllegalArgumentException("The given array length must be greater than 0");
        }

        int[] newArr = Arrays.copyOf(arr, arr.length - 1);

        // or, using System.arraycopy()
        // int[] newArr = new int[arr.length - 1];
        // System.arraycopy(arr, 0, newArr, 0, arr.length - 1);        
        return newArr;
    }

    public static int[] resize(int[] arr, int length) {

        if (arr == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        if (length < 0) {
            throw new IllegalArgumentException("The given length cannot be smaller than 0");
        }

        int[] newArr = Arrays.copyOf(arr, arr.length + length);

        // or, using System.arraycopy()
        // int[] newArr = new int[arr.length + length];
        // System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }

    public static <T> T[] addObject(T[] arr, T item) {

        if (arr == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        if (item == null) {
            throw new IllegalArgumentException("The given item cannot be null");
        }

        T[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = item;

        return newArr;
    }

    public static <T> T[] removeObject(T[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        T[] newArr = Arrays.copyOf(arr, arr.length - 1);

        return newArr;
    }

    public static <T> T[] resize(T[] arr, int length) {

        if (arr == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        if (length < 0) {
            throw new IllegalArgumentException("The given length cannot be smaller than 0");
        }

        T[] newArr = Arrays.copyOf(arr, arr.length + length);

        return newArr;
    }
}
