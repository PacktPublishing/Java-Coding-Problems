package modern.challenge;

import java.util.List;

public final class Author {
    
    private final String name;
    private final List<Book> books;

    public Author(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }            
}
