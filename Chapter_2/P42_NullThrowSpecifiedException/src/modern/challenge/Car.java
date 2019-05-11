package modern.challenge;

import java.awt.Color;
import java.awt.Point;

public class Car {

    private final String name;
    private final Color color;

    public Car(String name, Color color) {

        this.name = MyObjects.requireNonNullElseThrow(name,
                new UnsupportedOperationException("Name cannot be set as null"));
        this.color = MyObjects.requireNotNullElseThrow(color,
                () -> new UnsupportedOperationException("Color cannot be set as null"));
    }

    public void assignDriver(String license, Point location) {

        MyObjects.requireNonNullElseThrowIAE(license, "Licence cannot be null");
        MyObjects.requireNonNullElseThrowIAE(location, () -> "Location cannot be null");
    }
}
