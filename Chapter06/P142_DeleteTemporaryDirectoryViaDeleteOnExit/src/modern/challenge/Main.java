package modern.challenge;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        Path customBaseDir = FileSystems.getDefault().getPath("D:/tmp");
        String customDirPrefix = "logs_";
        String customFilePrefix = "log_";
        String customFileSuffix = ".txt";

        try {
            Path tmpDir = Files.createTempDirectory(customBaseDir, customDirPrefix);
            System.out.println("Created temp folder as: " + tmpDir);           
            
            Path tmpFile1 = Files.createTempFile(
                tmpDir, customFilePrefix, customFileSuffix);
            Path tmpFile2 = Files.createTempFile(
                tmpDir, customFilePrefix, customFileSuffix);            
            System.out.println("Created temp file as: " + tmpFile1);           
            System.out.println("Created temp file as: " + tmpFile2);           
            
            System.out.println("Sleep for 10 seconds until deletion ...");
            
            try (DirectoryStream<Path> ds = Files.newDirectoryStream(tmpDir)) {
                // EACH ENTRY SHOULD BE REGISTERED FOR DELETE ON EXIT
                // DELETION TAKE PLACE IN REVERSE ORDER OF REGISTRATION
                tmpDir.toFile().deleteOnExit();
                
                for (Path file : ds) {                  
                    file.toFile().deleteOnExit();
                }                

            } catch (IOException e) {
                // handle exception, don't print it as below
                System.err.println(e);
            }

            // simulate some operations with temp file until delete it                        
            Thread.sleep(10000);
            System.out.println("Delete folder completed ...");

        } catch (IOException | InterruptedException e) {
            // handle exception, don't print it as below
            System.err.println(e);
        }
    }

}

