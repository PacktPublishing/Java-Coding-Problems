package modern.challenge;

import com.rits.cloning.Cloner;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public final class Maps {

    private Maps() {
        throw new AssertionError("Cannot be instantiatied");
    }

    @SuppressWarnings("unchecked")
    public static <K, V> HashMap<K, V> shallowCopyV1(Map<K, V> map) {

        if (map == null) {
            return (HashMap) Collections.emptyMap();
        }

        HashMap<K, V> copy = new HashMap<>();
        copy.putAll(map);

        return copy;
    }

    @SuppressWarnings("unchecked")
    public static <K, V> HashMap<K, V> shallowCopyV2(Map<K, V> map) {

        if (map == null) {
            return (HashMap) Collections.emptyMap();
        }

        Set<Entry<K, V>> entries = map.entrySet();

        HashMap<K, V> copy = (HashMap<K, V>) entries.stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return copy;
    }

    @SuppressWarnings("unchecked")
    public static <K, V> HashMap<K, V> deepCopy(Map<K, V> map) {

        if (map == null) {
            return (HashMap) Collections.emptyMap();
        }

        Cloner cloner = new Cloner();
        HashMap<K, V> copy = (HashMap<K, V>) cloner.deepClone(map);

        return copy;
    }
}
