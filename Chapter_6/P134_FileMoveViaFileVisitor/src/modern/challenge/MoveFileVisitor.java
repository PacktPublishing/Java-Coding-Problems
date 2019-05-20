package modern.challenge;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Objects;

public class MoveFileVisitor implements FileVisitor {

    private final Path moveFrom;
    private final Path moveTo;
    private static FileTime time;

    public MoveFileVisitor(Path moveFrom, Path moveTo) {
        this.moveFrom = Objects.requireNonNull(moveFrom, "The location to move from cannot be null");
        this.moveTo = Objects.requireNonNull(moveTo, "The location to move to cannot be null");
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException ioe) throws IOException {
                
        Path newDir = moveTo.resolve(moveFrom.relativize((Path) dir));
        try {
            Files.setLastModifiedTime(newDir, time);
            Files.delete((Path) dir);
        } catch (IOException e) {
            System.err.println("Unable to copy all attributes to: " + newDir + " [" + e + "]");
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        
        System.out.println("Move directory: " + (Path) dir);
        
        Path newDir = moveTo.resolve(moveFrom.relativize((Path) dir));
        try {
            Files.copy((Path) dir, newDir, REPLACE_EXISTING, COPY_ATTRIBUTES);
            time = Files.getLastModifiedTime((Path) dir);
        } catch (IOException e) {
            System.err.println("Unable to move " + newDir + " [" + e + "]");
            
            return FileVisitResult.SKIP_SUBTREE;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        
        System.out.println("Move file: " + (Path) file);

        try {
            moveSubTree((Path) file, moveTo.resolve(moveFrom.relativize((Path) file)));
        } catch (IOException e) {
            System.err.println("Unable to move " + moveFrom + " [" + e + "]");
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException ioe) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    private static void moveSubTree(Path moveFrom, Path moveTo) throws IOException {
        Files.move(moveFrom, moveTo, REPLACE_EXISTING, ATOMIC_MOVE);
    }
}
