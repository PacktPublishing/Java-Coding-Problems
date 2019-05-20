package modern.challenge;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Melon<E extends Exception>
        extends Fruit<String, Seed> implements Comparable<Integer> {

    private final String type;
    private final int weight;
    private List<Slice> slices;   

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public List<Slice> slice() throws E {
        return Collections.emptyList();
    }

    public Map<String, Integer> asMap(List<Melon> melons) {
        return Collections.emptyMap();
    }

    @Override
    public String toString() {
        return type + "(" + weight + "g)";
    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}
