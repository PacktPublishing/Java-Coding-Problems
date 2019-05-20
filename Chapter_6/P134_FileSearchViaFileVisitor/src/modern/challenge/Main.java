package modern.challenge;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        Path searchFile = Paths.get("JavaModernChallenge.pdf");
        
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor(searchFile);
        EnumSet opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
        for (Path root : roots) {
            if (!searchFileVisitor.isFileFound()) {
                Files.walkFileTree(root, opts, Integer.MAX_VALUE, searchFileVisitor);
            }
        }

        if (!searchFileVisitor.isFileFound()) {
            System.out.println("The file " + searchFile + " was not found!");
        }

    }

}
