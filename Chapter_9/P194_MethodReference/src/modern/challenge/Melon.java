package modern.challenge;

public class Melon {

    private final String type;
    private int weight;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public static int growing100g(Melon melon) {
        melon.setWeight(melon.getWeight() + 100);

        return melon.getWeight();
    }

    public String getType() {
        return type;
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
