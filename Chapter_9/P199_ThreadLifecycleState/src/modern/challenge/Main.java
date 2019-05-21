package modern.challenge;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        NewThread nt = new NewThread();
        nt.newThread();
        
        Thread.sleep(5000);
        
        RunnableThread rt = new RunnableThread();
        rt.runnableThread();
        
        Thread.sleep(5000);
        
        WaitingThread wt = new WaitingThread();
        wt.waitingThread();
        
        Thread.sleep(5000);
        
        TimedWaitingThread twt = new TimedWaitingThread();
        twt.timedWaitingThread();
        
        Thread.sleep(5000);
        
        TerminatedThread tt = new TerminatedThread();
        tt.terminatedThread();
        
        BlockedThread bt = new BlockedThread();
        bt.blockedThread();               
    }
    
}
