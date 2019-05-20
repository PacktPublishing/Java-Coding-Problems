package modern.challenge;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ReflectiveOperationException {

        Class<Melon> clazz = Melon.class;

        System.out.println("Inspecting package annotations: ");
        Annotation[] pckgAnnotations = clazz.getPackage().getAnnotations();
        System.out.println("Package annotations: " + Arrays.toString(pckgAnnotations));

        System.out.println("\nInspecting class annotations: ");
        Annotation[] clazzAnnotations = clazz.getAnnotations();
        System.out.println("Class annotations: " + Arrays.toString(clazzAnnotations));
        Fruit fruitAnnotation = (Fruit) clazzAnnotations[0];
        System.out.println("@Fruit name: " + fruitAnnotation.name());
        System.out.println("@Fruit value: " + fruitAnnotation.value());

        System.out.println("\nInspecting methods annotations: ");
        Method methodEat = clazz.getDeclaredMethod("eat");
        Annotation[] methodAnnotations = methodEat.getDeclaredAnnotations();
        System.out.println("Method annotations: " + Arrays.toString(methodAnnotations));
        Ripe ripeAnnotation = (Ripe) methodAnnotations[0];
        System.out.println("@Ripe value: " + ripeAnnotation.value());

        System.out.println("\nInspecting annotations of the thrown exceptions: ");
        AnnotatedType[] exceptionsTypes = methodEat.getAnnotatedExceptionTypes();
        System.out.println("Exceptions types: " + Arrays.toString(exceptionsTypes));
        System.out.println("First exception type: " + exceptionsTypes[0].getType());
        System.out.println("Annotations of the first exception type: "
                + Arrays.toString(exceptionsTypes[0].getAnnotations()));

        System.out.println("\nInspecting annotations of the return type");
        Method methodSeeds = clazz.getDeclaredMethod("seeds");
        AnnotatedType returnType = methodSeeds.getAnnotatedReturnType();
        System.out.println("Return type: " + returnType.getType().getTypeName());
        System.out.println("Annotations of the return type: "
                + Arrays.toString(returnType.getAnnotations()));

        System.out.println("\nInspecting annotations of the method's parameters: ");
        Method methodSlice = clazz.getDeclaredMethod("slice", int.class);
        Annotation[][] paramAnnotations = methodSlice.getParameterAnnotations();
        Class<?>[] parameterTypes = methodSlice.getParameterTypes();

        int i = 0;
        for (Annotation[] annotations : paramAnnotations) {
            Class parameterType = parameterTypes[i++];

            System.out.println("Parameter type: " + parameterType.getName());
            for (Annotation annotation : annotations) {
                System.out.println("Annotation: " + annotation);
                System.out.println("Annotation name: "
                        + annotation.annotationType().getSimpleName());
            }
        }

        System.out.println("\nInspecting annotations of fields: ");
        Field weightField = clazz.getDeclaredField("weight");
        Annotation[] fieldAnnotations = weightField.getDeclaredAnnotations();
        Unit unitFieldAnnotation = (Unit) fieldAnnotations[0];
        System.out.println("@Unit value: " + unitFieldAnnotation.value());

        System.out.println("\nInspecting annotations of superclass: ");
        AnnotatedType superclassType = clazz.getAnnotatedSuperclass();
        System.out.println("Superclass type: " + superclassType.getType().getTypeName());
        System.out.println("Annotations: " + Arrays.toString(superclassType.getDeclaredAnnotations()));
        System.out.println("@Family annotation present: " + superclassType.isAnnotationPresent(Family.class));

        System.out.println("\nInspecting annotations of interfaces: ");
        AnnotatedType[] interfacesTypes = clazz.getAnnotatedInterfaces();
        System.out.println("Interfaces types: " + Arrays.toString(interfacesTypes));
        System.out.println("First interface type: " + interfacesTypes[0].getType());
        System.out.println("Annotations of the first exception type: "
                + Arrays.toString(interfacesTypes[0].getAnnotations()));

        System.out.println("\nGet annotations by type:");
        Fruit[] clazzFruitAnnotations = clazz.getAnnotationsByType(Fruit.class);
        for (Fruit clazzFruitAnnotation : clazzFruitAnnotations) {
            System.out.println("Fruit annotation name: " + clazzFruitAnnotation.name());
            System.out.println("Fruit annotation value: " + clazzFruitAnnotation.value());
        }

        System.out.println("\nGet a declared annotation:");
        Ripe methodRipeAnnotation = methodEat.getDeclaredAnnotation(Ripe.class);
        System.out.println("Shape annotation value: " + methodRipeAnnotation.value());
    }
}
