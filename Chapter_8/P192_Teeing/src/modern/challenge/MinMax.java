package modern.challenge;

public class MinMax {

    private final Integer min;
    private final Integer max;

    public MinMax(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return "MinMax{" + "min=" + min + ", max=" + max + '}';
    }        
}
