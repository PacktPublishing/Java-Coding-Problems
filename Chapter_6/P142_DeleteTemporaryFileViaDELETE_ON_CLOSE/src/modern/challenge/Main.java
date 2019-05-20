package modern.challenge;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) {

        Path customBaseDir = FileSystems.getDefault().getPath("D:/tmp");
        String customFilePrefix = "log_";
        String customFileSuffix = ".txt";

        Path tmpFile = null;

        try {
            tmpFile = Files.createTempFile(
                    customBaseDir, customFilePrefix, customFileSuffix);
            System.out.println("Created as: " + tmpFile);
        } catch (IOException e) {
            // handle exception, don't print it as below
            System.err.println(e);
        }

        try ( BufferedWriter bw = Files.newBufferedWriter(
                tmpFile, StandardCharsets.UTF_8, StandardOpenOption.DELETE_ON_CLOSE)) {
            System.out.println("Sleep for 10 seconds until deletion ...");

            //simulate some operations with temp file until delete it            
            Thread.sleep(10000);
        } catch (IOException | InterruptedException e) {
            // handle exception, don't print it as below
            System.err.println(e);
        }

        System.out.println("Delete file completed ...");

    }

}
