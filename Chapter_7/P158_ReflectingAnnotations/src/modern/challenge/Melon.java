package modern.challenge;

import java.util.Collections;
import java.util.List;

@Fruit(name = "melon", value = "delicious")
public class Melon extends @Family Cucurbitaceae 
        implements @ByWeight Comparable {

    private final String type;
    @Unit
    private final int weight;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    @Ripe(true)    
    public void eat() throws @Runtime IllegalStateException {
    }

    public void slice(@Ripe(true) @Shape("square") int noOfSlices) {
    }
            
    public @Shape("oval") List<Seed> seeds() {
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return type + "(" + weight + "g)";
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(((Melon) o).weight, this.weight);
    }
}
