package modern.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static java.util.stream.Collectors.toMap;

public final class Maps {

    private Maps() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static <K, V> Map<K, V> sortByKeyStream(Map<K, V> map, Comparator<? super K> c) {

        if (map == null) {
            throw new IllegalArgumentException("Map cannot be null");
        }
        
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(c))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (v1, v2) -> v1, LinkedHashMap::new));
    }

    public static <K, V> Map<K, V> sortByValueStream(Map<K, V> map, Comparator<? super V> c) {

        if (map == null) {
            throw new IllegalArgumentException("Map cannot be null");
        }

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(c))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (v1, v2) -> v1, LinkedHashMap::new));
    }

    public static <K, V> TreeMap<K, V> sortByKeyTreeMap(Map<K, V> map) {

        if (map == null) {
            throw new IllegalArgumentException("Map cannot be null");
        }

        return new TreeMap<>(map);
    }

    @SuppressWarnings("unchecked")
    public static <K extends Comparable, V> List<K> sortByKeyList(Map<K, V> map) {

        if (map == null) {
            throw new IllegalArgumentException("Map cannot be null");
        }

        List<K> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        return list;

    }

    @SuppressWarnings("unchecked")
    public static <K, V extends Comparable> List<V> sortByValueList(Map<K, V> map) {

        if (map == null) {
            throw new IllegalArgumentException("Map cannot be null");
        }

        List<V> list = new ArrayList<>(map.values());

        Collections.sort(list);

        return list;
    }
}
