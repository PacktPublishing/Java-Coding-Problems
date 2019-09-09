package modern.challenge;

public interface Slicer {

    public void type();

    default void slice() {
        System.out.println("slice");
    }
}
