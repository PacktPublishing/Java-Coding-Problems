package modern.challenge;

public class Melon {

    private final String type;
    private int weight;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public void eat() {        
    }
    
    public void weighsIn() {        
    }

    public static void cultivate(Seed seeds) {        
        System.out.println("The cultivate() method was invoked ...");
    }

    public static void peel(Slice slice) {
        System.out.println("The peel() method was invoked ...");
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }   
    
    @Override
    public String toString() {
        return type + "(" + weight + "g)";
    }
}
