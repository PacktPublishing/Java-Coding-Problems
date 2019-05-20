package modern.challenge;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.type);
        hash = 79 * hash + this.weight;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Melon other = (Melon) obj;
        if (this.weight != other.weight) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }
        
}
