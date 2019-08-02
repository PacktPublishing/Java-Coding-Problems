package modern.challenge;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        // arrays of integers
        int[] integers1 = new int[]{3, 4, 5, 6, 1, 5};
        int[] integers2 = new int[]{3, 4, 5, 6, 1, 5};
        int[] integers3 = new int[]{3, 4, 5, 6, 1, 3};

        // arrays of melons
        Melon[] melons1 = new Melon[]{new Melon("Horned", 1500), new Melon("Gac", 1000)};
        Melon[] melons2 = new Melon[]{new Melon("Horned", 1500), new Melon("Gac", 1000)};
        Melon[] melons3 = new Melon[]{new Melon("Hami", 1500), new Melon("Gac", 1000)};

        // Comparators
        Comparator<Melon> byType = Comparator.comparing(Melon::getType);
        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);

        System.out.println("equals:\n------\n");

        // integers1 equals integers2
        boolean i12 = Arrays.equals(integers1, integers2);
        System.out.println("integers 1 equal integers 2? " + i12);

        // integers1 equals integers3
        boolean i13 = Arrays.equals(integers1, integers3);
        System.out.println("integers 1 equal integers 3? " + i13);

        // integers1 equals integers3
        boolean is13 = Arrays.equals(integers1, 1, 4, integers3, 1, 4);
        System.out.println("integers 1 equal integers 3 between indexes 1-4? " + is13);

        // melons1 equals melons2
        boolean m12 = Arrays.equals(melons1, melons2);
        System.out.println("melons1 equals melons2? " + m12);

        // melons1 equals melons3
        boolean m13 = Arrays.equals(melons1, melons3);
        System.out.println("melons1 equals melons3? " + m13);

        // melons1 equals melons3
        boolean ms13 = Arrays.equals(melons1, 1, 2, melons3, 1, 2);
        System.out.println("melons1 equals melons3 between indexes 1-2? " + ms13);

        // melons1 equals melon3 via Comparator by weight        
        boolean mw13 = Arrays.equals(melons1, melons3, byWeight);
        System.out.println("melons1 equals melons3 by weight? " + mw13);

        // melons1 equals melon3 via Comparator by type        
        boolean mt13 = Arrays.equals(melons1, melons3, byType);
        System.out.println("melons1 equals melons3 by type? " + mt13);

        // melons1 equals melon3 in range via Comparator by type        
        boolean mrt13 = Arrays.equals(melons1, 1, 2, melons3, 1, 2, byType);
        System.out.println("melons1 equals melons3 by type between indexes 1-2? " + mrt13);

        System.out.println("\n\nmismatch:\n--------\n");

        // integers1 mismatch integers2
        int mi12 = Arrays.mismatch(integers1, integers2);
        System.out.println("integers 1 mismatch integers 2? " + mi12);

        // integers1 mismatch integers3
        int mi13 = Arrays.mismatch(integers1, integers3);
        System.out.println("integers 1 mismatch integers 3? " + mi13);

        // integers1 mismatch integers3
        int mis13 = Arrays.mismatch(integers1, 1, 4, integers3, 1, 4);
        System.out.println("integers 1 mismatch integers 3 between indexes 1-4? " + mis13);

        // melons1 mismatch melons2
        int mm12 = Arrays.mismatch(melons1, melons2);
        System.out.println("melons1 mismatch melons2? " + mm12);

        // melons1 mismatch melons3
        int mm13 = Arrays.mismatch(melons1, melons3);
        System.out.println("melons1 mismatch melons3? " + mm13);

        // melons1 mismatch melons3
        int mms13 = Arrays.mismatch(melons1, 1, 2, melons3, 1, 2);
        System.out.println("melons1 mismatch melons3 between indexes 1-2? " + mms13);

        // melons1 mismatch melon3 via Comparator by weight
        int mmw13 = Arrays.mismatch(melons1, melons3, byWeight);
        System.out.println("melons1 mismatch melons3 by weight? " + mmw13);

        // melons1 mismatch melon3 via Comparator by type
        int mmt13 = Arrays.mismatch(melons1, melons3, byType);
        System.out.println("melons1 mismatch melons3 by type? " + mmt13);

        // melons1 mismatch melon3 in range via Comparator by type
        int mmrt13 = Arrays.mismatch(melons1, 1, 2, melons3, 1, 2, byType);
        System.out.println("melons1 mismatch melons3 by type between indexes 1-2? " + mmrt13);
    }

}
