package modern.challenge;

import java.util.Collections;
import java.util.List;

public class Melon {

    private String type;
    private int weight;
    
    public Melon() {        
    }

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public List<Melon> cultivate(String type, Seed seed, int noOfSeeds) {
        System.out.println("The cultivate() method was invoked ...");
        return Collections.nCopies(noOfSeeds, new Melon("Gac", 5));
    }

    @Override
    public String toString() {
        return type + "(" + weight + "g)";
    }
}
