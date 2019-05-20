package modern.challenge;

import java.util.Objects;

public class Melon {

    enum Sugar {
        LOW, MEDIUM, HIGH, UNKONWN
    }

    private final String type;
    private final int weight;
    private final Sugar sugar;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
        this.sugar = Sugar.UNKONWN;
    }

    public Melon(String type, int weight, Sugar sugar) {
        this.type = type;
        this.weight = weight;
        this.sugar = sugar;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public Sugar getSugar() {
        return sugar;
    }

    @Override
    public String toString() {
        return type + "(" + weight + "g)" + (sugar != Sugar.UNKONWN ? " " + sugar : "");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + this.weight;
        hash = 53 * hash + Objects.hashCode(this.sugar);
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
        if (!Objects.equals(this.sugar, other.sugar)) {
            return false;
        }
        return true;
    }

}
