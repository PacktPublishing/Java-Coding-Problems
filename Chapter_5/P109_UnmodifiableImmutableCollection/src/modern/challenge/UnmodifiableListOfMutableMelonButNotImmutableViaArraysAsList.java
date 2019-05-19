package modern.challenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnmodifiableListOfMutableMelonButNotImmutableViaArraysAsList {

    private final List<MutableMelon> list = Collections.unmodifiableList(
            Arrays.asList(new MutableMelon("Crenshaw", 2000), new MutableMelon("Gac", 1200)));

    public void proof() {
        System.out.println("List before mutation of melons: " + list);
        MutableMelon melon1 = list.get(0);
        MutableMelon melon2 = list.get(1);
        melon1.setWeight(0);
        melon2.setWeight(0);
        System.out.println("List after mutation of melons: " + list);
    }
}
