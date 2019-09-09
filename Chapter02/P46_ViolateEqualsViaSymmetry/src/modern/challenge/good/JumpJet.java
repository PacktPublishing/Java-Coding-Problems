package modern.challenge.good;

import java.util.Objects;

public class JumpJet {

    private final Vehicle vehicle;
    private final String name;

    public JumpJet(String type, int year, String name) {
        this.vehicle = new Vehicle(type, year);
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public int hashCode() {      
        return Objects.hash(name, vehicle.hashCode());
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

        if (!this.vehicle.equals(other.vehicle)) {
            return false;
        }

        return true;
    }
}
