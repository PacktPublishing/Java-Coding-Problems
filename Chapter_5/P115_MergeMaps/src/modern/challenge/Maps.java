package modern.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Maps {

    private Maps() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static <K, V> Map<K, V> mergeMapsV1(Map<K, V> map1, Map<K, V> map2) {

        if (map1 == null || map2 == null) {
            throw new IllegalArgumentException("None of the maps can be null");
        }

        Map<K, V> map = new HashMap<>(map1);

        map2.forEach(
                (key, value) -> map.merge(key, value, (v1, v2) -> v2));

        return map;
    }

    public static <K, V> Map<K, V> mergeMapsV2(Map<K, V> map1, Map<K, V> map2) {

        if (map1 == null || map2 == null) {
            throw new IllegalArgumentException("None of the maps can be null");
        }

        Stream<Map.Entry<K, V>> combined
                = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream());

        Map<K, V> map = combined.collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v2));

        return map;
    }
}
