package modern.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path1 = Paths.get("/learning/packt/JavaModernChallenge.pdf");
        Path path2 = Paths.get("/LEARNING/PACKT/JavaModernChallenge.pdf");
        Path path3 = Paths.get("D:/learning/packt/JavaModernChallenge.pdf");

        boolean path1EqualsPath2 = path1.equals(path2);
        boolean path2EqualsPath3 = path2.equals(path3);
        System.out.println("path1.equals(path2): " + path1EqualsPath2);
        System.out.println("path2.equals(path3): " + path2EqualsPath3);

        boolean path1IsSameFilePath2 = Files.isSameFile(path1, path2);
        boolean path1IsSameFilePath3 = Files.isSameFile(path1, path3);
        boolean path2IsSameFilePath3 = Files.isSameFile(path2, path3);
        System.out.println("\nisSameFile(path1, path2): " + path1IsSameFilePath2);
        System.out.println("isSameFile(path1, path3): " + path1IsSameFilePath3);
        System.out.println("isSameFile(path2, path3): " + path2IsSameFilePath3);

        int path1compareToPath2 = path1.compareTo(path2);
        int path1compareToPath3 = path1.compareTo(path3);
        int path2compareToPath3 = path2.compareTo(path3);
        System.out.println("\npath1.compareTo(path2): " + path1compareToPath2);
        System.out.println("path1.compareTo(path3): " + path1compareToPath3);
        System.out.println("path2.compareTo(path3): " + path2compareToPath3);

        boolean sw = path1.startsWith("/learning/packt");
        boolean ew = path1.endsWith("JavaModernChallenge.pdf");
        System.out.println("\nStart width: " + sw);
        System.out.println("End with: " + ew);
    }

}
