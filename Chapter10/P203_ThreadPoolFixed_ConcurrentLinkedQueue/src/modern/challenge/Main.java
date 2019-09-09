package modern.challenge;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        AssemblyLine.startAssemblyLine();
        Thread.sleep(60 * 100);
        AssemblyLine.stopAssemblyLine();

        Thread.sleep(2000);

        System.out.println("\nStarting assembly line again ...");

        AssemblyLine.startAssemblyLine();
        Thread.sleep(60 * 100);
        AssemblyLine.stopAssemblyLine();
    }

}
