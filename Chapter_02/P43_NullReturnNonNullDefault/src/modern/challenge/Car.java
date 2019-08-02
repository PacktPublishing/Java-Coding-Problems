package modern.challenge;

import java.awt.Color;
import java.util.Objects;

public class Car {

    private final String name;
    private final Color color;

    public Car(String name, Color color) {

        this.name = Objects.requireNonNullElse(name, "No name");
        this.color = Objects.requireNonNullElseGet(color, () -> new Color(0, 0, 0));
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }   
}
