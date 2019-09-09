package modern.challenge;

import java.awt.Color;

public class Car {

    private int id;
    private String name;
    private Color color;

    public Car() {
    }
 
    public Car(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Car(int id, Color color) {
        this.id = id;
        this.color = color;
    }

    public Car(int id, String name, Color color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", name=" + name + ", color=" + color + '}';
    }          
}
