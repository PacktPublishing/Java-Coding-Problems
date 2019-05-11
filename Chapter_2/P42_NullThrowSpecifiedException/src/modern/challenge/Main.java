package modern.challenge;

import java.awt.Color;

public class Main {

    public static void main(String[] args) {

        // This code will cause an exception of type IllegalArgumentException: Licence cannot be null
        
        Car car = new Car("Mazda", new Color(123, 123, 123));
        car.assignDriver(null, null);
    }
    
}
