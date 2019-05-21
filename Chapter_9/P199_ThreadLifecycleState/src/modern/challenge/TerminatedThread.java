package modern.challenge;

public class TerminatedThread {

    public void terminatedThread() {
        
        Thread t = new Thread(() -> {            
        });
        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            // log ex
        }
        
        System.out.println("TerminatedThread t: " + t.getState() + "\n");
    }
}
