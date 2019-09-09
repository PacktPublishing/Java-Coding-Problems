package modern.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Melon {

    private final String type;
    private final int weight;
    private final List<String> pests;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
        this.pests = new ArrayList<>();
    }

    public Melon(String type, int weight, List<String> pests) {
        this.type = type;
        this.weight = weight;
        this.pests = pests;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public List<String> getPests() {
        return pests;
    }

    @Override
    public String toString() {
        return type + "(" + weight + "g)" + (pests.size() > 0 ? " " + pests : "");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + this.weight;
        hash = 53 * hash + Objects.hashCode(this.pests);
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
        if (!Objects.equals(this.pests, other.pests)) {
            return false;
        }
        return true;
    }

}
