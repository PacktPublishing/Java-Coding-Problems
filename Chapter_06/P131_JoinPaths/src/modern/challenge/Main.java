package modern.challenge;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        // fix path
        Path base1 = Paths.get("D:/learning/packt");        

        Path path1 = base1.resolve("JBossTools3.pdf");
        System.out.println(path1);

        Path path2 = base1.resolve("MasteringJSF22.pdf");
        System.out.println(path2 + "\n");

        Path basePath = Paths.get("D:/learning/packt");
        String[] books = {"Book1.pdf", "Book2.pdf", "Book3.pdf"};
        for (String book : books) {
            Path nextBook = basePath.resolve(book);
            System.out.println(nextBook);
        }

        // fix path
        Path base2 = Paths.get("D:/learning/packt/JavaModernChallenge.pdf");
        
        Path path3 = base2.resolveSibling("MasteringJSF22.pdf");
        System.out.println("\n" + path3);

        Path path4 = base2.getParent().resolveSibling("publisher").resolve("MyBook.pdf");
        System.out.println("\n" + path4);
    }

}
