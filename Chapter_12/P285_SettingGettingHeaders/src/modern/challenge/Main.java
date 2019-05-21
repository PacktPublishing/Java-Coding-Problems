package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .headers("Content-Type", "application/json")
                .header("Referer", "https://reqres.in/")
                .setHeader("X-Auth", "authtoken")
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        HttpHeaders allHeaders = response.headers();        
        System.out.println("All headers: " + allHeaders);                       
        
        List<String> allValuesOfCacheControl = response.headers().allValues("Cache-Control");                        
        System.out.println("All values of Cache-Control: " + allValuesOfCacheControl);                       
        
        Optional<String> firstValueOfCacheControl = response.headers().firstValue("Cache-Control");
        System.out.println("First value of Cache-Control: " + firstValueOfCacheControl);                       
    }

}
