package modern.challenge;

public class NewThread {

    public void newThread() {

        Thread t1 = new Thread(() -> {
        });               
        System.out.println("NewThread t1: " + t1.getState());

        Runnable runnable1 = () -> {
        };        
        Thread t2 = new Thread(runnable1);
        System.out.println("NewThread t2: " + t2.getState());

        Thread t3 = new Thread(new Runnable() {
            public void run() {
            }
        });
        System.out.println("NewThread t3: " + t3.getState());
        
        Thread t4 = new Thread(new Thread() {
            public void run() {
            }
        });
        System.out.println("NewThread t4: " + t4.getState() + "\n");
    }
}
