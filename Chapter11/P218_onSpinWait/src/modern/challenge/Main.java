package modern.challenge;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        
        StartService startService = new StartService();
        
        new Thread(startService).start();
        
        Thread.sleep(5000);
        
        startService.setServiceAvailable(true);
    }
    
}
