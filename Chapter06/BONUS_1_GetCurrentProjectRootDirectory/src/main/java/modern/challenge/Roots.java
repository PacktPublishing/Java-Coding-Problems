package modern.challenge;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Roots {

    private Roots() {
        throw new AssertionError("Cannot be instantiatied");
    }

    public static String getCurrentProjectRootDirectory() {

        String userDirectory = System.getProperty("user.dir");
        Path rootDirectory = Paths.get(".").normalize().toAbsolutePath();

        if (rootDirectory.startsWith(userDirectory)) {
            return rootDirectory.toString();
        } else {
            throw new RuntimeException("Cannot find the current project root directory");
        }
    }
}
