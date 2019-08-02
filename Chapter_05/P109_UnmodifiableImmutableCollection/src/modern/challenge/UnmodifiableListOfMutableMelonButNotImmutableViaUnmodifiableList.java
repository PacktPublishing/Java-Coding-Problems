package modern.challenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnmodifiableListOfMutableMelonButNotImmutableViaUnmodifiableList {

    private final MutableMelon melon1 = new MutableMelon("Crenshaw", 2000);
    private final MutableMelon melon2 = new MutableMelon("Gac", 1200);
    private final List<MutableMelon> list
            = Collections.unmodifiableList(Arrays.asList(melon1, melon2));

    public void proof() {
        System.out.println("List before mutation of melons: " + list);
        melon1.setWeight(0);
        melon2.setWeight(0);
        System.out.println("List after mutation of melons: " + list);

    }

}
