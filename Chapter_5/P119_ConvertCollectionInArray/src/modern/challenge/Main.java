package modern.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("ana", "mario", "vio");

        Object[] namesArrayAsObjects = names.toArray();
        System.out.println("Converting to Object[]: " + Arrays.toString(namesArrayAsObjects));
        
        String[] namesArraysAsStrings1 = names.toArray(new String[names.size()]);
        System.out.println("Converting to String[], jdk8: " + Arrays.toString(namesArraysAsStrings1));
        
        String[] namesArraysAsStrings2 = names.toArray(new String[0]);
        System.out.println("Converting to String[], jdk8: " + Arrays.toString(namesArraysAsStrings2));
        
        String[] namesArraysAsStrings3 = names.toArray(String[]::new);
        System.out.println("Converting to String[], jdk11: " + Arrays.toString(namesArraysAsStrings3));
        
        String[] namesArray = {"ana", "mario", "vio"};
        List<String> namesArrayAsList = List.of(namesArray);
        Set<String> namesArrayAsSet = Set.of(namesArray);
        System.out.println("Converting array to list via of(): " + namesArrayAsList);
        System.out.println("Converting array to set via of(): " + namesArrayAsSet);              
    }

}
