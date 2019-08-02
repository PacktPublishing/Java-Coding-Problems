package modern.challenge;

public class Melon {

    private String type;
    private int weight;
    private boolean ripe;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public void eat() {
    }

    public int sliceMelon() {
        return 8;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isRipe() {
        return ripe;
    }

    public void setRipe(boolean ripe) {
        this.ripe = ripe;
    }

    @Override
    public String toString() {
        return type + "(" + weight + "g) " + (!ripe ? "not ripe" : "ripe");
    }
}
