package modern.challenge;

import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ReflectiveOperationException {

        Class<Melon> clazz = Melon.class;

        Method sliceMethod = clazz.getDeclaredMethod("slice");
        Method asMapMethod = clazz.getDeclaredMethod("asMap", List.class);        
        Field slicesField = clazz.getDeclaredField("slices");
               
        Type sliceReturnType = sliceMethod.getGenericReturnType();
        Type asMapReturnType = asMapMethod.getGenericReturnType();
        Type[] asMapParamTypes = asMapMethod.getGenericParameterTypes();
        Type slicesType = slicesField.getGenericType();
        Type superclassType = clazz.getGenericSuperclass();
        Type[] interfacesTypes = clazz.getGenericInterfaces();
        Type[] exceptionsTypes = sliceMethod.getGenericExceptionTypes();

        System.out.println("Generic return of slice(), List<Slice>:");
        printGenerics(sliceReturnType);

        System.out.println("\nGeneric return of asMap(), Map<String, Integer>:");
        printGenerics(asMapReturnType);

        System.out.println("\nGeneric parameters of asMap(), List<Melon>:");        
        for (Type paramType : asMapParamTypes) {
            printGenerics(paramType);
        }
        
        System.out.println("\nGeneric parameters of 'slices' field, List<Slice>:");
        printGenerics(slicesType);
        
        System.out.println("\nGeneric parameters of superclass, Map<String, Seed>:");
        printGenerics(superclassType);
        
        System.out.println("\nGeneric parameters of implemented interfaces, Comparable<Integer>:");        
        for (Type paramType : interfacesTypes) {
            printGenerics(paramType);
        }
        
        System.out.println("\nGeneric parameters of Melon<E extends Exception>:");        
        for (Type paramType : exceptionsTypes) {
            printGenericsOfExceptions(paramType);
        }
    }

    private static void printGenerics(Type genericType) {        
        
        if (genericType instanceof ParameterizedType) {

            ParameterizedType type = (ParameterizedType) genericType;
            Type[] typeOfArguments = type.getActualTypeArguments();

            for (Type typeOfArgument : typeOfArguments) {
                Class classTypeOfArgument = (Class) typeOfArgument;
                System.out.println("Class of type argument: " + classTypeOfArgument);
                System.out.println("Simple name of type argument: " + classTypeOfArgument.getSimpleName());
            }
        }
    }
    
    private static void printGenericsOfExceptions(Type genericType) {
        
        if (genericType instanceof TypeVariable) {

            TypeVariable typeVariable = (TypeVariable) genericType;
            GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();

            System.out.println("Generic declaration: " + genericDeclaration);
                System.out.println("Bounds: ");
                for (Type type: typeVariable.getBounds()) {
                    System.out.println(type);
                }
        }
    }
}
