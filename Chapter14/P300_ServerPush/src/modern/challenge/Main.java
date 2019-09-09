package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

public class Main {

    private static final List<CompletableFuture<Void>> asyncPushRequests = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://http2.golang.org/serverpush"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString(), pushPromiseHandler())
                .thenApply(HttpResponse::body)
                .thenAccept((b) -> System.out.println("\nMain resource:\n" + b))
                .join();

        asyncPushRequests.forEach(CompletableFuture::join);

        System.out.println("\nFetched a total of " + asyncPushRequests.size() + " push requests");
    }

    private static HttpResponse.PushPromiseHandler<String> pushPromiseHandler() {
        return (HttpRequest initiatingRequest, HttpRequest pushPromiseRequest,
                Function<HttpResponse.BodyHandler<String>, CompletableFuture<HttpResponse<String>>> acceptor) -> {
            CompletableFuture<Void> pushcf = acceptor.apply(HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept((b) -> System.out.println("\nPushed resource body:\n " + b));

            asyncPushRequests.add(pushcf);

            System.out.println("\nJust got promise push number: " + asyncPushRequests.size());
            System.out.println("\nInitial push request: " + initiatingRequest.uri());
            System.out.println("Initial push headers: " + initiatingRequest.headers());
            System.out.println("Promise push request: " + pushPromiseRequest.uri());
            System.out.println("Promise push headers: " + pushPromiseRequest.headers());
        };
    }
}
