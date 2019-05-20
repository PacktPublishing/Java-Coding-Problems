package modern.challenge;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

class PathVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException ioe) throws IOException {

        if (ioe != null) {            
            throw ioe;
        }

        System.out.println("Visited directory: " + dir);

        return FileVisitResult.CONTINUE;
    }   
}
