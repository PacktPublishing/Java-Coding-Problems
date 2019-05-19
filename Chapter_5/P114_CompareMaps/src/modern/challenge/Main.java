package modern.challenge;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
             
        System.out.println("Check equality of two maps via equals(): ");
        System.out.println("---------------------------------------");

        Map<Integer, Melon> melons1Map = new HashMap<>();
        Map<Integer, Melon> melons2Map = new HashMap<>();

        melons1Map.put(1, new Melon("Apollo", 3000));
        melons1Map.put(2, new Melon("Jade Dew", 3500));
        melons1Map.put(3, new Melon("Cantaloupe", 1500));

        melons2Map.put(1, new Melon("Apollo", 3000));
        melons2Map.put(2, new Melon("Jade Dew", 3500));
        melons2Map.put(3, new Melon("Cantaloupe", 1500));

        boolean equals12Map = melons1Map.equals(melons2Map);
        System.out.println("Check equality via Maps.equals(): " + equals12Map);

        System.out.println("\nCheck equality of two maps via Arrays.equals(): ");
        System.out.println("---------------------------------------");

        Melon[] melons1Array = {new Melon("Apollo", 3000),
            new Melon("Jade Dew", 3500), new Melon("Cantaloupe", 1500)};

        Melon[] melons2Array = {new Melon("Apollo", 3000),
            new Melon("Jade Dew", 3500), new Melon("Cantaloupe", 1500)};

        Map<Integer, Melon[]> melons1ArrayMap = new HashMap<>();
        melons1ArrayMap.put(1, melons1Array);

        Map<Integer, Melon[]> melons2ArrayMap = new HashMap<>();
        melons2ArrayMap.put(1, melons2Array);

        boolean equals12ArrayMap1 = melons1ArrayMap.equals(melons2ArrayMap);
        System.out.println("Check equality via Maps.equals(): " + equals12ArrayMap1);
        boolean equals12ArrayMap2 = Maps.equalsWithArrays(melons1ArrayMap, melons2ArrayMap);
        System.out.println("Check equality via Maps.equalsWithArrays(): " + equals12ArrayMap2);
    }

}
