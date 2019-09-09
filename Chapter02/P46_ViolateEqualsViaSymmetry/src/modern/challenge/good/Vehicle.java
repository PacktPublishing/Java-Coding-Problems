package modern.challenge.good;

import java.util.Objects;

public class Vehicle {

    private final String type;
    private final int year;

    public Vehicle(String type, int year) {
        this.type = type;
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, year);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Vehicle)) {
            return false;
        }

        final Vehicle other = (Vehicle) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }

        if (this.year != other.year) {
            return false;
        }

        return true;
    }
}
