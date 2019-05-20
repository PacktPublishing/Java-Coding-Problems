package modern.challenge;

import java.lang.reflect.Field;

public class Car {

    private String type = "Dacia";

    public class Engine {

        private String power = "80 hp";

        public void addEngine() {
            System.out.println("Add engine of " + power + " to car of type " + type);
        }
    }

    public static Car newCar(String type, String power) 
            throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Car newCar = new Car();
        newCar.type = type;
        Engine engine = newCar.new Engine();
        
        // engine.power = power; // this will work

        Field powerField = Engine.class.getDeclaredField("power");
        // powerField.setAccessible(true); // this is needed before JDK 11
        powerField.set(engine, power);
         
        return newCar;
    }        
}
