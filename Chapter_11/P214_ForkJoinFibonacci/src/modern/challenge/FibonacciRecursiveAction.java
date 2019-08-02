package modern.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

public class FibonacciRecursiveAction extends RecursiveAction {

    private static final Logger logger = Logger.getLogger(FibonacciRecursiveAction.class.getName());

    private static final long THRESHOLD = 5;
    private volatile long nr;

    public FibonacciRecursiveAction(long nr) {
        this.nr = nr;
    }

    @Override
    protected void compute() {

        final long n = nr;
        if (n <= THRESHOLD) {
            nr = fibonacci(n);
        } else {

            /*            
            FibonacciRecursiveAction fibonacciMinusOne = new FibonacciRecursiveAction(n - 1);
            FibonacciRecursiveAction fibonacciMinusTwo = new FibonacciRecursiveAction(n - 2);
            ForkJoinTask.invokeAll(fibonacciMinusOne, fibonacciMinusTwo);
            
            nr = fibonacciMinusOne.fibonacciNumber() + fibonacciMinusTwo.fibonacciNumber();
            */
             
            nr = ForkJoinTask.invokeAll(createSubtasks(n))
                    .stream()
                    .mapToLong(x -> x.fibonacciNumber())
                    .sum();            
        }
    }

    private List<FibonacciRecursiveAction> createSubtasks(long n) {

        List<FibonacciRecursiveAction> subtasks = new ArrayList<>();

        FibonacciRecursiveAction fibonacciMinusOne = new FibonacciRecursiveAction(n - 1);
        FibonacciRecursiveAction fibonacciMinusTwo = new FibonacciRecursiveAction(n - 2);

        subtasks.add(fibonacciMinusOne);
        subtasks.add(fibonacciMinusTwo);

        return subtasks;
    }

    private long fibonacci(long n) {

        logger.info(() -> "Number: " + n
                + " Thread: " + Thread.currentThread().getName());

        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public long fibonacciNumber() {
        return nr;
    }
}
