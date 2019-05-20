package modern.challenge;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("clothes.txt");

        List<String> tokensV1 = FileTokenizer.getV1(path, StandardCharsets.UTF_8, "&");
        System.out.println("Calling getV1():\n" + tokensV1);

        List<String> tokensV1md = FileTokenizer.getWithMultipleDelimitersV1(
                path, StandardCharsets.UTF_8, new String[]{"&", "|", "\\", "/"});
        System.out.println("\nCalling getWithMultipleDelimitersV1():\n" + tokensV1md);

        List<String> tokensV2 = FileTokenizer.getV2(path, StandardCharsets.UTF_8, "&");
        System.out.println("\nCalling getV2():\n" + tokensV2);

        List<String> tokensV3 = FileTokenizer.getV3(path, StandardCharsets.UTF_8, "&");
        System.out.println("\nCalling getV3():\n" + tokensV3);

        List<String> tokensV4 = FileTokenizer.getV4(path, StandardCharsets.UTF_8, "&");
        System.out.println("\nCalling getV4():\n" + tokensV4);

        List<String> tokensV5 = FileTokenizer.getV5(path, StandardCharsets.UTF_8, "&");
        System.out.println("\nCalling getV5():\n" + tokensV5);

        List<String> tokensV5md = FileTokenizer.getWithMultipleDelimitersV5(
                path, StandardCharsets.UTF_8, new String[]{"&", "|", "\\", "/"});
        System.out.println("\nCalling getWithMultipleDelimitersV5():\n" + tokensV5md);

        List<String> tokensV6 = FileTokenizer.getV6(path, StandardCharsets.UTF_8, "&");
        System.out.println("\nCalling getV6():\n" + tokensV6);
    }

}
