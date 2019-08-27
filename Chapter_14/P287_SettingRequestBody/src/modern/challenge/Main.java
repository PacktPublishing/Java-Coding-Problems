package modern.challenge;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        // BodyPublishers.ofString() - create a String body
        HttpRequest requestBodyOfString = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(
                        "{\"name\": \"morpheus\",\"job\": \"leader\"}"))
                .uri(URI.create("https://reqres.in/api/users"))
                .build();

        HttpResponse<String> responseBodyOfString = client.send(
                requestBodyOfString, HttpResponse.BodyHandlers.ofString());

        System.out.println("BodyPublishers.ofString() | Status code: "
                + responseBodyOfString.statusCode());
        System.out.println("BodyPublishers.ofString() | Body: "
                + responseBodyOfString.body());

        System.out.println();

        // BodyPublishers.ofInputStream() - create an input stream body
        HttpRequest requestBodyOfInputStream = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofInputStream(() -> inputStream("user.json")))
                .uri(URI.create("https://reqres.in/api/users"))
                .build();

        HttpResponse<String> responseBodyOfInputStream = client.send(
                requestBodyOfInputStream, HttpResponse.BodyHandlers.ofString());

        System.out.println("BodyPublishers.ofInputStream() | Status code: "
                + responseBodyOfInputStream.statusCode());
        System.out.println("BodyPublishers.ofInputStream() | Body: "
                + responseBodyOfInputStream.body());

        System.out.println();

        // BodyPublishers.ofByteArray() - create an byte array body
        HttpRequest requestBodyOfByteArray = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofByteArray(Files.readAllBytes(Path.of("user.json"))))
                .uri(URI.create("https://reqres.in/api/users"))
                .build();

        HttpResponse<String> responseBodyOfByteArrays = client.send(
                requestBodyOfByteArray, HttpResponse.BodyHandlers.ofString());

        System.out.println("BodyPublishers.ofByteArray() | Status code: "
                + responseBodyOfByteArrays.statusCode());
        System.out.println("BodyPublishers.ofByteArray() | Body: "
                + responseBodyOfByteArrays.body());

        System.out.println();

        // BodyPublishers.ofFile() - create a body from a file
        HttpRequest requestBodyOfFile = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("user.json")))
                .uri(URI.create("https://reqres.in/api/users"))
                .build();

        HttpResponse<String> responseBodyOfFile = client.send(
                requestBodyOfFile, HttpResponse.BodyHandlers.ofString());

        System.out.println("BodyPublishers.ofFile() | Status code: "
                + responseBodyOfFile.statusCode());
        System.out.println("BodyPublishers.ofFile() | Body: "
                + responseBodyOfFile.body());
    }

    private static ByteArrayInputStream inputStream(String fileName) {

        try ( ByteArrayInputStream inputStream = new ByteArrayInputStream(
                Files.readAllBytes(Path.of(fileName)))) {

            return inputStream;
        } catch (IOException ex) {
            throw new RuntimeException("File could not be read: ", ex);
        }
    }

}
