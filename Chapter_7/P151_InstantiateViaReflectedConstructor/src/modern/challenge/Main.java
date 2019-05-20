package modern.challenge;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) 
            throws ReflectiveOperationException, MalformedURLException, FileNotFoundException {

        Class<Car> clazz = Car.class;

        Constructor<?>[] cnstrs = clazz.getConstructors();
        System.out.println("Car class has " + cnstrs.length + " constructors");

        for (Constructor<?> cnstr : cnstrs) {
            int paramCount = cnstr.getParameterCount();
            System.out.println("\nConstructor with " + paramCount + " parameters");
            if (paramCount > 0) {
                Parameter[] params = cnstr.getParameters();
                for (Parameter param : params) {
                    System.out.print(param.getType().getName() + "  ");
                }
                System.out.println();
            }
        }

        Constructor<Car> emptyCnstr = clazz.getConstructor();
        Constructor<Car> idNameCnstr = clazz.getConstructor(int.class, String.class);
        Constructor<Car> idColorCnstr = clazz.getConstructor(int.class, Color.class);
        Constructor<Car> idNameColorCnstr = clazz.getConstructor(int.class, String.class, Color.class);

        Car carViaEmptyCnstr = emptyCnstr.newInstance();
        Car carViaIdNameCnstr = idNameCnstr.newInstance(1, "Dacia");
        Car carViaIdColorCnstr = idColorCnstr.newInstance(1, new Color(0, 0, 0));
        Car carViaIdNameColorCnstr = idNameColorCnstr.newInstance(1, "Dacia", new Color(0, 0, 0));

        System.out.println("\n\nVia empty constructor: " + carViaEmptyCnstr);
        System.out.println("Via (id, name) constructor: " + carViaIdNameCnstr);
        System.out.println("Via (id, color) constructor: " + carViaIdColorCnstr);
        System.out.println("Via (id, name, color) constructor: " + carViaIdNameColorCnstr);

        System.out.println("\n\nInstantiating Cars via its private constructor");
        Class<Cars> carsClass = Cars.class;
        Constructor<Cars> emptyCarsCnstr = carsClass.getDeclaredConstructor();
        emptyCarsCnstr.setAccessible(true);
        Cars carsViaEmptyCnstr = emptyCarsCnstr.newInstance();
        System.out.println("Instance of Cars: " + carsViaEmptyCnstr);

        System.out.println("\n\nInstantiating CountingInputStream from Guava JAR");
        URL[] classLoaderUrls = new URL[]{new URL("file:///D:/Java Modern Challenge/Code/lib/guava-16.0.1.jar")};

        URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls);

        Class<?> cisClass = urlClassLoader.loadClass("com.google.common.io.CountingInputStream");

        Constructor<?> constructor = cisClass.getConstructor(InputStream.class);

        Object instance = constructor.newInstance(new FileInputStream​(Path.of("test.txt").toFile()));

        Method readMethod = cisClass.getMethod("read");
        Method countMethod = cisClass.getMethod("getCount");

        readMethod.invoke(instance);
        Object readBytes = countMethod.invoke(instance);
        System.out.println("Read bytes (should be 1): " + readBytes);
    }
}
