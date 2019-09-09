package modern.challenge;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        String defaultBaseDir = System.getProperty("java.io.tmpdir");
        System.out.println("Default temporary base dir: " + defaultBaseDir);

        Path customBaseDir = FileSystems.getDefault().getPath("D:/tmp");
        String customDirPrefix = "logs_";
        System.out.println("Custom temporary base dir: " + customBaseDir);

        Path tmpNoPrefix = Files.createTempDirectory(null);
        System.out.println("Created as (default location, no prefix): " + tmpNoPrefix);

        Path tmpCustomPrefix = Files.createTempDirectory(customDirPrefix);
        System.out.println("Created as (default location and custom prefix): " + tmpCustomPrefix);

        Path tmpCustomLocationAndPrefix = Files.createTempDirectory(customBaseDir, customDirPrefix);
        System.out.println("Created as (custom location and prefix): " + tmpCustomLocationAndPrefix);
    }

}
