package modern.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class FileTokenizer {

    private FileTokenizer() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static List<String> getV1(Path path, Charset cs, String delimiter) throws IOException {

        if (path == null || delimiter == null) {
            throw new IllegalArgumentException("Path/delimiter cannot be null");
        }

        cs = Objects.requireNonNullElse(cs, StandardCharsets.UTF_8);

        String delimiterStr = Pattern.quote(delimiter);
        List<String> content = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiterStr);
                content.addAll(Arrays.asList(values));
            }
        }

        return content;
    }

    public static List<String> getWithMultipleDelimitersV1(
            Path path, Charset cs, String... delimiters) throws IOException {

        if (path == null || delimiters == null) {
            throw new IllegalArgumentException("Path/delimiter cannot be null");
        }

        cs = Objects.requireNonNullElse(cs, StandardCharsets.UTF_8);

        String[] escapedDelimiters = new String[delimiters.length];
        Arrays.setAll(escapedDelimiters, t -> Pattern.quote(delimiters[t]));
        String delimiterStr = String.join("|", escapedDelimiters);

        List<String> content = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiterStr);
                content.addAll(Arrays.asList(values));
            }
        }

        return content;
    }

    public static List<String> getV2(Path path, Charset cs, String delimiter) throws IOException {

        if (path == null || delimiter == null) {
            throw new IllegalArgumentException("Path/delimiter cannot be null");
        }

        cs = Objects.requireNonNullElse(cs, StandardCharsets.UTF_8);

        String delimiterStr = Pattern.quote(delimiter);
        List<String> content = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            while ((line = br.readLine()) != null) {
                content.addAll(Stream.of(line.split(delimiterStr))
                        .collect(Collectors.toList()));
            }
        }

        return content;
    }

    public static List<String> getV3(Path path, Charset cs, String delimiter) throws IOException {

        if (path == null || delimiter == null) {
            throw new IllegalArgumentException("Path/delimiter cannot be null");
        }

        cs = Objects.requireNonNullElse(cs, StandardCharsets.UTF_8);

        try (Stream<String> lines = Files.lines(path, cs)) {
            return lines.map(l -> l.split(Pattern.quote(delimiter)))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
        }
    }

    public static List<String> getV4(Path path, Charset cs, String delimiter) throws IOException {

        if (path == null || delimiter == null) {
            throw new IllegalArgumentException("Path/delimiter cannot be null");
        }

        cs = Objects.requireNonNullElse(cs, StandardCharsets.UTF_8);

        Pattern pattern = Pattern.compile(Pattern.quote(delimiter));
        List<String> content = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            while ((line = br.readLine()) != null) {
                content.add(pattern.splitAsStream(line).collect(Collectors.joining(";")));
            }
        }

        return content;
    }

    public static List<String> getV5(Path path, Charset cs, String delimiter) throws IOException {

        if (path == null || delimiter == null) {
            throw new IllegalArgumentException("Path/delimiter cannot be null");
        }

        cs = Objects.requireNonNullElse(cs, StandardCharsets.UTF_8);

        StringTokenizer st;
        List<String> content = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            while ((line = br.readLine()) != null) {
                st = new StringTokenizer(line, delimiter);
                while (st.hasMoreElements()) {
                    content.add(st.nextToken());
                }
            }
        }

        return content;
    }

    public static List<String> getWithMultipleDelimitersV5(
            Path path, Charset cs, String... delimiters) throws IOException {

        if (path == null || delimiters == null) {
            throw new IllegalArgumentException("Path/delimiter cannot be null");
        }

        cs = Objects.requireNonNullElse(cs, StandardCharsets.UTF_8);

        String delimiterStr = String.join("//", delimiters);

        StringTokenizer st;
        List<String> content = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            while ((line = br.readLine()) != null) {
                st = new StringTokenizer(line, delimiterStr);
                while (st.hasMoreElements()) {
                    content.add(st.nextToken());
                }
            }
        }

        return content;
    }

    public static List<String> getV6(Path path, Charset cs, String delimiter) throws IOException {

        if (path == null || delimiter == null) {
            throw new IllegalArgumentException("Path/delimiter cannot be null");
        }

        cs = Objects.requireNonNullElse(cs, StandardCharsets.UTF_8);

        List<String> content = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            while ((line = br.readLine()) != null) {
                content.addAll(Collections.list(new StringTokenizer(line, delimiter)).stream()
                        .map(t -> (String) t)
                        .collect(Collectors.toList()));

            }
        }

        return content;
    }
}
