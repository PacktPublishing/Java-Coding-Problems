package modern.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        List<String> melons = Arrays.asList("Gac", "Cantaloupe", "Hemi",
                "Gac", "Gac", "Hemi", "Cantaloupe", "Horned", "Hemi", "Hemi");

        Optional<String> anyMelon = melons.stream()                
                .findAny();

        if (!anyMelon.isEmpty()) {
            System.out.println("Any melon: " + anyMelon.get());
        } else {
            System.out.println("No melon was found");
        }
        
        String anyApollo = melons.stream()
                .filter(m -> m.equals("Apollo"))
                .findAny()
                .orElse("nope");
        System.out.println("Any Apollo? " + anyApollo);

        Optional<String> firstMelon = melons.stream()
                .findFirst();

        if (!firstMelon.isEmpty()) {
            System.out.println("First melon: " + firstMelon.get());
        } else {
            System.out.println("No melon was found");
        }        

        String firstApollo = melons.stream()
                .filter(m -> m.equals("Apollo"))
                .findFirst()
                .orElse("nope");
        System.out.println("First Apollo? " + firstApollo);

        List<Integer> ints = Arrays.asList(4, 8, 4, 5, 5, 7);

        int result = ints.stream()
                .map(x -> x * x - 1)     // 23, 63, 23, 24, 24, 48
                .filter(x -> x % 2 == 0) // 24, 24, 48
                .findFirst()             // 24
                .orElse(-1);

        System.out.println("Result: " + result);
    }

}
