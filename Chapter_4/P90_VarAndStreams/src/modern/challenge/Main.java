package modern.challenge;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        // explicit type
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        numbers.filter(t -> t % 2 == 0).forEach(System.out::println);

        // using var
        var numberStream = Stream.of(1, 2, 3, 4, 5); // inferred as Stream<Integer>               
        numberStream.filter(t -> t % 2 == 0).forEach(System.out::println);

        // explicit types
        Stream<String> paths = Files.lines(Path.of("dummy.txt"));
        List<File> files = paths.map(p -> new File(p)).collect(toList());

        // using var 
        var pathStream = Files.lines(Path.of("dummy.txt")); // inferred as Stream<String>
        var fileList = pathStream.map(p -> new File(p)).collect(toList()); // inferred as List<File>
    }

}
