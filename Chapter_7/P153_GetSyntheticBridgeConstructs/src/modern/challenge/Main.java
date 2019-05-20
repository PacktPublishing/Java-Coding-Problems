package modern.challenge;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
                
        System.out.println("Synthetic fields");
        System.out.println("----------------");
        
        Class<Melon.Slice> clazzSlice = Melon.Slice.class;
        Field[] fields = clazzSlice.getDeclaredFields();
        System.out.println("Number of fields: " + fields.length);
        System.out.println("Is synthetic: " + fields[0].isSynthetic());
        System.out.println("Name: " + fields[0].getName());
        
        System.out.println("\nSynthetic and bridge methods");
        System.out.println("------------------------------");
                
        Class<Melon> clazz = Melon.class;
        Method[] methods = clazz.getDeclaredMethods();
        Method compareBridge = Arrays.asList(methods).stream()
                .filter(m -> m.isSynthetic() && m.isBridge())
                .findFirst()
                .orElseThrow();
        
        System.out.println(compareBridge);                
    }
    
}
