package modern.challenge;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        Class<Melon> clazz = Melon.class;
        
        Method[] methods = clazz.getDeclaredMethods();
        
        for(Method method: methods) {
            System.out.println("Method name: " + method.getName() 
                    + ", varargs? " + method.isVarArgs());
        }
    }
    
}
