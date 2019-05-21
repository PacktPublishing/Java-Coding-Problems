package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Map<Object, Object> data = new LinkedHashMap<>();
        data.put("author", "Lorem Ipsum Generator");
        data.put("filefield", Path.of("LoremIpsum.txt"));
        String boundary = UUID.randomUUID().toString().replaceAll("-", "");

        HttpClient client = HttpClient.newHttpClient();        
        
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "multipart/form-data;boundary=" + boundary)
                .POST(MultipartBodyPublisher.ofMultipart(data, boundary))
                .uri(URI.create("http://jkorpela.fi/cgi-bin/echoraw.cgi"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + response.statusCode());
        System.out.println("\n Body: " + response.body());
    }
}
