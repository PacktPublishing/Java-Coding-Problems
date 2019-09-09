package modern.challenge;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class Main {
   
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
        Path pathArray = Paths.get("melons_array.json");
        Path pathMap = Paths.get("melons_map.json");
        Path pathRaw = Paths.get("melons_raw.json");

        System.out.println("Read 'melons_array.json' as array of melons");
        Melon[] melonsArray = gson.fromJson(
                Files.newBufferedReader(pathArray, StandardCharsets.UTF_8), Melon[].class);
        System.out.println("Melon array content: " + Arrays.toString(melonsArray));

        System.out.println("Read 'melons_array.json' as List of melons");
        List<Melon> melonsList = gson.fromJson(Files.newBufferedReader(
                pathArray, StandardCharsets.UTF_8), ArrayList.class);
        // or, as TypeTolen, new TypeToken<ArrayList<Melon>>() {}.getType()
        System.out.println("Melon list content: " + melonsList);

        System.out.println("Read 'melons_map.json' as Map of melons");
        Map<String, Melon> melonsMap = gson.fromJson(Files.newBufferedReader(
                pathMap, StandardCharsets.UTF_8), HashMap.class);
        // or, as TypeTolen, new TypeToken<HashMap<String, Melon>>() {}.getType()
        System.out.println("Melon list content: " + melonsMap);

        System.out.println("Read 'melons_raw.json' line by line into a map");
        Map<String, String> stringMap = new HashMap<>();
        try (BufferedReader br = Files.newBufferedReader(pathRaw, StandardCharsets.UTF_8)) {

            String line;
            while ((line = br.readLine()) != null) {
                stringMap = gson.fromJson(line, HashMap.class);
                System.out.println("Current map is: " + stringMap);
            }
        }

        System.out.println("Read 'melons_raw.json' line by line into a Melon");
        try (BufferedReader br = Files.newBufferedReader(pathRaw, StandardCharsets.UTF_8)) {

            String line;
            while ((line = br.readLine()) != null) {
                Melon melon = gson.fromJson(line, Melon.class);
                System.out.println("Current melon is: " + melon);
            }
        }
        
        System.out.println("Writing an Object to a JSON file ('melons_output.json') ...");
        Path path = Paths.get("melons_output.json");
        gson.toJson(melonsMap, Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE));
    }
}
