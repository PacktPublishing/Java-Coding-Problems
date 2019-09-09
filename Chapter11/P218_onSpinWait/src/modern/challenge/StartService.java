package modern.challenge;

public class StartService implements Runnable {

    private volatile boolean serviceAvailable;

    @Override
    public void run() {

        System.out.println("Wait for service to be available ...");
        while (!serviceAvailable) {
            // Use a spin-wait hint (ask the processor to optimize the resource)
            // This should perform better if the underlying hardware supports the hint
            Thread.onSpinWait();
        }

        serviceRun();
    }

    public void serviceRun() {
        System.out.println("Service is running ...");
    }

    public void setServiceAvailable(boolean serviceAvailable) {
        this.serviceAvailable = serviceAvailable;
    }

}
