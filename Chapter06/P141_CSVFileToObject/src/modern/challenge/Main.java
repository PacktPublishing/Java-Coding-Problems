package modern.challenge;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("melon.csv");                
        
        List<List<String>> resultAsObject = Csvs.readAsObject(path, StandardCharsets.UTF_8, COMMA_DELIMITER);        
        System.out.println("Result as Object: " + resultAsObject);
        
        List<Melon> resultAsMelon = Csvs.readAsMelon(path, StandardCharsets.UTF_8, COMMA_DELIMITER);        
        System.out.println("Result as Melon: " + resultAsMelon);
    }
}
