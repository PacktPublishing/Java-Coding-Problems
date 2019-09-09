package modern.challenge;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class Main {

    public static void main(String[] args) throws IOException {

        Path binaryFile = Paths.get("build/classes/modern/challenge/Main.class");
        int fileSize = (int) Files.readAttributes(binaryFile, BasicFileAttributes.class).size();

        System.out.println("File to read: " + binaryFile.toString());
        System.out.println("File size: " + fileSize + " bytes");
        System.out.println("Default charset: " + Charset.defaultCharset() + "\n\n");

        final byte[] buffer = new byte[fileSize];

        System.out.println("Read binary file via InputStream and a buffer:");
        System.out.println("----------------------------------------------");
        try (InputStream is = new FileInputStream(binaryFile.toString())) {
            int i;
            while ((i = is.read(buffer)) != -1) {
                System.out.println("\nRead: " + i + " bytes");
            }
        }
        System.out.print("Done");

        System.out.println("\n\nRead binary file via BufferedInputStream and a buffer:");
        System.out.println("----------------------------------------------------------");
        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(binaryFile.toFile()))) {
            int i;
            while ((i = bis.read(buffer)) != -1) {
                System.out.println("\nRead: " + i + " bytes");
            }
        }
        System.out.print("Done");

        System.out.println("\n\n-------------------------------------------------------");
        try (BufferedInputStream bis = new BufferedInputStream(
                Files.newInputStream(binaryFile))) {
            int i;
            while ((i = bis.read(buffer)) != -1) {
                System.out.println("\nRead: " + i + " bytes");
            }
        }
        System.out.print("Done");

        System.out.println("\n\nRead binary file via ByteArrayInputStream and a buffer:");
        System.out.println("-----------------------------------------------------------");
        try (ByteArrayInputStream bais = new ByteArrayInputStream(buffer)) {
            int i;
            while ((i = bais.read(buffer)) != -1) {
                System.out.println("\nRead: " + i + " bytes");
            }
        }
        System.out.print("Done");

        System.out.println("\n\nRead binary file of floats via DataInputStream:");
        System.out.println("---------------------------------------------------\n");
        Path dataFile = Paths.get("data.bin");
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(
                Files.newInputStream(dataFile)))) {
            while (dis.available() > 0) {
                float nr = dis.readFloat();
                System.out.println("Read: " + nr);
            }
        }

        System.out.println("\n\nRead binary file in memory via Files.readAllBytes():");
        System.out.println("--------------------------------------------------------");
        byte[] bytes = Files.readAllBytes(binaryFile);
        System.out.println("\nRead " + bytes.length + " bytes");

        System.out.println("\n\nRead binary file via MappedByteBuffer:");
        System.out.println("--------------------------------------------------------");
        try (FileChannel fileChannel = (FileChannel.open(binaryFile,
                EnumSet.of(StandardOpenOption.READ)))) {

            MappedByteBuffer mbBuffer = fileChannel.map(
                    FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            System.out.println("\nRead: " + mbBuffer.limit() + " bytes");
        }

        System.out.println("\n\nWrite binary file via BufferedOutputStream");
        System.out.println("----------------------------------------------");

        Path classFile1 = Paths.get("Main1.class");
        try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(
                classFile1, StandardOpenOption.CREATE, StandardOpenOption.WRITE))) {
            bos.write(buffer);
        }

        System.out.println("\n\nWrite binary file via Files.write()");
        System.out.println("---------------------------------------");
        Path classFile2 = Paths.get("Main2.class");
        Files.write(classFile2, buffer, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        System.out.println("\n\nWrite binary file via MappedByteBuffer");
        System.out.println("---------------------------------------");
        Path classFile3 = Paths.get("Main3.class");
        try (FileChannel fileChannel = (FileChannel) Files
                .newByteChannel(classFile3, EnumSet.of(
                        StandardOpenOption.CREATE,
                        StandardOpenOption.READ,
                        StandardOpenOption.WRITE))) {

            MappedByteBuffer mbBuffer = fileChannel
                    .map(FileChannel.MapMode.READ_WRITE, 0, buffer.length);

            if (mbBuffer != null) {
                mbBuffer.put(buffer);
            }
        }

        System.out.println("\n\nWrite binary file via DataOutputStream");
        System.out.println("------------------------------------------");
        Path floatFile = Paths.get("float.bin");
        try (DataOutputStream dis = new DataOutputStream(new BufferedOutputStream(
                Files.newOutputStream(floatFile)))) {
            dis.writeFloat(23.56f);
            dis.writeFloat(2.516f);
            dis.writeFloat(56.123f);
        }
    }
}
