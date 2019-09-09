package modern.challenge;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        Path directory = Paths.get("C:/learning");
        DeleteFileVisitor deleteFileVisitor = new DeleteFileVisitor();
        EnumSet opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        Files.walkFileTree(directory, opts, Integer.MAX_VALUE, deleteFileVisitor);
    }

}
