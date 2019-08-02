package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

public class Main {

    private static final ConcurrentMap<HttpRequest, CompletableFuture<HttpResponse<String>>> promisesMap 
            = new ConcurrentHashMap<>();

    private static final Function<HttpRequest, HttpResponse.BodyHandler<String>> promiseHandler
            = (HttpRequest req) -> HttpResponse.BodyHandlers.ofString();

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://http2.golang.org/serverpush"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString(), pushPromiseHandler())
                .thenApply(HttpResponse::body)
                .thenAccept((b) -> System.out.println("\nMain resource:\n" + b))
                .join();

        System.out.println("\nPush promises map size: " + promisesMap.size() + "\n");

        promisesMap.entrySet().forEach((entry) -> {
            System.out.println("Request = " + entry.getKey()
                    + ", \nResponse = " + entry.getValue().join().body());
        });
    }

    private static HttpResponse.PushPromiseHandler<String> pushPromiseHandler() {
        return HttpResponse.PushPromiseHandler.of(promiseHandler, promisesMap);
    }
}
