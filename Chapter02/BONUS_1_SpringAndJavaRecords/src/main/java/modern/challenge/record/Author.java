package modern.challenge.record;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record Author(@JsonProperty("name") String name, 
@JsonProperty("genre") String genre, 
@JsonProperty("books") List<Book> books) {}
