package modern.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Jsonb jsonb = JsonbBuilder.create();
        HttpClient client = HttpClient.newHttpClient();

        System.out.println("-------------------------------------");
        System.out.println("-------------Get a user--------------");
        System.out.println("-------------------------------------");

        HttpRequest requestGet = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        HttpResponse<User> responseGet = client.send(requestGet,
                JsonBodyHandler.jsonBodyHandler(jsonb, User.class));

        System.out.println("Status code: " + responseGet.statusCode());

        User user = responseGet.body();
        System.out.println(user);

        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("-------------Update user-------------");
        System.out.println("-------------------------------------");

        user.getData().setEmail("newemail@gmail.com");

        HttpRequest requestPut = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create("https://reqres.in/api/users"))
                .PUT(HttpRequest.BodyPublishers.ofString(jsonb.toJson(user)))
                .build();

        HttpResponse<User> responsePut = client.send(
                requestPut, JsonBodyHandler.jsonBodyHandler(jsonb, User.class));

        System.out.println("Status code: " + responsePut.statusCode());

        User updatedUser = responsePut.body();
        System.out.println(updatedUser);

        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("-------------Post new user------------");
        System.out.println("-------------------------------------");

        Data data = new Data();
        data.setId(10);
        data.setFirstName("John");
        data.setLastName("Year");
        data.setAvatar("https://johnyear.com/jy.png");

        User newUser = new User();
        newUser.setData(data);

        HttpRequest requestPost = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create("https://reqres.in/api/users"))
                .POST(HttpRequest.BodyPublishers.ofString(jsonb.toJson(user)))
                .build();

        HttpResponse<Void> responsePost = client.send(
                requestPost, HttpResponse.BodyHandlers.discarding());

        System.out.println("Status code: " + responsePost.statusCode());
    }
}
