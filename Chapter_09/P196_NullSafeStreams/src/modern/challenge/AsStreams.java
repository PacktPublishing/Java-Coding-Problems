package modern.challenge;

import java.util.Collection;
import java.util.stream.Stream;

public final class AsStreams {

    private AsStreams() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static <T> Stream<T> elementAsStream(T element) {
        return Stream.ofNullable(element);
    }

    public static <T> Stream<T> collectionAsStreamWithNulls(Collection<T> element) {
        return Stream.ofNullable(element).flatMap(Collection::stream);
    }

    public static <T> Stream<T> collectionAsStreamWithoutNulls(Collection<T> collection) {
        return collection.stream().flatMap(e -> Stream.ofNullable(e));
    }

    public static <T> Stream<T> collectionAsStream(Collection<T> collection) {
        return Stream.ofNullable(collection)
                .flatMap(Collection::stream)
                .flatMap(Stream::ofNullable);
    }

}
