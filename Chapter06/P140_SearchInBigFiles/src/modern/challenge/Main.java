package modern.challenge;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Clock;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException {

        Clock clock = Clock.systemUTC();
        Path storyFile = Paths.get("story.txt");
        String search = "remarkable";                
        
        long startTimeV1 = clock.millis();
        long countV1 = TextFiles.countOccurrencesV1(storyFile, search, StandardCharsets.UTF_8);
        displayExecutionTime(clock.millis() - startTimeV1);
        System.out.println("V1: '" + search + "' was found " + countV1 + " times\n");
        
        long startTimeV2 = clock.millis();
        long countV2 = TextFiles.countOccurrencesV2(storyFile, search, StandardCharsets.UTF_8);
        displayExecutionTime(clock.millis() - startTimeV2);
        System.out.println("V2: '" + search + "' was found " + countV2 + " times\n");
      
        long startTimeV3 = clock.millis();
        long countV3 = TextFiles.countOccurrencesV3(storyFile, search, StandardCharsets.UTF_8);
        displayExecutionTime(clock.millis() - startTimeV3);
        System.out.println("V3: '" + search + "' was found " + countV3 + " times\n");
    
        long startTimeV4 = clock.millis();
        long countV4 = TextFiles.countOccurrencesV4(storyFile, search, StandardCharsets.UTF_8);
        displayExecutionTime(clock.millis() - startTimeV4);
        System.out.println("V4: '" + search + "' was found " + countV4 + " times\n");        
        
        long startTimeV5 = clock.millis();
        long countV5 = TextFiles.countOccurrencesV5(storyFile, search);
        displayExecutionTime(clock.millis() - startTimeV5);
        System.out.println("V5: '" + search + "' was found " + countV5 + " times");        
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ms" + " ("
                + TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS) + " s)");
    }

}
