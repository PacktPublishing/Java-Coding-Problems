package modern.challenge;

import java.nio.file.Path;
import java.util.Random;

public class Printer implements Runnable {

    private final Path filePath;

    public Printer(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try {
            //sleep a random number of seconds for simulating dispaching and printing            
            Thread.sleep(10000 + new Random().nextInt(30000));
            System.out.println("Printing: " + filePath);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.err.println("Exception: " + ex);
        }
    }
}
