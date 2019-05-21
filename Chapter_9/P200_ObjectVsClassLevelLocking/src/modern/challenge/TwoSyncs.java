package modern.challenge;

public class TwoSyncs {

    public synchronized void method1() {
        System.out.println("method1(): " + Thread.currentThread().getName());
        method2();
    }

    public synchronized void method2() {
        System.out.println("method2(): " + Thread.currentThread().getName());
        while (true) {
        }
    }
}
