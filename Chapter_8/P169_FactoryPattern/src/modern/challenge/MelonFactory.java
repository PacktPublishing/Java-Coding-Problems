package modern.challenge;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class MelonFactory {

    private MelonFactory() {
        throw new AssertionError("Cannot be instantiated");
    }

    private static final TriFunction<String, Integer, String, Melon> MELON = Melon::new;

    private static final Map<String, Supplier<Fruit>> MELONS
            = Map.of("Gac", Gac::new, "Hemi", Hemi::new, "Cantaloupe", Cantaloupe::new);

    public static Fruit newInstance(String name, int weight, String color) {
        return MELON.apply(name, weight, name);
    }

    public static Fruit newInstance(Class<?> clazz) {

        Supplier<Fruit> supplier = MELONS.get(clazz.getSimpleName());

        if (supplier == null) {
            throw new IllegalArgumentException("Invalid clazz argument: " + clazz);
        }

        return supplier.get();
    }

    /*
    public static Fruit newInstance(Class<?> clazz) {

        switch (clazz.getSimpleName()) {

            case "Gac":
                return new Gac();
            case "Hemi":
                return new Hemi();
            case "Cantaloupe":
                return new Cantaloupe();
            default:
                throw new IllegalArgumentException("Invalid clazz argument: " + clazz);
        }
    }
     */
}
