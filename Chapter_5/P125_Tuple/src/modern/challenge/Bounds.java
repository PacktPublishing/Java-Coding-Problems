package modern.challenge;

import java.util.Comparator;
import java.util.Map;
import static java.util.Map.entry;

public final class Bounds {

    private Bounds() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static <T> Map.Entry<T, T> arrayV1(T[] arr, Comparator<? super T> c) {

        T min = arr[0];
        T max = arr[0];
        for (T elem : arr) {
            if (c.compare(min, elem) > 0) {
                min = elem;
            } else if (c.compare(max, elem) < 0) {
                max = elem;
            }
        }

        return entry(min, max);
    }
    
    public static <T> Pair<T, T> arrayV2(T[] arr, Comparator<? super T> c) {

        T min = arr[0];
        T max = arr[0];
        for (T elem : arr) {
            if (c.compare(min, elem) > 0) {
                min = elem;
            } else if (c.compare(max, elem) < 0) {
                max = elem;
            }
        }

        return Pair.of(min, max);
    }
}
