package modern.challenge;

public class Melon {

    private String type;
    private int weight;
    private boolean ripe;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setRipe(boolean ripe) {
        this.ripe = ripe;
    }

    @Override
    public String toString() {
        return type + "(" + weight + "g) " + (ripe ? "ripe" : "not ripe");
    }
}
