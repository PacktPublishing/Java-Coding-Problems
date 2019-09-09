package modern.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        Path file1 = Path.of("file1.txt");
        Path file2 = Path.of("file2.txt");
        Path file3 = Path.of("file3.txt");
        Path file4 = Path.of("file4.txt");
        
        System.out.println("Mismatches between file1 and file2: " 
                + Mismatches.haveMismatches(file1, file2));
        System.out.println("Mismatches between file1 and file3: " 
                + Mismatches.haveMismatches(file1, file3));
        System.out.println("Mismatches between file1 and file4: " 
                + Mismatches.haveMismatches(file1, file4));
        System.out.println("Mismatches between file2 and file3: " 
                + Mismatches.haveMismatches(file2, file3));
        System.out.println("Mismatches between file2 and file4: " 
                + Mismatches.haveMismatches(file2, file4));
        System.out.println("Mismatches between file3 and file4: " 
                + Mismatches.haveMismatches(file3, file4));

        long mismatches12 = Files.mismatch(file1, file2);
        long mismatches13 = Files.mismatch(file1, file3);
        long mismatches14 = Files.mismatch(file1, file4);
        long mismatches23 = Files.mismatch(file2, file3);
        long mismatches24 = Files.mismatch(file2, file4);
        long mismatches34 = Files.mismatch(file3, file4);
        System.out.println("Mismatches between file1 and file2: " + mismatches12);
        System.out.println("Mismatches between file1 and file3: " + mismatches13);
        System.out.println("Mismatches between file1 and file4: " + mismatches14);
        System.out.println("Mismatches between file2 and file3: " + mismatches23);
        System.out.println("Mismatches between file2 and file4: " + mismatches24);
        System.out.println("Mismatches between file3 and file4: " + mismatches34);
        
    }

}

