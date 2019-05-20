package modern.challenge;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) { 

        Path path1 = Paths.get("JBossTools3.pdf");
        Path path2 = Paths.get("JavaModernChallenge.pdf");
        Path path3 = Paths.get("/learning/packt/2003/JBossTools3.pdf");
        Path path4 = Paths.get("/learning/packt/2019");

        Path path1ToPath2 = path1.relativize(path2);
        System.out.println("Path 1 to path 2: \n" + path1ToPath2);

        Path path2ToPath1 = path2.relativize(path1);
        System.out.println("\nPath 2 to path 1: \n" + path2ToPath1);

        Path path3ToPath4 = path3.relativize(path4);
        System.out.println("\nPath 3 to path 4: \n" + path3ToPath4);

        Path path4ToPath3 = path4.relativize(path3);
        System.out.println("\nPath 4 to path 3: \n" + path4ToPath3);
    }

}
