package modern.challenge;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("D:/learning/books/spring");                      

        //no filter applyied        
        System.out.println("\nNo filter:");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path)) {
            for (Path file : ds) {
                System.out.println(file.getFileName());
            }
        }

        System.out.println("\nFilter PNG, JPG and BMP files via glob pattern:");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path, "*.{png,jpg,bmp}")) {
            for (Path file : ds) {
                System.out.println(file.getFileName());
            }
        }

        System.out.println("\nUser-defined filter for files larger than 10MB.");
        DirectoryStream.Filter<Path> sizeFilter = new DirectoryStream.Filter<>() {

            @Override
            public boolean accept(Path path) throws IOException {
                return (Files.size(path) > 1024 * 1024 * 10);
            }
        };

        System.out.println("\nUser-defined filter for folders.");
        DirectoryStream.Filter<Path> folderFilter = new DirectoryStream.Filter<>() {

            @Override
            public boolean accept(Path path) throws IOException {
                return (Files.isDirectory(path, NOFOLLOW_LINKS));
            }
        };

        System.out.println("\nUser-defined filter for files modified today.");
        DirectoryStream.Filter<Path> todayFilter = new DirectoryStream.Filter<>() {

            @Override
            public boolean accept(Path path) throws IOException {

                FileTime lastModified = Files.readAttributes(path,
                        BasicFileAttributes.class).lastModifiedTime();
                LocalDate lastModifiedDate = lastModified.toInstant()
                        .atOffset(ZoneOffset.UTC).toLocalDate();
                LocalDate todayDate = Instant.now()
                        .atOffset(ZoneOffset.UTC).toLocalDate();

                return lastModifiedDate.equals(todayDate);
            }
        };

        //user defined filter - only hidden files/directories
        System.out.println("\nUser-defined filter for hidden files/folders.");
        DirectoryStream.Filter<Path> hiddenFilter = new DirectoryStream.Filter<>() {

            @Override
            public boolean accept(Path path) throws IOException {
                return (Files.isHidden(path));
            }
        };

        System.out.println("\nApply 'sizeFilter' (by analogy, apply any other filter):");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path, sizeFilter)) {
            for (Path file : ds) {
                System.out.println(file.getFileName() + "    "
                        + Files.readAttributes(file, BasicFileAttributes.class).size() + " bytes");
            }
        }

        System.out.println("\nFilter all '.pdf' files via FilenameFilter:");
        FilenameFilter filter = (f, n) -> n.endsWith(".pdf");
        String[] files = path.toFile().list(filter);
        System.out.println(Arrays.toString(files));

        System.out.println("\nFilter all folders via FileFilter:");
        File[] folders = path.toFile().listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        System.out.println(Arrays.toString(folders));
    }

}
