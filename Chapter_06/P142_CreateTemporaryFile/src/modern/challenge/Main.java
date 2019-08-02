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
        String customFilePrefix = "log_";
        String customFileSuffix = ".txt";
        System.out.println("Custom temporary base dir: " + customBaseDir);
        
        Path tmpNoPrefixSuffix = Files.createTempFile(null, null);
        System.out.println("Created as (default location, no prefix and suffix): " + tmpNoPrefixSuffix);
        
        Path tmpCustomPrefixAndSuffix = Files.createTempFile(customFilePrefix, customFileSuffix);
        System.out.println("Created as (default location, custom prefix and suffix): " + tmpCustomPrefixAndSuffix);
        
        Path tmpCustomLocationPrefixSuffix = Files.createTempFile(
                customBaseDir, customFilePrefix, customFileSuffix);
        System.out.println("Created as (custom location, prefix and suffix): " + tmpCustomLocationPrefixSuffix);
    }

}
