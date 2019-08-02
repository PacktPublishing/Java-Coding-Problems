package modern.challenge;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        String str = "Character Information 字 Development and Maintenance "
                + "Project 盤 for e-Government MojiJoho-Kiban 事 Project";
                
        Spliterator<Character> spliterator = new IdeographicSpliterator(str);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        
        // force spliterator to do its job
        stream.collect(Collectors.toList());
                
        System.out.println("\n---------------------------------------------\n");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Spliterator<Integer> s1 = numbers.spliterator();

        s1.tryAdvance(e -> System.out.println("Advancing to the first element of s1: " + e));

        System.out.println("\nEstimated size of s1: " + s1.estimateSize());

        Spliterator<Integer> s2 = s1.trySplit();

        System.out.println("\nSplitting s1 ...");
        System.out.println("Estimated size s1: " + s1.estimateSize());
        System.out.println("Estimated size s2: " + s2.estimateSize());

        System.out.println("\nPrint remaining elements of s1:");
        s1.forEachRemaining(System.out::println);
        System.out.println("\nPrint remaining elements of s2:");
        s2.forEachRemaining(System.out::println);

        System.out.println("\nCharacteristics:");
        System.out.println(s1.characteristics());
        System.out.println(s2.characteristics());

        System.out.println("\nCheck that s1 is ordered:");
        if (s1.hasCharacteristics(Spliterator.ORDERED)) {
            System.out.println("ORDERED");
        }

        System.out.println("\nCheck that s1 is sized:");
        if (s1.hasCharacteristics(Spliterator.SIZED)) {
            System.out.println("SIZED");
        }         
    }
    
}
