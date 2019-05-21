package modern.challenge;

public class Main {

    // this code will throw java.lang.IllegalStateException
    // or NoSuchElementException, depending on which method you call
    
    public static void main(String[] args) {

        Book book = new Book();

        // Avoid
        // book.findStatusAvoid();

        // Prefer
        book.findStatusPrefer1();
        book.findStatusPrefer2();
        book.findStatusPrefer3();
    }

}
