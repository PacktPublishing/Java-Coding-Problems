package modern.challenge;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) 
            throws IntrospectionException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {

        System.out.println("Available getters and setters:");
        for (PropertyDescriptor pd : Introspector.getBeanInfo(Melon.class).getPropertyDescriptors()) {
            if (pd.getReadMethod() != null && !"class".equals(pd.getName())) {
                System.out.println(pd.getReadMethod());
            }
            if (pd.getWriteMethod() != null && !"class".equals(pd.getName())) {
                System.out.println(pd.getWriteMethod());
            }
        }

        Melon melon = new Melon("Gac", 1000);
        System.out.println("\nInitial melon: " + melon);

        System.out.println("\nCall getType():");
        Object type = new PropertyDescriptor("type", Melon.class).getReadMethod().invoke(melon);
        System.out.println("Melon type: " + type);

        System.out.println("\nCall getter of an inexistent property:");
        try {
            Object shape = new PropertyDescriptor("shape", Melon.class).getReadMethod().invoke(melon);
            System.out.println("Melon shape: " + shape);
        } catch (IntrospectionException e) {
            System.out.println("Property not found: " + e);
        }

        System.out.println("\nCall setWeight():");
        new PropertyDescriptor("weight", Melon.class).getWriteMethod().invoke(melon, 2000);
        Object weight = new PropertyDescriptor("weight", Melon.class).getReadMethod().invoke(melon);
        System.out.println("Melon weight: " + weight);

        System.out.println("\nCall setter of an inexistent property:");
        try {
            new PropertyDescriptor("shape", Melon.class).getWriteMethod().invoke(melon, "oval");
        } catch (IntrospectionException e) {
            System.out.println("Property not found: " + e);
        }
    }

}
