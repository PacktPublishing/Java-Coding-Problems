package modern.challenge;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        /*
        HttpClient client = HttpClient.newBuilder()
                .cookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_NONE))
                .build();

        System.out.println(client.cookieHandler().orElseThrow());
         */
        
        CookieManager cm = new CookieManager();
        cm.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        
        HttpClient client = HttpClient.newBuilder()
                .cookieHandler(cm)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Authorization", "Bearer Q3ku4mp_hCQGvAFeYKa0ktFCDKS3VpSA1nwf")                
                .uri(URI.create("https://gorest.co.in/public-api/users/1"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + response.statusCode());
        System.out.println("\n Body: " + response.body());       
        System.out.println("\nset-cookie header: " + response.headers().firstValue("set-cookie"));
        
        CookieStore cookieStore = cm.getCookieStore();
        
        System.out.println("\nCookies: " + cookieStore.getCookies());
    }
}
