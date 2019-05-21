package modern.challenge;

import java.util.Optional;

public class Main {
    
    // This code will cause java.lang.NullPointerException

    public static void main(String[] args) {

        Bookstore bookService = new Bookstore();
        
        Optional<String> isbn1 = bookService.isbnAvoid("1"); // throws NPE 
        System.out.println(isbn1);
        
        Optional<String> isbn2 = bookService.isbnPrefer("1");
        System.out.println(isbn2);
    }
    
}
