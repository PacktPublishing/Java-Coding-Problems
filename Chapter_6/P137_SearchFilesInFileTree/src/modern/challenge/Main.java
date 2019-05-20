package modern.challenge;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Path startPath = Paths.get("D:/learning");

        System.out.println("Find all files ending with the '.properties' extension and following symbolic links: ");
        Stream<Path> resultAsStream1
                = Files.find(
                        startPath,
                        Integer.MAX_VALUE,
                        (path, attr) -> path.toString().endsWith(".properties"),
                        FileVisitOption.FOLLOW_LINKS
                );

        resultAsStream1.forEach(System.out::println);

        System.out.println("\n\nFind all regular files whose names start with 'application': ");
        Stream<Path> resultAsStream2
                = Files.find(
                        startPath,
                        Integer.MAX_VALUE,
                        (path, attr) -> attr.isRegularFile()
                        && path.getFileName().toString().startsWith("application")
                );

        resultAsStream2.forEach(System.out::println);

        System.out.println("\n\nFind all directories created after 16 March 2019: ");
        Stream<Path> resultAsStream3
                = Files.find(
                        startPath,
                        Integer.MAX_VALUE,
                        (path, attr) -> attr.isDirectory()
                        && attr.creationTime().toInstant().
                                isAfter(LocalDate.of(2019, 3, 16).atStartOfDay().
                                        toInstant(ZoneOffset.UTC))
                );

        resultAsStream3.forEach(System.out::println);

        System.out.println("\n\nFind all Java files: ");
        Stream<Path> resultAsStream4 = fetchFilesMatching(startPath, "glob:**/*.java");

        resultAsStream4.forEach(System.out::println);
    }

    private static Stream<Path> fetchFilesMatching(Path root, String syntaxPattern)
            throws IOException {

        final PathMatcher matcher = root.getFileSystem().getPathMatcher(syntaxPattern);

        return Files.find(
                root, Integer.MAX_VALUE, (path, attr)
                -> matcher.matches(path) && !attr.isDirectory()
        );
    }
}
