package modern.challenge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "postgresql");
        map.put(2, "mysql");
        map.put(3, "derby");

        System.out.println("Initial map: " + map);

        String r1 = map.remove(1);
        String r2 = map.remove(4);

        System.out.println("Removing entry with key 1: " + r1);
        System.out.println("Removing entry with key 4: " + r2);

        System.out.println("Resulted map: " + map);

        boolean r3 = map.remove(2, "mysql");
        boolean r4 = map.remove(3, "mysql");

        System.out.println("Removing entry with key 2 and value 'mysql': " + r3);
        System.out.println("Removing entry with key 4 and value 'mysql': " + r4);

        System.out.println("Resulted map: " + map);

        // iterating and removing
        for (Iterator<Map.Entry<Integer, String>> it
                = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Integer, String> entry = it.next();
            if (entry.getValue().equals("mysql")) {
                it.remove();
            }
        }
        
        // Java 8
        map.entrySet().removeIf(e -> e.getValue().equals("mysql"));
    }

}
