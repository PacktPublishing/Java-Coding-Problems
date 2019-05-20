package modern.challenge;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        Path customBaseDir = FileSystems.getDefault().getPath("D:/tmp");
        String customFilePrefix = "log_";
        String customFilesuffix = ".txt";

        try {
            final Path tmpFile = Files.createTempFile(
                    customBaseDir, customFilePrefix, customFilesuffix);
            System.out.println("Created as: " + tmpFile);
            System.out.println("Sleep for 10 seconds until deletion ...");

            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    System.out.println("Deleting the temporary file ...");
                    try {
                        Files.delete(tmpFile);
                    } catch (IOException e) {
                        // handle exception, don't print it as below
                        System.err.println(e);
                    }
                    System.out.println("Shutdown hook completed...");
                    System.out.println("Delete file completed...");
                }
            });

            //simulate some operations with temp file until delete it            
            Thread.sleep(10000);            
            
        } catch (IOException | InterruptedException e) {
            System.err.println(e);
        }

    }

}
