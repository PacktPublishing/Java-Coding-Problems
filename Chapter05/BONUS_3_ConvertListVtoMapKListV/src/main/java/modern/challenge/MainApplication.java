package modern.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) {

        /* Convert List<V> into Map<K, List<V>> */
        // consider this list
        List<String> names
                = List.of("joana", "mark", "adela", "leo", "stan", "marius", "kely");

        HashMap<Integer, List<String>> result1
                = Converters.toMap(names, String::length, HashMap::new, ArrayList::new);
        System.out.println("HashMap<Integer, List<String>>: " + result1);

        LinkedHashMap<Integer, List<String>> result2
                = Converters.toMap(names, String::length, LinkedHashMap::new, LinkedList::new);
        System.out.println("LinkedHashMap<Integer, List<String>>: " + result2);
    }
}
