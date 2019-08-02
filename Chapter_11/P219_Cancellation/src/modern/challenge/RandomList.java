package modern.challenge;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class RandomList implements Runnable {

    private volatile boolean cancelled;

    private final List<Integer> randoms = new CopyOnWriteArrayList<>();
    private final Random rnd = new Random();    

    @Override
    public void run() {
        while (!cancelled) {
            randoms.add(rnd.nextInt(100));
        }
    }

    public void cancel() {        
        cancelled = true;
    }

    public List<Integer> getRandoms() {
        return randoms;
    }
}
