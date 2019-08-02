package modern.challenge;

public class ClassCll2 {

    public void method() {
        synchronized (ClassCll2.class) {
            System.out.println("This is an CLL example");
        }
    }
}
