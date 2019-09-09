package modern.challenge;

import java.io.IOException;
import java.util.Map;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MultipartBodyPublisher {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static HttpRequest.BodyPublisher ofMultipart(
            Map<Object, Object> data, String boundary) throws IOException {

        final byte[] separator = ("--" + boundary + LINE_SEPARATOR
                + "Content-Disposition: form-data; name=").getBytes(StandardCharsets.UTF_8);
        final List<byte[]> body = new ArrayList<>();

        for (Object dataKey : data.keySet()) {
            body.add(separator);

            Object dataValue = data.get(dataKey);

            if (dataValue instanceof Path) {
                Path path = (Path) dataValue;

                String mimeType = fetchMimeType(path);

                body.add(("\"" + dataKey + "\"; filename=\"" + path.getFileName()
                        + "\"" + LINE_SEPARATOR + "Content-Type: "
                        + mimeType + LINE_SEPARATOR + LINE_SEPARATOR)
                        .getBytes(StandardCharsets.UTF_8));

                body.add(Files.readAllBytes(path));

                body.add(LINE_SEPARATOR.getBytes(StandardCharsets.UTF_8));
            } else {
                body.add(("\"" + dataKey + "\""
                        + LINE_SEPARATOR + LINE_SEPARATOR + dataValue + LINE_SEPARATOR)
                        .getBytes(StandardCharsets.UTF_8));
            }
        }

        body.add(("--" + boundary + "--").getBytes(StandardCharsets.UTF_8));

        return HttpRequest.BodyPublishers.ofByteArrays(body);
    }

    private static String fetchMimeType(Path filenamePath) throws IOException {
        String mimeType = Files.probeContentType(filenamePath);

        if (mimeType == null) {
            throw new IOException("Mime type could not be fetched");
        }

        return mimeType;
    }
}
