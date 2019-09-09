package modern.challenge;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        // array of integers
        int[] integers = {2, 3, 4, 1, -4, 6, 2};

        // arrays of melons
        Melon[] melons = {new Melon("Horned", 1500), new Melon("Gac", 2200),
             new Melon("Hami", 1600), new Melon("Gac", 2100)};

        // Comparators
        Comparator<Melon> byType = Comparator.comparing(Melon::getType);

        System.out.println("Compute maximum of an array:");
        System.out.println("----------------------------\n");
        
        // compute maximum
        int maxInt1 = MathArrays.maxV1(integers);
        System.out.println("Solution based on BasicArrays.maxOfArray() with 'for' and 'if': " + maxInt1);

        int maxInt2 = MathArrays.maxV2(integers);
        System.out.println("Solution based on BasicArrays.maxOfArray() with 'for' and Math.max(): " + maxInt2);

        int maxInt3 = Arrays.stream(integers).max().getAsInt();
        System.out.println("Solution based on Java 8, functional-style: " + maxInt3);

        Melon maxMelon1 = MathArrays.maxV3(melons, byType);
        System.out.println("Solution based on Comparator: " + maxMelon1);

        @SuppressWarnings("unchecked")
        Melon maxMelon2 = MathArrays.maxV4(melons);
        System.out.println("Solution based on Comparable: " + maxMelon2);
        
        Melon maxMelon3 = Arrays.stream(melons).max(byType).orElseThrow();
        System.out.println("Solution based on Java 8, functional-style: " + maxMelon3);
        
        System.out.println("\nCompute average of an array:");
        System.out.println("----------------------------\n");
        
        double avg1 = MathArrays.average(integers);
        System.out.println("Average 1: " + avg1);
        
        double avg2 = Arrays.stream(integers).average().getAsDouble();
        System.out.println("Average 2: " + avg2);
    }

}