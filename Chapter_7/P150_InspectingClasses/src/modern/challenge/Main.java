package modern.challenge;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) 
            throws ClassNotFoundException, NoSuchFieldException {

        Pair pair = new Pair(1, 1);

        System.out.println("Get the name of the Pair class via an instance:");
        Class<?> clazz = pair.getClass();
        // Class<Pair> clazz = Pair.class;
        // Class<?> clazz = Class.forName("modern.challenge.Pair");
        System.out.println("Name: " + clazz.getName());
        System.out.println("Simple name: " + clazz.getSimpleName());
        System.out.println("Canonical name: " + clazz.getCanonicalName());

        System.out.println("\nGet the Pair class modifiers:");
        int modifiers = clazz.getModifiers();
        System.out.println("Is public? " + Modifier.isPublic(modifiers));
        System.out.println("Is final? " + Modifier.isFinal(modifiers));
        System.out.println("Is abstract? " + Modifier.isAbstract(modifiers));

        System.out.println("\nGet the Pair class implemented interfaces:");
        Class<?>[] interfaces = clazz.getInterfaces();
        System.out.println("Interfaces: " + Arrays.toString(interfaces));
        System.out.println("Interface simple name: " + interfaces[0].getSimpleName());

        System.out.println("\nGet the Pair class constructors:");
        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println("Constructors: " + Arrays.toString(constructors));

        System.out.println("\nGet the Pair class fields:");
        Field[] fields = clazz.getDeclaredFields();
        List<String> fieldsName = getFieldNames(fields);
        System.out.println("Fields: " + Arrays.toString(fields));
        System.out.println("Fields names: " + fieldsName);

        System.out.println("\nGet the Pair class methods:");
        Method[] methods = clazz.getMethods();
        List<String> methodsName = getMethodNames(methods);
        System.out.println("Methods: " + Arrays.toString(methods));
        System.out.println("Methods names: " + methodsName);

        System.out.println("\nGet the Pair class module:");
        Module module = clazz.getModule();
        System.out.println("Module: " + module.getName());

        System.out.println("\nGet the Pair super-class:");
        Class<?> superClass = clazz.getSuperclass();
        System.out.println("Super-class: " + superClass.getName());

        System.out.println("\nGet type name:");
        System.out.println("Primitive type name: " + int.class.getTypeName());
        System.out.println("Pair type name: " + clazz.getTypeName());
        System.out.println("Inner class type name: " + Pair.Entry.class.getTypeName());

        Thread thread = new Thread() {
            public void run() {
                System.out.println("Child Thread");
            }
        };

        System.out.println("Anonymous class type name: " + thread.getClass().getTypeName());

        Pair[] pairs = new Pair[10];
        System.out.println("Array type name: " + pairs.getClass().getTypeName());

        System.out.println("\nGet a string that describes the class:");
        System.out.println("Description of Pair: " + clazz.toGenericString());
        System.out.println("Description of Runnable: " + Runnable.class.toGenericString());
        System.out.println("Description of Map: " + Map.class.toGenericString());

        System.out.println("\nGet the type descriptor string for a class:");
        System.out.println("Type descriptor of Pair: " + clazz.descriptorString());
        System.out.println("Type descriptor of String: " + String.class.descriptorString());

        System.out.println("\nGet the component type of an array:");
        System.out.println("Component type of Pair[]: " + pairs.getClass().componentType());
        String[] strings = new String[]{"1", "2", "3"};
        System.out.println("Component type of String[]: " + strings.getClass().componentType());

        System.out.println("\nGet a Class for an array type whose component type is described by Pair:");
        Class<?> arrayClazz = clazz.arrayType();
        System.out.println("Array type: " + arrayClazz.toGenericString());
    }

    private static List<String> getFieldNames(Field[] fields) {

        return Arrays.stream(fields)
                .map(Field::getName)
                .collect(Collectors.toList());
    }

    private static List<String> getMethodNames(Method[] methods) {

        return Arrays.stream(methods)
                .map(Method::getName)
                .collect(Collectors.toList());
    }
}
