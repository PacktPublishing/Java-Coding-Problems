package modern.challenge;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        System.out.println("Infinite streams via Stream.iterate()");
        System.out.println("-------------------------------------");

        Stream<Integer> infStream1 = Stream.iterate(1, i -> i + 1);

        List<Integer> result1 = infStream1
                .filter(i -> i % 2 == 0)
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("\nList of the first 10 even integers: " + result1);

        Stream<Integer> infStream2 = Stream.iterate(1, i -> i <= 10, i -> i + 1);

        List<Integer> result2 = infStream2
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("\nList of even integers till 10: " + result2);

        System.out.println("\nInfinite streams via Random.ints()");
        System.out.println("----------------------------------");

        IntStream rndInfStream1 = new Random().ints(1, 100); // longs(), doubles()

        List<Integer> result3 = rndInfStream1
                .filter(i -> i % 2 == 0)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("\nList of 10 even integers: " + result3);

        IntStream rndInfStream2 = new Random().ints(10, 1, 100); // longs(), doubles()

        List<Integer> result4 = rndInfStream2
                .filter(i -> i % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("\nList of even integers from 10 randoms: " + result4);
        
        IntStream rndInfStream3 = new Random().ints(20, 48, 126);

        String result5 = rndInfStream3               
                .mapToObj(n -> String.valueOf((char) n))
                .collect(Collectors.joining());

        System.out.println("\nRandom string of 20 characters: " + result5);

        System.out.println("\nInfinite streams via Stream.generate()");
        System.out.println("----------------------------------");

        Supplier<String> passwordSupplier = Main::randomPassword;
        Stream<String> passwordStream = Stream.generate(passwordSupplier);

        List<String> result6 = passwordStream
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("\nList of 10 passwords: " + result6);

        System.out.println("\nInfinite streams via Stream.takeWhile()");
        System.out.println("---------------------------------------");

        List<Integer> result7 = IntStream
                .iterate(1, i -> i + 1)
                .takeWhile(i -> i <= 10)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("\nList of 10 ordered integers: " + result7);

        List<Integer> result8 = new Random().ints(1, 100)
                .filter(i -> i % 2 == 0)
                .takeWhile(i -> i >= 50)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("\nList of random even integers until "
                + "the first generated value is less than 50: " + result8);

        List<String> result9 = Stream.generate(Main::randomPassword)
                .takeWhile(s -> s.contains("!"))
                .collect(Collectors.toList());

        System.out.println("\nList of random password until first password without '!': " + result9);

        Set<Integer> setOfInts1 = new HashSet<>(Arrays.asList(
                1, 4, 3, 52, 9, 40, 5, 2, 31, 8));
        List<Integer> result10 = setOfInts1.stream()
                .takeWhile(i -> i <= 10)
                .collect(Collectors.toList());

        System.out.println("\nTake a nondeterministic subset of elements <=10 : " + result10);

        System.out.println("\nInfinite streams via Stream.dropWhile()");
        System.out.println("---------------------------------------");

        List<Integer> result11 = IntStream
                .iterate(1, i -> i + 1)
                .dropWhile(i -> i <= 10)
                .limit(5)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("\nList of 5 ordered integers (drop those less than 10): " + result11);

        List<Integer> result12 = new Random().ints(1, 100)
                .filter(i -> i % 2 == 0)
                .dropWhile(i -> i < 50)
                .limit(5)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("\nList of 5 random even integers greater than 50 "
                + "(at least, this is what we may think): " + result12);

        List<String> result13 = Stream.generate(Main::randomPassword)
                .dropWhile(s -> !s.contains("!"))
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("\nList of 5 random passwords containing '!' "
                + "(at least, this is what we may think): " + result13);

        Set<Integer> setOfInts2 = new HashSet<>(Arrays.asList(
                5, 42, 3, 2, 11, 1, 6, 55, 9, 7));
        List<Integer> result14 = setOfInts2.stream()
                .dropWhile(i -> i <= 10)
                .collect(Collectors.toList());

        System.out.println("\nDrop a nondeterministic subset of elements <=10 "
                + "and return the rest: " + result14);
    }

    private static String randomPassword() {
        String chars = "abcd0123!@#$";

        return new SecureRandom().ints(8, 0, chars.length())
                .mapToObj(i -> String.valueOf(chars.charAt(i)))
                .collect(Collectors.joining());
    }
}
