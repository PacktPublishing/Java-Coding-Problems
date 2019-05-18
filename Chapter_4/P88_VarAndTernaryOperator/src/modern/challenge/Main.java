package modern.challenge;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // using explicit types
        boolean containsEven = true;
        Collection evensOrOdds1 = containsEven ? List.of(10, 2, 12) : Set.of(13, 1, 11);
        Object evensOrOdds2 = containsEven ? List.of(10, 2, 12) : Set.of(13, 1, 11);
        System.out.println("Evens or odds 1: " + evensOrOdds1);
        System.out.println("Evens or odds 2: " + evensOrOdds2);

        boolean intOrString = false;
        Serializable numberOrText1 = intOrString ? 2234 : "2234";
        Object numberOrText2 = intOrString ? 2234 : "2234";
        System.out.println("Number or text 1: " + numberOrText1);
        System.out.println("Number or text 2: " + numberOrText2);
        
        var evensOrOddsCollection = containsEven ? List.of(10, 2, 12) : Set.of(13, 1, 11);
        var numberOrText = intOrString ? 2234 : "2234";
        System.out.println("\nEven or odds: " + evensOrOddsCollection);
        System.out.println("Number or text: " + numberOrText);        
    }

}
