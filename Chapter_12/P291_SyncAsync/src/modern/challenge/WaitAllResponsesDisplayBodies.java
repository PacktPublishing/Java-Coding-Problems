package modern.challenge;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class WaitAllResponsesDisplayBodies {

    public void waitAllResponses() 
            throws URISyntaxException, InterruptedException, ExecutionException {

        List<URI> uris = Arrays.asList(
                new URI("https://reqres.in/api/users/2"),      // one user
                new URI("https://reqres.in/api/users?page=2"), // list of users
                new URI("https://reqres.in/api/unknown/2"),    // list of resources
                new URI("https://reqres.in/api/users/23"));    // single user not foud

        HttpClient client = HttpClient.newHttpClient();

        List<HttpRequest> requests = uris.stream()
                .map(HttpRequest::newBuilder)
                .map(reqBuilder -> reqBuilder.build())
                .collect(Collectors.toList());

        CompletableFuture.allOf(requests.stream()
                .map(req -> client.sendAsync(req, HttpResponse.BodyHandlers.ofString())
                .thenApply((res) -> res.uri() + " | " + res.body() + "\n")
                .exceptionally(e -> "Exception: " + e)
                .thenAccept(System.out::println))
                .toArray(CompletableFuture<?>[]::new))
                .join();

        // or, written like this
        /*
        CompletableFuture<?>[] responses = requests.stream()
                .map(req -> client.sendAsync(req, HttpResponse.BodyHandlers.ofString())
                .thenApply((res) -> res.uri() + " | " + res.body() + "\n")
                .exceptionally(e -> "Exception: " + e)
                .thenAccept(System.out::println))
                .toArray(CompletableFuture<?>[]::new);

        CompletableFuture.allOf(responses).join();
        */
    }

}
