package modern.challenge;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Class<Melon> clazz = Melon.class;

        Field[] fields = clazz.getDeclaredFields();

        List<Field> publicFields = new ArrayList<>();
        List<Field> privateFields = new ArrayList<>();

        for (Field field : fields) {

            if (Modifier.isPublic(field.getModifiers())) {
                publicFields.add(field);
            }

            if (Modifier.isPrivate(field.getModifiers())) {
                privateFields.add(field);
            }
        }

        System.out.println("Public fields: ");
        System.out.println(publicFields);
        System.out.println("\nPrivate fields: ");
        System.out.println(privateFields);
    }

}
