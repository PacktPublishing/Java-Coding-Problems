package modern.challenge;

public class Main {

    public static void main(String[] args) {

        Melon[] melons = {
            new Melon("Gac", 1200),
            new Melon("Hemi", 2300),
            new Melon("Apollo", 3400)
        };

        int[] weights = {1200, 2300, 3400};

        System.out.println("Array of melons to stream (toStream1()):");
        Convertors.toStream1(melons)
                .forEach(System.out::println);

        System.out.println("\n\nArray of melons to stream (toStream2()):");
        Convertors.toStream2(melons)
                .forEach(System.out::println);

        System.out.println("\n\nArray of melons to stream (toStream3()):");
        Convertors.toStream3(melons)
                .forEach(System.out::println);

        System.out.println("\n\nArray of integers to stream (toStream4()):");
        Convertors.toStream4(weights)
                .forEach(System.out::println);

        System.out.println("\n\nArray of integers to stream (toStream5()):");
        Convertors.toStream5(weights)
                .forEach(System.out::println);
    }
}
