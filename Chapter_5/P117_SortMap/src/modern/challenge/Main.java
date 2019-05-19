package modern.challenge;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Map<String, Melon> melons = new HashMap<>();

        melons.put("delicious", new Melon("Apollo", 3000));
        melons.put("refreshing", new Melon("Jade Dew", 3500));
        melons.put("famous", new Melon("Cantaloupe", 1500));

        System.out.println("Original map: " + melons + "\n\n");

        TreeMap<String, Melon> sortedByKeyTreeMap = Maps.sortByKeyTreeMap(melons);
        System.out.println("Natural ordering by keys via TreeMap: " + sortedByKeyTreeMap);

        List<String> sortedByKeyList = Maps.sortByKeyList(melons);
        System.out.println("Natural ordering by keys via List: " + sortedByKeyList);

        List<Melon> sortedByValueList = Maps.sortByValueList(melons);
        System.out.println("Ordering by values via List and Comparable: " + sortedByValueList);

        Comparator<String> byInt = Comparator.naturalOrder();
        Map<String, Melon> sortedByKeyStream = Maps.sortByKeyStream(melons, byInt);
        System.out.println("Ordering by keys via Map and Comparator: " + sortedByKeyStream);

        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);
        Map<String, Melon> sortedByValueStream = Maps.sortByValueStream(melons, byWeight);
        System.out.println("Ordering by values via Map and Comparator: " + sortedByValueStream);
    }    
}
