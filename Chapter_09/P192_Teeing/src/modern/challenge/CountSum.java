package modern.challenge;

public class CountSum {
    
    private final Long count;
    private final Integer sum;

    public CountSum(Long count, Integer sum) {
        this.count = count;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "CountSum{" + "count=" + count + ", sum=" + sum + '}';
    }        
    
}
