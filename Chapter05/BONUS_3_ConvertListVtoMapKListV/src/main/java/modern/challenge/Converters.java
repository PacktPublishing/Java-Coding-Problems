package modern.challenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Converters {

    private Converters() {
        throw new AssertionError("Cannot be instantiatied");
    }

    public static Map<Integer, List<String>> toMap(List<String> list) {

        if (list == null || list.isEmpty()) {
            return Collections.emptyMap();
        }

        return list.stream().collect(
                Collectors.groupingBy(String::length,
                        HashMap::new, Collectors.toCollection(ArrayList::new))
        );
    }

    @SuppressWarnings("unchecked")
    public static <K, V, C extends Collection<V>, M extends Map<K, C>> M toMap(
            List<V> list, Function<? super V, ? extends K> c, Supplier<M> ms, Supplier<C> cs) {

        if (list == null || c == null || ms == null || cs == null
                || list.isEmpty()) {           
            
            throw new IllegalArgumentException("Non of the arguments can be null or empty");
        }

        return list.stream().collect(
                Collectors.groupingBy(c, ms, Collectors.toCollection(cs))
        );
    }

}