package modern.challenge;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Path directory = Paths.get("D:/learning");
        
        Stream<Path> streamOfPath = Files.walk(directory, FileVisitOption.FOLLOW_LINKS);

        streamOfPath.filter(e -> e.startsWith("D:/learning/books/cdi"))
                .forEach(System.out::println);
    }
}
