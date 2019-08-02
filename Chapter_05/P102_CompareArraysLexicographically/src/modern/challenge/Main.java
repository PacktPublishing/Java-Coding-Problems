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
        Melon[] melons3 = new Melon[]{new Melon("Hami", 1600), new Melon("Gac", 800)};

        // Comparators
        Comparator<Melon> byType = Comparator.comparing(Melon::getType);

        System.out.println("compare:\n-------\n");
        System.out.println("Interpreting return:\n"
                + "  - 0 if the first and second array are equal and contain the same elements in the same order;\n"
                + "  - a value less than 0 if the first array is lexicographically less than the second array;\n"
                + "  - a value greater than 0 if the first array is lexicographically greater than the second array\n");

        int i12 = Arrays.compare(integers1, integers2);
        System.out.println("integers1 compared lexicographically with integers2 returned: " + i12);

        int i13 = Arrays.compare(integers1, integers3);
        System.out.println("integers1 compared lexicographically with integers3 returned: " + i13);

        int is13 = Arrays.compare(integers1, 3, 6, integers3, 3, 6);
        System.out.println("integers1 compared lexicographically with integers3 in range [3,6) returned: " + is13);

        @SuppressWarnings("unchecked")
        int m12 = Arrays.compare(melons1, melons2);
        System.out.println("melons1 compared lexicographically with melons2 returned: " + m12);

        @SuppressWarnings("unchecked")
        int m13 = Arrays.compare(melons1, melons3);
        System.out.println("melons1 compared lexicographically with melons3 returned: " + m13);

        @SuppressWarnings("unchecked")
        int ms13 = Arrays.compare(melons1, 1, 2, melons3, 1, 2);
        System.out.println("melons1 compared lexicographically with melons3 in range [1, 2) returned: " + ms13);

        int mt13 = Arrays.compare(melons1, melons3, byType);
        System.out.println("melons1 compared lexicographically with melons3 by type returned: " + mt13);
        
        int mrt13 = Arrays.compare(melons1, 1, 2, melons3, 1, 2, byType);
        System.out.println("melons1 compared lexicographically with melons3 by type in range [1,2) returned: " + mrt13);
    }

}
