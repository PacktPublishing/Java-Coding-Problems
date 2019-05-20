package modern.challenge;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ReflectiveOperationException {

        List<Method> staticMethods = new ArrayList<>();
        Class<Melon> clazz = Melon.class;

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (Modifier.isStatic(method.getModifiers())) {
                staticMethods.add(method);
            }
        }

        System.out.println(staticMethods);
        System.out.println();

        Method method = clazz.getMethod("peel", Slice.class);
        method.invoke(null, new Slice());
    }

}
