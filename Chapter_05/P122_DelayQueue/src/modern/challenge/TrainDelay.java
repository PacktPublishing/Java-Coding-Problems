package modern.challenge;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TrainDelay implements Delayed {

    private final String id;
    private final String to;
    private final long departAt;

    public TrainDelay(String id, String to, long delayOfDeparture) {
        this.id = id;
        this.to = to;
        this.departAt = System.currentTimeMillis() + delayOfDeparture;
    }

    // when we try to consume a train 
    // this method decides if it is expired or not
    @Override
    public long getDelay(TimeUnit tu) {
        long diff = departAt - System.currentTimeMillis();
        return tu.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed t) {
        return Long.compare(departAt, ((TrainDelay) t).departAt);
    }

    @Override
    public String toString() {
        return "TrainDelay{" + "id=" + id + ", to=" + to + ", departAt=" + departAt + '}';
    }
}
