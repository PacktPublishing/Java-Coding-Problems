package modern.challenge.view;

import java.util.List;
import modern.challenge.dto.BookDto;

public class BookViewDto {

    private final List<BookDto> books;
    private final boolean last;

    public BookViewDto(List<BookDto> books, boolean last) {
        this.books = books;
        this.last = last;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public boolean isLast() {
        return last;
    }
}
