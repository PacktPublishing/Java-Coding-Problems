package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
                              
        // HTTP GET        
        HttpRequest requestGet = HttpRequest.newBuilder()
                .GET() // can be omitted since it is default
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        HttpResponse<String> responseGet = client.send(
                requestGet, HttpResponse.BodyHandlers.ofString());

        System.out.println("GET | Status code: " + responseGet.statusCode());
        System.out.println("GET | Body: " + responseGet.body());

        System.out.println();

        // HTTP POST
        HttpRequest requestPost = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(
                        "{\"name\": \"morpheus\",\"job\": \"leader\"}"))
                .uri(URI.create("https://reqres.in/api/users"))
                .build();

        HttpResponse<String> responsePost = client.send(
                requestPost, HttpResponse.BodyHandlers.ofString());

        System.out.println("POST | Status code: " + responsePost.statusCode());
        System.out.println("POST | Body: " + responsePost.body());

        System.out.println();

        // HTTP PUT
        HttpRequest requestPut = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(
                        "{\"name\": \"morpheus\",\"job\": \"zion resident\"}"))
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        HttpResponse<String> responsePut = client.send(
                requestPut, HttpResponse.BodyHandlers.ofString());

        System.out.println("PUT | Status code: " + responsePut.statusCode());
        System.out.println("PUT | Body: " + responsePut.body());

        System.out.println();

        // HTTP DELETE
        HttpRequest requestDelete = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        HttpResponse<String> responseDelete = client.send(
                requestDelete, HttpResponse.BodyHandlers.ofString());

        System.out.println("DELETE | Status code: " + responseDelete.statusCode());
        System.out.println("DELETE | Body: " + responseDelete.body());

        System.out.println();

        // HTTP PATCH
        HttpRequest requestPatch = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(
                        "{\"name\": \"morpheus\",\"job\": \"zion resident\"}"))
                .uri(URI.create("https://reqres.in/api/users/1"))
                .build();

        HttpResponse<String> responsePatch = client.send(
                requestPatch, HttpResponse.BodyHandlers.ofString());

        System.out.println("PATCH | Status code: " + responsePatch.statusCode());
        System.out.println("PATCH | Body: " + responsePatch.body());

        System.out.println();
        
        // HTTP HEAD        
        HttpRequest requestHead = HttpRequest.newBuilder()
                .method("HEAD", HttpRequest.BodyPublishers.noBody())
                .uri(URI.create("https://reqres.in/api/users/1"))
                .build();

        HttpResponse<String> responseHead = client.send(
                requestHead, HttpResponse.BodyHandlers.ofString());

        System.out.println("HEAD | Status code: " + responseHead.statusCode());
        System.out.println("HEAD | Body: " + responseHead.body());
    }
}
