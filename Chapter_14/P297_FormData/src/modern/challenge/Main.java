package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Map<Object, Object> data = new HashMap<>();
        data.put("fistname", "John");
        data.put("lastname", "Year");
        data.put("age", 54);
        data.put("avatar", "https://avatars.com/johnyear");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create("http://jkorpela.fi/cgi-bin/echo.cgi"))
                .POST(FormBodyPublisher.ofForm(data))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + response.statusCode());
        System.out.println("\n Body: " + response.body());
    }
}
