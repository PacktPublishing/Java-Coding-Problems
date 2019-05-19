package modern.challenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableListOfImmutableMelonViaUnmodifiableList {

    private static final ImmutableMelon MELON_1 = new ImmutableMelon("Crenshaw", 2000);
    private static final ImmutableMelon MELON_2 = new ImmutableMelon("Gac", 1200);

    private static final List<ImmutableMelon> LIST
            = Collections.unmodifiableList(Arrays.asList(MELON_1, MELON_2));

    public void proof() {
        System.out.println("List before mutation of melons: " + LIST);
        System.out.println("Cannot mutate the melons since they are immutable!");
    }
}
