package modern.challenge;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        Path copyFrom = Paths.get("D:/learning/packt");
        Path copyTo = Paths.get("D:/e-courses");

        CopyFileVisitor copyFileVisitor = new CopyFileVisitor(copyFrom, copyTo);
        EnumSet opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        Files.walkFileTree(copyFrom, opts, Integer.MAX_VALUE, copyFileVisitor);
    }

}
