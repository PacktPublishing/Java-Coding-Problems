package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Downloading (please wait) ...");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://demo.borland.com/testsite/downloads/downloadfile.php?file=Hello.txt&cd=attachment+filename"))
                .build();

        HttpResponse<Path> response = client.send(
                request, HttpResponse.BodyHandlers
                        .ofFileDownload(Path.of(System.getProperty("user.dir")), CREATE, WRITE));

        System.out.println("Status code: " + response.statusCode());
        System.out.println("\n Body: " + response.body());
    }

}
