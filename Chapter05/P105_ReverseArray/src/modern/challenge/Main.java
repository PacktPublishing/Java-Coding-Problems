package modern.challenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        int[] integers = {-1, 2, 3, 1, 4, 5, 3, 2, 22};
        Melon[] melons = new Melon[]{
            new Melon("Crenshaw", 2000), new Melon("Gac", 1200), new Melon("Bitter", 2200)};

        int[] cloneIntegers = integers.clone();
        ReverseArrays.reverse(cloneIntegers);
        System.out.println("Reversed: " + Arrays.toString(cloneIntegers));

        int[] reversedInt = IntStream.rangeClosed(1, integers.length)
                .map(i -> integers[integers.length - i]).toArray();
        System.out.println("Reversed: " + Arrays.toString(reversedInt));

        Melon[] cloneMelons1 = melons.clone();
        ReverseArrays.reverse(cloneMelons1);
        System.out.println("Reversed: " + Arrays.toString(cloneMelons1));

        Melon[] cloneMelons2 = melons.clone();
        Collections.reverse(Arrays.asList(cloneMelons2));
        System.out.println("Reversed: " + Arrays.toString(cloneMelons2));

        Melon[] reversedMelon = IntStream.rangeClosed(1, melons.length)
                .mapToObj(i -> melons[melons.length - i])                
                .toArray(Melon[]::new);

        System.out.println("Reversed: " + Arrays.toString(reversedMelon));
    }

}
