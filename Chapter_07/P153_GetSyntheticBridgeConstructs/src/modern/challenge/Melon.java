package modern.challenge;

import java.util.Comparator;

public class Melon implements Comparator<Melon> {

    private final String type;
    private final int weight;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }                

    @Override
    public int compare(Melon m1, Melon m2) {
        return Integer.compare(m1.getWeight(), m2.getWeight());
    }
    
    public class Slice {         
    }
        
    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return type + "(" + weight + "g)";
    }
}
