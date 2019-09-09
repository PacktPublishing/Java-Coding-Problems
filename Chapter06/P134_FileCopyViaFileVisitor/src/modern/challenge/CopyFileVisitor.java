package modern.challenge;

import java.io.IOException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Objects;

public class CopyFileVisitor implements FileVisitor {

    private final Path copyFrom;
    private final Path copyTo;

    public CopyFileVisitor(Path copyFrom, Path copyTo) {
        this.copyFrom = Objects.requireNonNull(copyFrom, "The location to copy from cannot be null");
        this.copyTo = Objects.requireNonNull(copyTo, "The location to copy to cannot be null");
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException ioe) throws IOException {
        
        Path newDir = copyTo.resolve(copyFrom.relativize((Path) dir));
        try {
            FileTime time = Files.getLastModifiedTime((Path) dir);
            Files.setLastModifiedTime(newDir, time);
        } catch (IOException e) {
            System.err.println("Unable to preserve the time attribute to: " + newDir + " [" + e + "]");
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {

        System.out.println("Copy directory: " + (Path) dir);

        Path newDir = copyTo.resolve(copyFrom.relativize((Path) dir));
        try {
            Files.copy((Path) dir, newDir, REPLACE_EXISTING, COPY_ATTRIBUTES);
        } catch (IOException e) {
            System.err.println("Unable to create " + newDir + " [" + e + "]");

            return FileVisitResult.SKIP_SUBTREE;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {

        System.out.println("Copy file: " + (Path) file);

        try {
            copySubTree((Path) file, copyTo.resolve(copyFrom.relativize((Path) file)));
        } catch (IOException e) {
            System.err.println("Unable to copy " + copyFrom + " [" + e + "]");
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException ioe) throws IOException {

        if (ioe instanceof FileSystemLoopException) {
            System.err.println("Cycle was detected: " + (Path) file);
        } else {
            System.err.println("Error occured, unable to copy:" + (Path) file + " [" + ioe + "]");
        }

        return FileVisitResult.CONTINUE;
    }

    private static void copySubTree(Path copyFrom, Path copyTo) throws IOException {
        Files.copy(copyFrom, copyTo, REPLACE_EXISTING, COPY_ATTRIBUTES);
    }

}
