package modern.challenge;

import java.util.Comparator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Melon[] melons = new Melon[]{
            new Melon("Crenshaw", 2000), new Melon("Gac", 1200),
            new Melon("Bitter", 2200), new Melon("Hami", 800)};
        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);

        Map.Entry<Melon, Melon> minmax1 = Bounds.arrayV1(melons, byWeight);
        System.out.println("Min (Map.Entry): " + minmax1.getKey());
        System.out.println("Max (Map.Entry): " + minmax1.getValue());

        Pair<Melon, Melon> minmax2 = Bounds.arrayV2(melons, byWeight);
        System.out.println("Min (Pair): " + minmax2.left);
        System.out.println("Max (Pair): " + minmax2.right);
    }

}
