package modern.challenge;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Accept-Encoding", "gzip")
                .uri(URI.create("https://davidwalsh.name"))
                .build();

        HttpResponse<InputStream> response = client.send(
                request, HttpResponse.BodyHandlers.ofInputStream());

        System.out.println("Status code: " + response.statusCode());

        String encoding = response.headers().firstValue("Content-Encoding").orElse("");
        System.out.println("\nEncoding: " + encoding + "\n");

        if ("gzip".equals(encoding)) {
            String gzipAsString = gzipToString(response.body());
            System.out.println(gzipAsString);
        } else {
            String isAsString = isToString(response.body());
            System.out.println(isAsString);
        }
    }

    public static String gzipToString(InputStream gzip) throws IOException {

        byte[] allBytes;
        try ( InputStream fromIs = new GZIPInputStream(gzip)) {
            allBytes = fromIs.readAllBytes();
        }

        return new String(allBytes, StandardCharsets.UTF_8);
    }

    public static String isToString(InputStream is) throws IOException {

        byte[] allBytes;
        try ( InputStream fromIs = is) {
            allBytes = fromIs.readAllBytes();
        }

        return new String(allBytes, StandardCharsets.UTF_8);
    }

    // or
    /*
    public static String gzipToString(InputStream gzip) throws IOException {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try ( InputStream fromIs = new GZIPInputStream(gzip);  ByteArrayOutputStream toOs = os) {
            fromIs.transferTo(toOs);
        }

        return new String(os.toByteArray(), StandardCharsets.UTF_8);
    }
    
    public static String isToString(InputStream is) throws IOException {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try ( InputStream fromIs = is;  ByteArrayOutputStream toOs = os) {
            fromIs.transferTo(toOs);
        }

        return new String(os.toByteArray(), StandardCharsets.UTF_8);
    }*/
}
