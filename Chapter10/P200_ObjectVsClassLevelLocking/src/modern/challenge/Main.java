package modern.challenge;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("*** The following snippets of codes will run indefinitely. "
                + "Consider stopping the application manually.\n");
        
        /*
        TwoSyncs instance1 = new TwoSyncs();
        TwoSyncs instance2 = new TwoSyncs();
        
        new Thread(() -> {
            instance1.method1();
        }).start();
        
        Thread.sleep(2000);
        
        new Thread(() -> {
            instance2.method1();
        }).start();
        */
                
        /*
        OllCllAndNoLock instance  = new OllCllAndNoLock();
        
        new Thread(() -> {
            instance.staticMethod();
        }).start();
        
        new Thread(() -> {
            instance.nonStaticMethod();
        }).start();
        
        new Thread(() -> {
            instance.notSynchronizedMethod();
        }).start();                
        */
        
        /*
        TwoCll instance1 = new TwoCll();
        TwoCll instance2 = new TwoCll();

        new Thread(() -> {
            instance1.staticMethod1();
        }).start();
        
        new Thread(() -> {
            instance2.staticMethod2();
        }).start();
        */
        
        /*
        OllAndCll instance = new OllAndCll();               

        new Thread(() -> {
            instance.staticMethod();
        }).start();
        
        new Thread(() -> {
            instance.nonStaticMethod();
        }).start();
         */
    }

}
