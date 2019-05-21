package modern.challenge;

import java.net.URLEncoder;
import java.util.Map;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class FormBodyPublisher {

    public static HttpRequest.BodyPublisher ofForm(Map<Object, Object> data) {

        StringBuilder body = new StringBuilder();

        for (Object dataKey : data.keySet()) {

            if (body.length() > 0) {
                body.append("&");
            }

            body.append(encode(dataKey))
                    .append("=")
                    .append(encode(data.get(dataKey)));
        }

        return HttpRequest.BodyPublishers.ofString(body.toString());
    }

    private static String encode(Object obj) {
        return URLEncoder.encode(obj.toString(), StandardCharsets.UTF_8);
    }
}
