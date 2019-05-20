package modern.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public final class Csvs {

    private Csvs() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static List<List<String>> readAsObject(
            Path path, Charset cs, String delimiter) throws IOException {

        if (path == null || delimiter == null) {
            throw new IllegalArgumentException("Path/delimiter cannot be null");
        }

        cs = Objects.requireNonNullElse(cs, StandardCharsets.UTF_8);

        List<List<String>> content = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(Pattern.quote(delimiter));
                content.add(Arrays.asList(values));
            }
        }

        return content;
    }

    public static List<Melon> readAsMelon(
            Path path, Charset cs, String delimiter) throws IOException {

        if (path == null || delimiter == null) {
            throw new IllegalArgumentException("Path/delimiter cannot be null");
        }

        cs = Objects.requireNonNullElse(cs, StandardCharsets.UTF_8);

        List<Melon> content = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                content.add(new Melon(values[0], Integer.valueOf(values[1])));
            }
        }

        return content;
    }
}
