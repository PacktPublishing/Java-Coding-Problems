package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Downloading (please wait) ...");
        
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()               
                .uri(URI.create("http://central.maven.org/maven2/org/hibernate/hibernate-core/5.4.2.Final/hibernate-core-5.4.2.Final.jar"))                
                .build();

        HttpResponse<Path> response = client.send(
                request, HttpResponse.BodyHandlers.ofFile(Path.of("hibernate-core-5.4.2.Final.jar")));
        
        System.out.println("Status code: " + response.statusCode());        
        System.out.println("\n Body: " + response.body());
    }
    
}
