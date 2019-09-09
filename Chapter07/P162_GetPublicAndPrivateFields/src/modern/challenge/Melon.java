package modern.challenge;

public class Melon {

    private String type;
    private int weight;    
    public Peeler peeler;
    public Juicer juicer;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }
   
    @Override
    public String toString() {
        return type + "(" + weight + "g)";
    }
}
