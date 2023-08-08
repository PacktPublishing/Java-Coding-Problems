package modern.challenge;
 
import java.nio.MappedByteBuffer;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@OutputTimeUnit(TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, warmups = 1) //, jvmArgsPrepend = {"-Djdk.net.usePlainSocketImpl=true"})
@Measurement(iterations = 1, time = 1)
@State(Scope.Benchmark)
public class Main {

    private static final Path COPY_FROM = Paths.get("rafa_org/Rafa Best Shots.mp4");
    private static final Path COPY_TO = Paths.get("rafa_copy/");
    private static final int BUFFER_SIZE_KB = 4;
    private static final int BUFFER_SIZE = BUFFER_SIZE_KB * 1024;
    
    private static final Random rnd = new Random();

    @Benchmark
    public static void fileChannelIndirectBuffer() {

        System.out.println("Using FileChannel and non-direct buffer ...");
        
        Path copyTo = COPY_TO.resolve("Rafa Best Shots " + rnd.nextInt() + ".mp4");
        try (FileChannel fileChannel_from = (FileChannel.open(COPY_FROM, EnumSet.of(StandardOpenOption.READ)));
                FileChannel fileChannel_to = (FileChannel.open(copyTo, EnumSet.of(StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)))) {

            // Allocate an non-direct ByteBuffer
            ByteBuffer bytebuffer = ByteBuffer.allocate(BUFFER_SIZE);

            // Read data from file into ByteBuffer
            while ((fileChannel_from.read(bytebuffer)) > 0) {

                //flip the buffer which set the limit to current position, and position to 0             
                bytebuffer.flip();

                //write data from ByteBuffer to file
                fileChannel_to.write(bytebuffer);

                //for the next read
                bytebuffer.clear();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @Benchmark
    public static void fileChannelDirectBuffer() {

        System.out.println("Using FileChannel and direct buffer ...");
        
        Path copyTo = COPY_TO.resolve("Rafa Best Shots " + rnd.nextInt() + ".mp4");
        try (FileChannel fileChannel_from = (FileChannel.open(COPY_FROM, EnumSet.of(StandardOpenOption.READ))); 
                FileChannel fileChannel_to = (FileChannel.open(copyTo, EnumSet.of(StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)))) {

            // Allocate an direct ByteBuffer
            ByteBuffer bytebuffer = ByteBuffer.allocateDirect(BUFFER_SIZE);

            // Read data from file into ByteBuffer
            while ((fileChannel_from.read(bytebuffer)) > 0) {

                //flip the buffer which set the limit to current position, and position to 0             
                bytebuffer.flip();

                //write data from ByteBuffer to file
                fileChannel_to.write(bytebuffer);

                //for the next read
                bytebuffer.clear();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @Benchmark
    public static void fileChannelTransferTo() {

        System.out.println("Using FileChannel.transferTo method ...");
        
        Path copyTo = COPY_TO.resolve("Rafa Best Shots " + rnd.nextInt() + ".mp4");
        try (FileChannel fileChannel_from = (FileChannel.open(
                COPY_FROM, EnumSet.of(StandardOpenOption.READ))); 
                FileChannel fileChannel_to = (FileChannel.open(copyTo, EnumSet.of(
                StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)))) {

            fileChannel_from.transferTo(0L, fileChannel_from.size(), fileChannel_to);

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @Benchmark
    public static void fileChannelTransferFrom() {

        System.out.println("Using FileChannel.transferFrom method ...");
        
        Path copyTo = COPY_TO.resolve("Rafa Best Shots " + rnd.nextInt() + ".mp4");
        try (FileChannel fileChannel_from = (FileChannel.open(
                COPY_FROM, EnumSet.of(StandardOpenOption.READ))); 
                FileChannel fileChannel_to = (FileChannel.open(copyTo, EnumSet.of(
                StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)))) {

            fileChannel_to.transferFrom(fileChannel_from, 0L, (int) fileChannel_from.size());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @Benchmark
    public static void fileChannelMap() {

        System.out.println("Using FileChannel.map method ...");
        
        Path copyTo = COPY_TO.resolve("Rafa Best Shots " + rnd.nextInt() + ".mp4");
        try (FileChannel fileChannel_from = (FileChannel.open(COPY_FROM, EnumSet.of(StandardOpenOption.READ)));
                FileChannel fileChannel_to = (FileChannel.open(copyTo, EnumSet.of(StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)))) {

            MappedByteBuffer buffer = fileChannel_from.map(
                    FileChannel.MapMode.READ_ONLY, 0, fileChannel_from.size());

            fileChannel_to.write(buffer);
            buffer.clear();

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @Benchmark
    public static void bufferedStreamIO() {

        System.out.println("Using buffered streams and byte array ...");

        Path copyTo = COPY_TO.resolve("Rafa Best Shots " + rnd.nextInt() + ".mp4");
        File inFileStr = COPY_FROM.toFile();
        File outFileStr = copyTo.toFile();

        try (BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(inFileStr)); BufferedOutputStream out
                = new BufferedOutputStream(new FileOutputStream(outFileStr))) {

            byte[] byteArray = new byte[BUFFER_SIZE];
            int bytesCount;
            while ((bytesCount = in.read(byteArray)) != -1) {
                out.write(byteArray, 0, bytesCount);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @Benchmark
    public static void bufferedStreamByteArray() {

        System.out.println("Using un-buffered streams and byte array ...");

        Path copyTo = COPY_TO.resolve("Rafa Best Shots " + rnd.nextInt() + ".mp4");
        File inFileStr = COPY_FROM.toFile();
        File outFileStr = copyTo.toFile();

        try (FileInputStream in = new FileInputStream(inFileStr); 
                FileOutputStream out = new FileOutputStream(outFileStr)) {

            byte[] byteArray = new byte[BUFFER_SIZE];
            int bytesCount;
            while ((bytesCount = in.read(byteArray)) != -1) {
                out.write(byteArray, 0, bytesCount);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @Benchmark
    public static void filesCopyPathToPath() {

        System.out.println("Using Files.copy (Path to Path) method ...");

        Path copyTo = COPY_TO.resolve("Rafa Best Shots " + rnd.nextInt() + ".mp4");
        try {
            Files.copy(COPY_FROM, copyTo, NOFOLLOW_LINKS);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Benchmark
    public static void filesCopyIStreamToPath() {

        System.out.println("Using Files.copy (InputStream to Path) ...");

        Path copyTo = COPY_TO.resolve("Rafa Best Shots " + rnd.nextInt() + ".mp4");
        try (InputStream is = new FileInputStream(COPY_FROM.toFile())) {
            Files.copy(is, copyTo);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Benchmark
    public static void filesCopyPathToOStream() {

        System.out.println("Using Files.copy (Path to OutputStream) ...");

        Path copyTo = COPY_TO.resolve("Rafa Best Shots " + rnd.nextInt() + ".mp4");
        try (OutputStream os = new FileOutputStream(copyTo.toFile())) {
            Files.copy(COPY_FROM, os);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) throws IOException {

        org.openjdk.jmh.Main.main(args);
    }
}