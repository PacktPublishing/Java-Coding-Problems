package modern.challenge.view;

import java.util.List;
import modern.challenge.entity.Book;

public class BookView {

    private final List<Book> books;
    private final boolean last;

    public BookView(List<Book> books, boolean last) {
        this.books = books;
        this.last = last;
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean isLast() {
        return last;
    }
}
