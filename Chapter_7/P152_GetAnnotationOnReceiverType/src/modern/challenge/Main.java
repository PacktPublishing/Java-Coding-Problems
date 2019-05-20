package modern.challenge;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
       
        Class<Melon> clazz = Melon.class;
        Method eatMethod = clazz.getDeclaredMethod("eat");
        AnnotatedType annotatedType = eatMethod.getAnnotatedReceiverType();
        
        System.out.println("Type: " + annotatedType.getType().getTypeName());        
        System.out.println("Annotations: " + Arrays.toString(annotatedType.getAnnotations()));        
        System.out.println("Class implementing interfaces: " +
                Arrays.toString(annotatedType.getClass().getInterfaces()));
        
        AnnotatedType annotatedOwnerType = annotatedType.getAnnotatedOwnerType();
        System.out.println("\nAnnotated owner type: " + annotatedOwnerType);        
    }

}
