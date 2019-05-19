package modern.challenge;

import java.util.Comparator;
import java.util.Random;

public final class ArraySorts {

    private ArraySorts() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void bubbleSort(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void pancakeSort(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int maxVal;
        int j, position;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            maxVal = arr[0];
            position = 0;
            for (j = 0; j < n - i; j++) {
                if (arr[j] > maxVal) {
                    maxVal = arr[j];
                    position = j;
                }
            }
            flip(arr, position, n - 1 - i);
        }
    }

    private static void flip(int[] arr, int left, int right) {

        while (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void exchangeSort(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static <T>
            void bubbleSortWithComparator(T arr[], Comparator<? super T> c) {

        if (arr == null || c == null) {
            throw new IllegalArgumentException("Array/Comparator cannot be null");
        }

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubleSortOptimized(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int n = arr.length;
        while (n != 0) {
            int swap = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;

                    swap = i;
                }
            }
            n = swap;
        }
    }

    public static <T>
            void bubleSortOptimizedWithComparator(T[] arr, Comparator<? super T> c) {

        if (arr == null || c == null) {
            throw new IllegalArgumentException("Array/Comparator cannot be null");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int n = arr.length;
        while (n != 0) {
            int swap = 0;
            for (int i = 1; i < n; i++) {
                if (c.compare(arr[i - 1], arr[i]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;

                    swap = i;
                }
            }
            n = swap;
        }
    }

    public static void selectionSort(int[] arr) {

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int first;
        int count = 1;
        for (int i = arr.length - 1; i > 0; i--, count++) {

            first = 0;
            for (int j = 1; j <= i; j++) {

                if (arr[j] > arr[first]) {
                    first = j;
                }
            }

            swap(arr, first, i);
        }
    }

    public static void shellSort(int[] arr) {

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int q = 1;
        while (q <= arr.length / 3) {
            q = (q * 3) + 1;
        }

        int in, out;
        int temp;
        while (q > 0) {
            for (out = q; out < arr.length; out++) {
                temp = arr[out];
                in = out;

                while (in > q - 1 && arr[in - q] >= temp) {
                    arr[in] = arr[in - q];
                    in -= q;
                }
                arr[in] = temp;
            }
            q = (q - 1) / 3;
        }
    }

    public static void insertionSort(int arr[]) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }

    public static <T>
            void insertionSortWithComparator(T arr[], Comparator<? super T> c) {

        if (arr == null || c == null) {
            throw new IllegalArgumentException("Array/Comparator cannot be null");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && c.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }

    public static void countingSort(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] counts = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            counts[arr[i] - min]++;
        }

        int sortedIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                arr[sortedIndex++] = i + min;
                counts[i]--;
            }
        }
    }

