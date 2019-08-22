package modern.challenge.bad;

import java.util.Objects;

public class JumpJet extends Vehicle {

    public final String name;

    public JumpJet(String type, int year, String name) {
        super(type, year);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {      
        return Objects.hash(name, this.getType(), this.getYear());
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof JumpJet)) {
            return false;
        }

        final JumpJet other = (JumpJet) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }

        if (!Objects.equals(this.getType(), other.getType())) {
            return false;
        }

        if (this.getYear() != other.getYear()) {
            return false;
        }

        return true;
    }

}
