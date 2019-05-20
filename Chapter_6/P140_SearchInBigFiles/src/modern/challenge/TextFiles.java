package modern.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class TextFiles {

    private static final int MAP_SIZE = 5242880; // 5 MB in bytes

    private TextFiles() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int countOccurrencesV1(Path path, String text, Charset ch) 
            throws IOException {

        if (path == null || text == null) {
            throw new IllegalArgumentException("Path/text cannot be null");
        }

        if (text.isBlank()) {
            return 0;
        }

        if (ch == null) {
            ch = StandardCharsets.UTF_8;
        }

        int count = 0;
        try (BufferedReader br = Files.newBufferedReader(path, ch)) {

            String line;
            while ((line = br.readLine()) != null) {
                count += countStringInString(line, text);
            }
        }

        return count;
    }

    public static int countOccurrencesV2(Path path, String text, Charset ch) throws IOException {

        if (path == null || text == null) {
            throw new IllegalArgumentException("Path/text cannot be null");
        }

        if (text.isBlank()) {
            return 0;
        }

        if (ch == null) {
            ch = StandardCharsets.UTF_8;
        }

        return Files.readAllLines(path, ch).parallelStream()
                .mapToInt((p) -> countStringInString(p, text))
                .sum();
    }

    public static int countOccurrencesV3(Path path, String text, Charset ch) throws IOException {

        if (path == null || text == null) {
            throw new IllegalArgumentException("Path/text cannot be null");
        }

        if (text.isBlank()) {
            return 0;
        }

        if (ch == null) {
            ch = StandardCharsets.UTF_8;
        }

        return Files.lines(path, ch).parallel()
                .mapToInt((p) -> countStringInString(p, text))
                .sum();
    }

    public static long countOccurrencesV4(Path path, String text, Charset ch) throws IOException {

        if (path == null || text == null) {
            throw new IllegalArgumentException("Path/text cannot be null");
        }

        if (text.isBlank()) {
            return 0;
        }

        if (ch == null) {
            ch = StandardCharsets.UTF_8;
        }

        long count;
        try (Scanner scanner = new Scanner(path, ch)
                .useDelimiter(Pattern.quote(text))) {
            count = scanner.tokens().count() - 1;
        }

        return count;
    }

    public static int countOccurrencesV5(Path path, String text) throws IOException {

        if (path == null || text == null) {
            throw new IllegalArgumentException("Path/text cannot be null");
        }

        if (text.isBlank()) {
            return 0;
        }

        final byte[] texttofind = text.getBytes(StandardCharsets.UTF_8);

        int count = 0;
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {

            int position = 0;
            long length = fileChannel.size();
            while (position < length) {

                long remaining = length - position;
                int bytestomap = (int) Math.min(MAP_SIZE, remaining);
                MappedByteBuffer mbBuffer = fileChannel.map(MapMode.READ_ONLY, position, bytestomap);

                int limit = mbBuffer.limit();
                int lastSpace = -1;
                int firstChar = -1;
                while (mbBuffer.hasRemaining()) {

                    boolean isFirstChar = false;
                    while (firstChar != 0 && mbBuffer.hasRemaining()) {

                        byte currentByte = mbBuffer.get();

                        if (Character.isWhitespace((char) currentByte)) {
                            lastSpace = mbBuffer.position();
                        }

                        if (texttofind[0] == currentByte) {
                            isFirstChar = true;
                            break;
                        }
                    }

                    if (isFirstChar) {

                        boolean isRestOfChars = true;

                        int j;
                        for (j = 1; j < texttofind.length; j++) {
                            if (!mbBuffer.hasRemaining() || texttofind[j] != mbBuffer.get()) {
                                isRestOfChars = false;
                                break;
                            }
                        }

                        if (isRestOfChars) {
                            count++;
                            lastSpace = -1;
                        }

                        firstChar = -1;
                    }
                }

                if (lastSpace > -1) {
                    position = position - (limit - lastSpace);
                }

                position += bytestomap;
            }
        }

        return count;
    }

    private static int countStringInString(String string, String tofind) {

        if (string == null || tofind == null) {
            throw new IllegalArgumentException("The given strings cannot be null");
        }

        if (string.isBlank() || tofind.isBlank()) {
            return 0;
        }

        return string.split(Pattern.quote(tofind), -1).length - 1;
    }
}
