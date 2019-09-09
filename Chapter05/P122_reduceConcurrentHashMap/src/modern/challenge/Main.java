package modern.challenge;

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
        
        String result = map.reduce(2, (k, v) -> v = v + "   ", (t, v) -> t + v);
        System.out.println("\nNames concatenated and separated by tab via reduce():\n" + result);
        
        Integer maxKey = map.reduceKeys(2, (k1, k2) -> k1.compareTo(k2) > 0 ? k1 : k2);  
        System.out.println("\nMaximum key via reduceKeys(): " + maxKey);
        
        String resultValue = map.reduceValues(2, (v) -> v = v + "   ", (t, v) -> t + v);
        System.out.println("\nNames concatenated and separated by tab via reduceValues():\n" + resultValue);        
    }
    
}
