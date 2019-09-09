package modern.challenge;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIncrementator implements Runnable {

    public static AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
