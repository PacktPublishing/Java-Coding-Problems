package modern.challenge;

import java.io.ByteArrayInputStream;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodySubscribers;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class JsonBodyHandler<T> implements HttpResponse.BodyHandler<T> {

    private final Jsonb jsonb;
    private final Class<T> type;

    private JsonBodyHandler(Jsonb jsonb, Class<T> type) {
        this.jsonb = jsonb;
        this.type = type;
    }
    
    public static <T> JsonBodyHandler<T> jsonBodyHandler(Class<T> type) {
        return jsonBodyHandler(JsonbBuilder.create(), type);
    }

    public static <T> JsonBodyHandler<T> jsonBodyHandler(Jsonb jsonb, Class<T> type) {
        return new JsonBodyHandler<>(jsonb, type);
    }    

    @Override
    public HttpResponse.BodySubscriber<T> apply(HttpResponse.ResponseInfo responseInfo) {
        return BodySubscribers.mapping(BodySubscribers.ofByteArray(),
                byteArray -> this.jsonb.fromJson(new ByteArrayInputStream(byteArray), this.type));
    }        
}
