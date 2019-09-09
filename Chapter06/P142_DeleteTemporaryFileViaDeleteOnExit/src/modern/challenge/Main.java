package modern.challenge;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        Path customBaseDir = FileSystems.getDefault().getPath("D:/tmp");
        String customFilePrefix = "log_";
        String customFileSuffix = ".txt";

        try {
            Path tmpFile = Files.createTempFile(customBaseDir, customFilePrefix, customFileSuffix);
            System.out.println("Created as: " + tmpFile);
            System.out.println("Sleep for 10 seconds until deletion ...");

            File asFile = tmpFile.toFile();
            asFile.deleteOnExit();

            // simulate some operations with temp file until delete it                        
            Thread.sleep(10000);            

        } catch (IOException | InterruptedException e) {
            // handle exception, don't print it as below
            System.err.println(e);
        }
        
        System.out.println("Delete file completed ...");
    }

}
