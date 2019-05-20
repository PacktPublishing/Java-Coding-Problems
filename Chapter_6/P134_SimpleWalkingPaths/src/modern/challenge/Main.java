package modern.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        Path path = Paths.get("D:/learning");        
        
        PathVisitor visitor = new PathVisitor();
        Files.walkFileTree(path, visitor);                
    }
    
}
