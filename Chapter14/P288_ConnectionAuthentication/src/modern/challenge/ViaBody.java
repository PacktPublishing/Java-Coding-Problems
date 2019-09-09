package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

public class ViaBody {

    public void bodyExample() throws IOException, InterruptedException {
        
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(
                        "{\"email\":\"eve.holt@reqres.in\",\"password\":\"cityslicka\"}"))
                .uri(URI.create("https://reqres.in/api/login"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + response.statusCode());
        System.out.println("\n Body: " + response.body());
    }
}
