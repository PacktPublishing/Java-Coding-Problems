package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Version: " + response.version());
        System.out.println("\nURI: " + response.uri());
        System.out.println("\nStatus code: " + response.statusCode());
        System.out.println("\nHeaders: " + response.headers());
        System.out.println("\n Body: " + response.body());
    }
}
