package modern.challenge.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface BookDto {

    Long getId();
    String getTitle();
    String getIsbn();
    int getPrice();

    @JsonIgnore
    long getTotal();
}
