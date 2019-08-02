package modern.challenge;

import java.awt.Color;
import java.awt.Point;
import java.util.Objects;

public class NewCar {

    private final String name;
    private final Color color;

    public NewCar(String name, Color color) {
        
        this.name = Objects.requireNonNull(name, "Car name cannot be null");
        this.color = Objects.requireNonNull(color, "Car color cannot be null");
    }

    public void assignDriver(String license, Point location) {
        
        Objects.requireNonNull(license, "Driver license cannot be null");
        Objects.requireNonNull(location, "Start location cannot be null");        
    }
}
