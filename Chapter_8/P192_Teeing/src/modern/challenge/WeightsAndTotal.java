package modern.challenge;

import java.util.List;

public class WeightsAndTotal {

    private final int totalWeight;
    private final List<Integer> weights;

    public WeightsAndTotal(int totalWeight, List<Integer> weights) {
        this.totalWeight = totalWeight;
        this.weights = weights;
    }

    @Override
    public String toString() {
        return "WeightsAndTotal{" + "totalWeight=" + totalWeight + ", weights=" + weights + '}';
    }
}
