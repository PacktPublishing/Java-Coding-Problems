package modern.challenge;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
              "[%1$tT] [%4$-7s] %5$s %n");
        
        AssemblyLine.startAssemblyLine(new ConcurrentLinkedQueue<>());
        Thread.sleep(10 * 1000);
        Queue<String> remainingTasks = AssemblyLine.stopAssemblyLine();
        
        Thread.sleep(2000);

        System.out.println("\nStarting assembly line again ...");
        
        AssemblyLine.startAssemblyLine(new ConcurrentLinkedQueue<>(remainingTasks));
        Thread.sleep(60 * 100);
        AssemblyLine.stopAssemblyLine();
    }

}
