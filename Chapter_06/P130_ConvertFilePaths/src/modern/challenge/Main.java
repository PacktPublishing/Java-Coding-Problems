package modern.challenge;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/learning/packt", "JavaModernChallenge.pdf");

        String pathToString = path.toString();
        System.out.println("Path to String: " + pathToString);

        URI pathToURI = path.toUri();
        System.out.println("Path to URI: " + pathToURI);

        Path pathToAbsolutePath = path.toAbsolutePath();
        System.out.println("Path to absolute path: " + pathToAbsolutePath);

        Path path2 = Paths.get("/learning/books/../PACKT/./", "JavaModernChallenge.pdf");
        Path realPath = path2.toRealPath(LinkOption.NOFOLLOW_LINKS);
        System.out.println("Path to 'real' path: " + realPath);

        File pathToFile = path.toFile();
        Path fileToPath = pathToFile.toPath();
        System.out.println("Path to file name: " + pathToFile.getName());
        System.out.println("File to path: " + fileToPath);
    }

}
