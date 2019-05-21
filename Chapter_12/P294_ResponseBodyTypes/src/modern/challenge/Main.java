package modern.challenge;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

public class Main {

    private static final byte[] NO_CONTENT = "NO CONTENT".getBytes();

    public static void main(String[] args)
            throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        // HttpResponse.BodyHandlers.ofString()
        HttpResponse<String> responseOfString = client.send(
                request, HttpResponse.BodyHandlers.ofString());
        System.out.println("HttpResponse.BodyHandlers.ofString():");
        System.out.println("Status code: " + responseOfString.statusCode());
        System.out.println("Body: " + responseOfString.body());

        // HttpResponse.BodyHandlers.ofFile()
        HttpResponse<Path> responseOfFile = client.send(
                request, HttpResponse.BodyHandlers.ofFile(Path.of("response.json")));
        System.out.println("\nHttpResponse.BodyHandlers.ofFile():");
        System.out.println("Status code: " + responseOfFile.statusCode());
        System.out.println("Body: " + responseOfFile.body());

        // HttpResponse.BodyHandlers.ofByteArray()
        HttpResponse<byte[]> responseOfByteArray = client.send(
                request, HttpResponse.BodyHandlers.ofByteArray());
        System.out.println("\nHttpResponse.BodyHandlers.ofByteArray():");
        System.out.println("Status code: " + responseOfByteArray.statusCode());
        System.out.println("Body: " + new String(responseOfByteArray.body()));

        // HttpResponse.BodyHandlers.ofLines()
        HttpResponse<Stream<String>> responseOfLines = client.send(
                request, HttpResponse.BodyHandlers.ofLines());
        System.out.println("\nHttpResponse.BodyHandlers.ofLines():");
        System.out.println("Status code: " + responseOfLines.statusCode());
        System.out.println("Body: " + responseOfLines.body().collect(toList()));

        // HttpResponse.BodyHandlers.ofInputStream()
        HttpResponse<InputStream> responseOfInputStream = client.send(
                request, HttpResponse.BodyHandlers.ofInputStream());
        System.out.println("\nHttpResponse.BodyHandlers.ofInputStream():");
        System.out.println("Status code: " + responseOfInputStream.statusCode());

        byte[] allBytes;
        try ( InputStream fromIs = responseOfInputStream.body()) {
            allBytes = fromIs.readAllBytes();
        }

        System.out.println("Body: " + new String(allBytes, StandardCharsets.UTF_8));
    }
}
