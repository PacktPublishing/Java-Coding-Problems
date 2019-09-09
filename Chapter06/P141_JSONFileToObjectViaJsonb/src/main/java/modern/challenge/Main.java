package modern.challenge;

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
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        Jsonb jsonb = JsonbBuilder.create();
        Path pathArray = Paths.get("melons_array.json");
        Path pathMap = Paths.get("melons_map.json");
        Path pathRaw = Paths.get("melons_raw.json");

        System.out.println("Read 'melons_array.json' as array of melons");
        Melon[] melonsArray = jsonb.fromJson(
                Files.newBufferedReader(pathArray, StandardCharsets.UTF_8), Melon[].class);
        System.out.println("Melon array content: " + Arrays.toString(melonsArray));

        System.out.println("Read 'melons_array.json' as List of melons");
        List<Melon> melonsList = jsonb.fromJson(Files.newBufferedReader(
                pathArray, StandardCharsets.UTF_8), ArrayList.class);
        // or, as Type: new ArrayList<Melon>() {}.getClass().getGenericSuperclass()
        System.out.println("Melon list content: " + melonsList);

        System.out.println("Read 'melons_map.json' as Map of melons");
        Map<String, Melon> melonsMap = jsonb.fromJson(Files.newBufferedReader(
                pathMap, StandardCharsets.UTF_8), HashMap.class);
        // or, as Type: new HashMap<String, Melon>() {}.getClass().getGenericSuperclass()
        System.out.println("Melon list content: " + melonsMap);

        System.out.println("Read 'melons_raw.json' line by line into a map");
        Map<String, String> stringMap = new HashMap<>();
        try (BufferedReader br = Files.newBufferedReader(pathRaw, StandardCharsets.UTF_8)) {

            String line;
            while ((line = br.readLine()) != null) {
                stringMap = jsonb.fromJson(line, HashMap.class);
                System.out.println("Current map is: " + stringMap);
            }
        }

        System.out.println("Read 'melons_raw.json' line by line into a Melon");
        try (BufferedReader br = Files.newBufferedReader(pathRaw, StandardCharsets.UTF_8)) {

            String line;
            while ((line = br.readLine()) != null) {
                Melon melon = jsonb.fromJson(line, Melon.class);
                System.out.println("Current melon is: " + melon);
            }
        }

        System.out.println("Writing an Object to a JSON file ('melons_output.json') ...");
        Path path = Paths.get("melons_output.json");
        jsonb.toJson(melonsMap, Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE));
    }
}
