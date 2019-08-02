package modern.challenge;

import java.io.File;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    private static final String FILE_SEPARATOR = File.separator;
    // or, private static final String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();

    public static void main(String[] args) {

        System.out.println("Create a Path relative to the file store root (e.g., C:/): ");
        Path path1 = Paths.get("/learning/packt/JavaModernChallenge.pdf");
        Path path2 = Paths.get("/learning", "packt/JavaModernChallenge.pdf");
        Path path3 = Path.of("/learning/packt/JavaModernChallenge.pdf");
        Path path4 = Path.of("/learning", "packt/JavaModernChallenge.pdf");
        Path path5 = FileSystems.getDefault().getPath("/learning/packt", "JavaModernChallenge.pdf");
        Path path6 = FileSystems.getDefault().getPath("/learning/packt/JavaModernChallenge.pdf");
        Path path7 = Paths.get(URI.create("file:///learning/packt/JavaModernChallenge.pdf"));
        Path path8 = Path.of(URI.create("file:///learning/packt/JavaModernChallenge.pdf"));
        System.out.println(path1 + "\n" + path2 + "\n" + path3 + "\n"
                + path4 + "\n" + path5 + "\n" + path6 + "\n" + path7 + "\n" + path8);

        System.out.println("\nCreate a path relative to current folder (working folder): ");
        Path path9 = Paths.get("learning/packt/JavaModernChallenge.pdf");
        Path path10 = Paths.get("learning", "packt/JavaModernChallenge.pdf");
        Path path11 = Path.of("learning/packt/JavaModernChallenge.pdf");
        Path path12 = Path.of("learning", "packt/JavaModernChallenge.pdf");
        Path path13 = FileSystems.getDefault().getPath("learning/packt", "JavaModernChallenge.pdf");
        Path path14 = FileSystems.getDefault().getPath("learning/packt/JavaModernChallenge.pdf");
        System.out.println(path9 + "\n" + path10 + "\n" + path11
                + "\n" + path12 + "\n" + path13 + " \n" + path14);

        System.out.println("\nCreate an absolute path: ");
        Path path15 = Paths.get("C:/learning/packt", "JavaModernChallenge.pdf");
        Path path16 = Paths.get("C:", "learning/packt", "JavaModernChallenge.pdf");
        Path path17 = Paths.get("C:", "learning", "packt", "JavaModernChallenge.pdf");
        Path path18 = Paths.get("C:/learning/packt/JavaModernChallenge.pdf");
        Path path19 = Paths.get(System.getProperty("user.home"), "downloads", "chess.exe");
        Path path20 = Path.of("C:", "learning/packt", "JavaModernChallenge.pdf");
        Path path21 = Path.of(System.getProperty("user.home"), "downloads", "chess.exe");
        Path path22 = Paths.get(URI.create("file:///C:/learning/packt/JavaModernChallenge.pdf"));
        Path path23 = Path.of(URI.create("file:///C:/learning/packt/JavaModernChallenge.pdf"));
        System.out.println(path15 + "\n" + path16 + "\n" + path17 + "\n" + path18
                + "\n" + path19 + "\n" + path20 + "\n" + path21 + "\n" + path22 + "\n" + path23);

        System.out.println("\nCreate paths using \".\" and \"..\" notations/shortcuts: ");
        Path path24 = Paths.get("C:/learning/packt/chapters/../JavaModernChallenge.pdf").normalize();
        Path path25 = Paths.get("C:/learning/./packt/chapters/../JavaModernChallenge.pdf").normalize();
        Path path26 = FileSystems.getDefault().getPath("/learning/./packt", "JavaModernChallenge.pdf").normalize();
        Path path27 = Path.of("C:/learning/packt/chapters/../JavaModernChallenge.pdf").normalize();
        Path path28 = Path.of("C:/learning/./packt/chapters/../JavaModernChallenge.pdf").normalize();
        System.out.println(path24 + "\n" + path25 + "\n" + path26
                + "\n" + path27 + "\n" + path28);

        System.out.println("\nOS independent paths: ");
        Path path29 = Paths.get("learning", "packt", "JavaModernChallenge.pdf");
        Path path30 = Path.of("learning", "packt", "JavaModernChallenge.pdf");
        Path path31 = Paths.get(String.join(FILE_SEPARATOR, "learning", "packt", "JavaModernChallenge.pdf"));
        Path path32 = Path.of(String.join(FILE_SEPARATOR, "learning", "packt", "JavaModernChallenge.pdf"));
        Path path33 = Paths.get(FILE_SEPARATOR + "learning", "packt", "JavaModernChallenge.pdf");
        Path path34 = Path.of(FILE_SEPARATOR + "learning", "packt", "JavaModernChallenge.pdf");
        Path path35 = Paths.get(File.listRoots()[0] + "learning", "packt", "JavaModernChallenge.pdf");
        Path path36 = Path.of(File.listRoots()[0] + "learning", "packt", "JavaModernChallenge.pdf");
        System.out.println(path29 + "\n" + path30 + "\n" + path31
                + "\n" + path32 + "\n" + path33 + "\n" + path34 + "\n" + path35 + "\n" + path36);
    }

}
