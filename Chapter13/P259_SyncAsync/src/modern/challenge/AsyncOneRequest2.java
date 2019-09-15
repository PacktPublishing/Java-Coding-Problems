package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncOneRequest2 {

    public void triggerOneAyncRequest()
            throws IOException, InterruptedException, ExecutionException, TimeoutException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        CompletableFuture<String> response
                = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .exceptionally(e -> "Exception: " + e);

        while (!response.isDone()) {
            Thread.sleep(50);
            System.out.println("Perform other tasks while waiting for the response ...");
        }

        String body = response.get(30, TimeUnit.SECONDS); // or join()
        System.out.println("Body: " + body);
    }
}
