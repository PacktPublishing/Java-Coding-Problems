package modern.challenge;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class WaitAllResponsesFetchBodiesInList {

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

        @SuppressWarnings("unchecked")
        CompletableFuture<String>[] arrayResponses = requests.stream()
                .map(req -> asyncResponse(client, req))
                .toArray(CompletableFuture[]::new);

        CompletableFuture<Void> responses = CompletableFuture.allOf(arrayResponses);

        while (!responses.isDone()) {
            Thread.sleep(50);
            System.out.println("Waiting for all responses ...");
        }

        responses.get(); // eventually, add a timeout

        List<String> results = responses.thenApply(e -> {

            List<String> bodies = new ArrayList<>();
            for (CompletableFuture<String> body : arrayResponses) {
                bodies.add(body.join());
            }

            return bodies;
        }).get();

        results.forEach(System.out::println);
    }

    private static CompletableFuture<String> asyncResponse(
            HttpClient client, HttpRequest request) {

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply((res) -> res.uri() + " | " + res.body() + "\n")
                .exceptionally(e -> "Exception: " + e);
    }
}
