package modern.challenge;

import java.util.Arrays;
import java.util.Map;

public final class Maps {

    private Maps() {
        throw new AssertionError("Cannot be modified");
    }
    
    public static <A, B> boolean equalsWithArrays(Map<A, B[]> first, Map<A, B[]> second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException("Both maps must be not null");
        }

        if (first.size() != second.size()) {
            return false;
        }

        return first.entrySet().stream()
                .allMatch(e -> Arrays.equals(e.getValue(), second.get(e.getKey())));
    }
}
