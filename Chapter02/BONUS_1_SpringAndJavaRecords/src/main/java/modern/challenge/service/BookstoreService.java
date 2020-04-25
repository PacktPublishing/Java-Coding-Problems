package modern.challenge.service;

import java.util.List;
import org.springframework.stereotype.Service;

import modern.challenge.record.Author;
import modern.challenge.record.Book;

@Service
public class BookstoreService {

    public List<Author> fetchAuthors() {

        List<Author> authors = List.of(
                new Author("Joana Nimar", "History", List.of(
                        new Book("History of a day", "JN-001"),
                        new Book("Prague history", "JN-002")
                )),
                new Author("Mark Janel", "Horror", List.of(
                        new Book("Carrie", "MJ-001"),
                        new Book("House of pain", "MJ-002")
                )
                ));

        return authors;
    }
}
