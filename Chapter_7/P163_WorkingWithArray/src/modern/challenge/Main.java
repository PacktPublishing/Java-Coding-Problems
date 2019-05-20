package modern.challenge;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {

        int[] arrayOfInt = (int[]) Array.newInstance(int.class, 10);
        Array.setInt(arrayOfInt, 0, 100);
        
        int valueIndex0 = Array.getInt(arrayOfInt, 0);
        System.out.println("At index 0 the value is: " + valueIndex0);
        
        Class<?> stringClass = String[].class;
        Class<?> clazz = arrayOfInt.getClass();
        
        Class<?> typeInt = clazz.getComponentType();
        Class<?> typeString = stringClass.getComponentType();
        
        System.out.println("Type 'String[]': " + typeString.getName());
        System.out.println("Type 'arrayOfInt': " + typeInt.getName());
    }
    
}
