package modern.challenge;

import java.util.List;

public class ImmutableListOfImmutableMelonViaListOf {

    private static final ImmutableMelon MELON_1 = new ImmutableMelon("Crenshaw", 2000);
    private static final ImmutableMelon MELON_2 = new ImmutableMelon("Gac", 1200);

    private static final List<ImmutableMelon> LIST = List.of(MELON_1, MELON_2);

    public void proof() {
        System.out.println("List before mutation of melons: " + LIST);
        System.out.println("Cannot mutate the melons since they are immutable!");
    }
}
