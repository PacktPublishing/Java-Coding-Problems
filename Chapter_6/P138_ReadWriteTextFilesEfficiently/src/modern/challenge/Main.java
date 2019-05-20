package modern.challenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Path chineseFile = Paths.get("chinese.txt");

        System.out.println("File to read: " + chineseFile.toString());
        System.out.println("Default charset: " + Charset.defaultCharset() + "\n\n");

        System.out.println("Read text file via InputStream:");
        System.out.println("------------------------------------------------");
        try ( InputStream is = new FileInputStream(chineseFile.toString())) {
            int i;
            while ((i = is.read()) != -1) {
                System.out.print((char) i);
            }
        }

        System.out.println("\n\nRead text file via InputStreamReader with charset:");
        System.out.println("-------------------------------------------------------");
        try ( InputStreamReader isr = new InputStreamReader(
                new FileInputStream(chineseFile.toFile()), StandardCharsets.UTF_16)) {
            int i;
            while ((i = isr.read()) != -1) {
                System.out.print((char) i);
            }
        }

        System.out.println("\n\nRead text file via FileReader without charset:");
        System.out.println("------------------------------------------------");
        try ( FileReader fr = new FileReader(chineseFile.toFile())) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        }

        System.out.println("\n\nRead text file via FileReader with charset:");
        System.out.println("------------------------------------------------");
        try ( FileReader frch = new FileReader(chineseFile.toFile(), StandardCharsets.UTF_16)) {
            int i;
            while ((i = frch.read()) != -1) {
                System.out.print((char) i);
            }
        }

        System.out.println("\n\nRead text file via BufferedReader with charset:");
        System.out.println("----------------------------------------------------");
        try ( BufferedReader br = new BufferedReader(
                new FileReader(chineseFile.toFile(), StandardCharsets.UTF_16))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        System.out.println("\n\n----------------------------------------------------");
        try ( BufferedReader br = Files.newBufferedReader(chineseFile, StandardCharsets.UTF_16)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        System.out.println("\n\n----------------------------------------------------");
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(chineseFile.toFile()), StandardCharsets.UTF_16))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        System.out.println("\n\nRead text file in memory via Files.readAllLines() with charset:");
        System.out.println("-------------------------------------------------------------------");
        List<String> lines = Files.readAllLines(chineseFile, StandardCharsets.UTF_16);
        lines.forEach(System.out::println);

        System.out.println("\n\nRead text file in memory via Files.readString() with charset:");
        System.out.println("-------------------------------------------------------------------");
        String content = Files.readString(chineseFile, StandardCharsets.UTF_16);
        System.out.println(content);

        System.out.println("\n\nRead text file via MappedByteBuffer:");
        System.out.println("-------------------------------------------------------------------");
        try ( FileChannel fileChannel = (FileChannel.open(chineseFile,
                EnumSet.of(StandardOpenOption.READ)))) {

            MappedByteBuffer mbBuffer = fileChannel.map(
                    FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            if (mbBuffer != null) {
                String bufferContent = StandardCharsets.UTF_16.decode(mbBuffer).toString();
                System.out.println(bufferContent);

                mbBuffer.clear();
            }
        }

        System.out.println("\n\nWrite text file via BufferedWriter with charset");
        System.out.println("----------------------------------------------------");

        Path textFile1 = Paths.get("sample1.txt");
        try ( BufferedWriter bw = Files.newBufferedWriter(
                textFile1, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, ");
            bw.newLine();
            bw.write("sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        }

        System.out.println("\n\nWrite text file via Files.write() with charset");
        System.out.println("----------------------------------------------------");
        List<String> linesToWrite = Arrays.asList("abc", "def", "ghi");
        Path textFile2 = Paths.get("sample2.txt");
        Files.write(textFile2, linesToWrite, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        System.out.println("\n\nWrite text file via Files.writeString() with charset");
        System.out.println("--------------------------------------------------------");
        Path textFile3 = Paths.get("sample3.txt");
        String lineToWrite = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, ...";
        Files.writeString(textFile3, lineToWrite, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        System.out.println("\n\nWrite text file via MappedByteBuffer with charset");
        System.out.println("-----------------------------------------------------");
        Path textFile4 = Paths.get("sample4.txt");
        CharBuffer cb = CharBuffer
                .wrap("Lorem ipsum dolor sit amet, consectetur adipiscing elit, ...");
        try ( FileChannel fileChannel = (FileChannel) Files
                .newByteChannel(textFile4, EnumSet.of(
                        StandardOpenOption.CREATE,
                        StandardOpenOption.READ,
                        StandardOpenOption.WRITE))) {

            MappedByteBuffer mbBuffer = fileChannel
                    .map(FileChannel.MapMode.READ_WRITE, 0, cb.length());

            if (mbBuffer != null) {
                mbBuffer.put(StandardCharsets.UTF_8.encode(cb));
            }
        }
    }
}
