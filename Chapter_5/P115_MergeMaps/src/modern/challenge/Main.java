package modern.challenge;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println("Merging two maps: ");
        System.out.println("---------------------------------------");

        Map<Integer, Melon> melons1 = new HashMap<>();
        Map<Integer, Melon> melons2 = new HashMap<>();

        melons1.put(1, new Melon("Apollo", 3000));
        melons1.put(2, new Melon("Jade Dew", 3500));
        melons1.put(3, new Melon("Cantaloupe", 1500));

        melons2.put(3, new Melon("Apollo", 3000));
        melons2.put(4, new Melon("Jade Dew", 3500));
        melons2.put(5, new Melon("Cantaloupe", 1500));

        Map<Integer, Melon> merged1 = Maps.mergeMapsV1(melons1, melons2);
        System.out.println(merged1);

        Map<Integer, Melon> merged2 = Maps.mergeMapsV2(melons1, melons2);
        System.out.println(merged2);
    }

}