    public static void mergeSort(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length > 1) {
            int[] left = leftHalf(arr);
            int[] right = rightHalf(arr);

            mergeSort(left);
            mergeSort(right);

            merge(arr, left, right);
        }
    }

    private static int[] leftHalf(int[] arr) {

        int size = arr.length / 2;
        int[] left = new int[size];
        System.arraycopy(arr, 0, left, 0, size);

        return left;
    }

    private static int[] rightHalf(int[] arr) {

        int size1 = arr.length / 2;
        int size2 = arr.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = arr[i + size1];
        }

        return right;
    }

    private static void merge(int[] result, int[] left, int[] right) {

        int t1 = 0;
        int t2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (t2 >= right.length || (t1 < left.length && left[t1] <= right[t2])) {
                result[i] = left[t1];
                t1++;
            } else {
                result[i] = right[t2];
                t2++;
            }
        }
    }

    public static void heapSort(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int n = arr.length;
        buildHeap(arr, n);
        while (n > 1) {
            swap(arr, 0, n - 1);
            n--;
            heapify(arr, n, 0);
        }
    }

    private static void buildHeap(int[] arr, int n) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {

        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int greater;

        if (left < n && arr[left] > arr[i]) {
            greater = left;
        } else {
            greater = i;
        }

        if (right < n && arr[right] > arr[greater]) {
            greater = right;
        }

        if (greater != i) {
            swap(arr, i, greater);
            heapify(arr, n, greater);
        }
    }

    public static <T>
            void heapSortWithComparator(T[] arr, Comparator<? super T> c) {

        if (arr == null || c == null) {
            throw new IllegalArgumentException("Array/Comparator cannot be null");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int n = arr.length;
        buildHeap(arr, n, c);
        while (n > 1) {
            swap(arr, 0, n - 1);
            n--;
            heapify(arr, n, 0, c);
        }
    }

    private static <T>
            void buildHeap(T[] arr, int n, Comparator<? super T> c) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, n, i, c);
        }
    }

    private static <T>
            void heapify(T[] arr, int n, int i, Comparator<? super T> c) {

        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int greater;

        if (left < n && c.compare(arr[left], arr[i]) > 0) {
            greater = left;
        } else {
            greater = i;
        }

        if (right < n && c.compare(arr[right], arr[greater]) > 0) {
            greater = right;
        }

        if (greater != i) {
            swap(arr, i, greater);
            heapify(arr, n, greater, c);
        }
    }

    public static void bucketSort(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] bucket = new int[max + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int p = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[p++] = i;
            }
        }
    }

    public static void cocktailSort(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        boolean isSwapped;
        do {
            isSwapped = false;
            for (int i = 0; i <= arr.length - 2; i++) {
                if (arr[i] > arr[i + 1]) {

                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }

            isSwapped = false;
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    isSwapped = true;
                }
            }

        } while (isSwapped);
    }

    public static void cycleSort(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        for (int cycle = 0; cycle < arr.length - 1; cycle++) {
            int value = arr[cycle];

            int position = cycle;
            for (int i = cycle + 1; i < arr.length; i++) {
                if (arr[i] < value) {
                    position++;
                }
            }

            if (position == cycle) {
                continue;
            }

            while (value == arr[position]) {
                position++;
            }

            int temp = arr[position];
            arr[position] = value;
            value = temp;

            while (position != cycle) {
                position = cycle;
                for (int i = cycle + 1; i < arr.length; i++) {
                    if (arr[i] < value) {
                        position++;
                    }
                }

                while (value == arr[position]) {
                    position++;
                }

                temp = arr[position];
                arr[position] = value;
                value = temp;
            }
        }
    }

    public static void quickSort(int[] arr, int left, int right) {

        if (left < right) {
            int pivot = partition(arr, left, right);

            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {

        int pivot = arr[right];
        int m = left;
        for (int i = m; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, m++);
            }
        }

        swap(arr, right, m);

        return m;
    }

    public static <T> void quickSortWithComparator(
            T[] arr, int left, int right, Comparator<? super T> c) {

        if (left < right) {
            int pivot = partitionWithComparator(arr, left, right, c);

            quickSortWithComparator(arr, left, pivot - 1, c);
            quickSortWithComparator(arr, pivot + 1, right, c);
        }
    }

    private static <T> int partitionWithComparator(
            T[] arr, int left, int right, Comparator<? super T> c) {

        T pivot = arr[right];
        int m = left;
        for (int i = m; i < right; i++) {
            if (c.compare(arr[i], pivot) <= 0) {
                swap(arr, i, m++);
            }
        }

        swap(arr, right, m);

        return m;
    }

    public static void radixSort(int[] arr, int radix) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        int exp = 1;
        while ((max - min) / exp >= 1) {
            countSortByDigit(arr, radix, exp, min);
            exp *= radix;
        }
    }

    private static void countSortByDigit(
            int[] arr, int radix, int exp, int min) {

        int[] buckets = new int[radix];
        for (int i = 0; i < radix; i++) {
            buckets[i] = 0;
        }

        int bucket;
        for (int i = 0; i < arr.length; i++) {
            bucket = (int) (((arr[i] - min) / exp) % radix);
            buckets[bucket]++;
        }

        for (int i = 1; i < radix; i++) {
            buckets[i] += buckets[i - 1];
        }

        int[] out = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            bucket = (int) (((arr[i] - min) / exp) % radix);
            out[--buckets[bucket]] = arr[i];
        }

        System.arraycopy(out, 0, arr, 0, arr.length);
    }

    // helpers
    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static <T> void swap(T[] arr, int x, int y) {
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // bonus
    public static void shuffleInt(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int index;
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);

            swap(arr, index, i);
        }
    }

    public static <T> void shuffleObj(T[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int index;
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);

            swap(arr, index, i);
        }
    }
}
