package modern.challenge;

import java.util.List;

public class UnmodifiableListOfMutableMelonButNotImmutableViaListOf {

    private final MutableMelon melon1 = new MutableMelon("Crenshaw", 2000);
    private final MutableMelon melon2 = new MutableMelon("Gac", 1200);
    
    private final List<MutableMelon> list = List.of(melon1, melon2);

    public void proof() {

        System.out.println("List before mutation of melons: " + list);
        MutableMelon melon1l = list.get(0);
        MutableMelon melon2l = list.get(1);
        melon1l.setWeight(0);
        melon2l.setWeight(0);
        System.out.println("List after mutation of melons: " + list);

    }
}
