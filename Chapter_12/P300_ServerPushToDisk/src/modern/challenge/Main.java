package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

public class Main {

    private static final ConcurrentMap<HttpRequest, CompletableFuture<HttpResponse<Path>>> 
            promisesMap = new ConcurrentHashMap<>();

    private static final Function<HttpRequest, HttpResponse.BodyHandler<Path>> 
            promiseHandler = (HttpRequest req) -> HttpResponse.BodyHandlers.ofFile(Paths.get(req.uri().getPath()).getFileName());

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://http2.golang.org/serverpush"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofFile(Path.of("index.html")), pushPromiseHandler())
                .thenApply(HttpResponse::body)
                .thenAccept((b) -> System.out.println("\nMain resource:\n" + b))
                .join();

        System.out.println("\nPush promises map size: " + promisesMap.size() + "\n");

        promisesMap.entrySet().forEach((entry) -> {
            System.out.println("Request = " + entry.getKey()
                    + ", \nResponse = " + entry.getValue().join().body());
        });
    }

    private static HttpResponse.PushPromiseHandler<Path> pushPromiseHandler() {
        return HttpResponse.PushPromiseHandler.of(promiseHandler, promisesMap);
    }       
}
