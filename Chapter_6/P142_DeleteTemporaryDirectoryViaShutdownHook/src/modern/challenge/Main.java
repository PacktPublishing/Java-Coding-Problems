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

            Runtime.getRuntime().addShutdownHook(new Thread() {

                @Override
                public void run() {
                    System.out.println("Deleting the temporary folder ...");
                    try (DirectoryStream<Path> ds = Files.newDirectoryStream(tmpDir)) {
                        for (Path file : ds) {
                            Files.delete(file);
                        }

                        Files.delete(tmpDir);

                    } catch (IOException e) {
                        // handle exception, don't print it as below
                        System.err.println(e);
                    }
                    System.out.println("Shutdown-hook completed...");
                    System.out.println("Delete file completed ...");
                }
            });

            //simulate some operations with temp file until delete it            
            Thread.sleep(10000);

        } catch (IOException | InterruptedException e) {
            // handle exceptions, don't print it as below
            System.err.println(e);
        }
    }

}
