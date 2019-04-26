package modern.challenge;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String result1Map = Stream.of("hello")
                .map(s -> s + " world")
                .findFirst()
                .get();
        System.out.println(result1Map);

        String result1 = "hello".transform(s -> s + " world");
        System.out.println(result1);

        String result2Map = Stream.of("gooool! ")
                .map(String::toUpperCase)
                .map(s -> s.repeat(2))
                .map(s -> s.replaceAll("O", "OOOO"))
                .findFirst()
                .get();
        System.out.println(result2Map);

        String result2 = "gooool! ".transform(String::toUpperCase)
                .transform(s -> s.repeat(2))
                .transform(s -> s.replaceAll("O", "OOOO"));
        System.out.println(result2);
    }

}
