package modern.challenge;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Convertors {

    private Convertors() {
        throw new AssertionError("Cannot be instantiated");
    }

    // Convert array of T to stream via Arrays#stream()
    public static <T> Stream<T> toStream1(T[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }

        return Arrays.stream(arr);
    }

    // Convert array of T to stream via Stream#of()
    public static <T> Stream<T> toStream2(T[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }

        return Stream.of(arr);
    }

    // Convert array of T to stream via List#stream()
    public static <T> Stream<T> toStream3(T[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }

        return Arrays.asList(arr).stream();
    }

    // Convert array of primitves (int) to stream via Arrays#stream()
    public static IntStream toStream4(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }

        return Arrays.stream(arr);
    }

    // Convert array of primitves (int) to stream via IntStream#of()
    public static IntStream toStream5(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }

        return IntStream.of(arr);
    }        
}
