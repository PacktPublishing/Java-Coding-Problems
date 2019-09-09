package modern.challenge;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class SearchFileVisitor implements FileVisitor {

    private final Path fileNameToSearch;
    private boolean fileFound;

    public SearchFileVisitor(Path fileNameToSearch) {
        this.fileNameToSearch = Objects.requireNonNull(fileNameToSearch,
                "The file to search cannot be null");
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException ioe) throws IOException {
        
        if(ioe != null) {
            throw ioe;
        }
        
        System.out.println("Visited: " + (Path) dir);

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {

        fileFound = search((Path) file);

        if (!fileFound) {
            return FileVisitResult.CONTINUE;
        } else {
            return FileVisitResult.TERMINATE;
        }
    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException ioe) throws IOException {                       
        return FileVisitResult.CONTINUE;
    }

    public boolean isFileFound() {
        return fileFound;
    }

    private boolean search(Path file) throws IOException {

        Path fileName = file.getFileName();
        if (fileNameToSearch.equals(fileName)) {
            System.out.println("Searched file was found: "
                    + fileNameToSearch + " in " + file.toRealPath().toString());
            return true;
        }

        return false;
    }

}
