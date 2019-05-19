package modern.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Main {
    
    public static void main(String[] args) {
        
        Map<Integer, Melon> mapOfMelon = new HashMap<>();
        
        mapOfMelon.put(1, new Melon("Apollo", 3000));
        mapOfMelon.put(2, new Melon("Jade Dew", 3500));
        mapOfMelon.put(3, new Melon("Cantaloupe", 1500));
        
        System.out.println("Replace by key\n--------------");
        System.out.println("Initial map: " + mapOfMelon);
        Melon melon1 = mapOfMelon.replace(2, new Melon("Gac", 1000));
        System.out.println("Replaced melon from key 2: " + melon1);
        System.out.println("Resulted map: " + mapOfMelon);
        
        System.out.println("\nReplace by key and value\n--------------");
        boolean melon2 = mapOfMelon.replace(1, new Melon("Apollo", 3000), new Melon("Bitter", 4300));
        System.out.println("Replaced melon from key 1 and value Applo(3000g): " + melon2);
        System.out.println("Resulted map: " + mapOfMelon);
        
        System.out.println("\nReplace via BiFunction\n--------------");
        BiFunction<Integer, Melon, Melon> function
                = (k, v) -> v.getWeight() > 1000 ? new Melon(v.getType(), 1000) : v;
        mapOfMelon.replaceAll(function);
        System.out.println("Resulted map: " + mapOfMelon);        
    }
    
}
