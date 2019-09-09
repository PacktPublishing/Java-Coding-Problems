package modern.challenge;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Tylor");
        map.put(2, "Jenny");
        map.put(3, "Tymmy");
        map.put(4, "Anna");
        map.put(5, "Tysha");
        map.put(6, "Maria");

        System.out.println("Map: \n" + map);

        Integer key = map.search(2, (k, v) -> v.length() < 5 ? k : null);
        System.out.println("\nFind key via search(): " + key);

        Map.Entry<Integer, String> entry
                = map.searchEntries(2, (e) -> e.getValue().startsWith("A") ? e : null);
        System.out.println("\nFind entry via searchEntries(): " + entry);

        Integer keyFound = map.searchKeys(2, (k) -> k > 4 ? k : null);
        System.out.println("\nFind key via searchKeys(): " + keyFound);
        
        String valueFound = map.searchValues(2, (v) -> v.startsWith("M") ? v : null);
        System.out.println("\nFind value via searchValues(): " + valueFound);
    }

}
