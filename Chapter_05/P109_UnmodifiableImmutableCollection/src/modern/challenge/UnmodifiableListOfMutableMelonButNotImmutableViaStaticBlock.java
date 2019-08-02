package modern.challenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnmodifiableListOfMutableMelonButNotImmutableViaStaticBlock {

    private static final List<MutableMelon> list;

    static {
        final MutableMelon melon1 = new MutableMelon("Crenshaw", 2000);
        final MutableMelon melon2 = new MutableMelon("Gac", 1200);      
        
        list = Collections.unmodifiableList(Arrays.asList(melon1, melon2));
    }

    public void proof() {
        System.out.println("List before mutation of melons: " + list);
        MutableMelon melon1l = list.get(0);
        MutableMelon melon2l = list.get(1);
        melon1l.setWeight(0);
        melon2l.setWeight(0);
        System.out.println("List after mutation of melons: " + list);
    }

}
