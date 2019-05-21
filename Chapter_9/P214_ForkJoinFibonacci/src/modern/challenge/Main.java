package modern.challenge;

import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        int noOfProcessors = Runtime.getRuntime().availableProcessors();

        logger.info(() -> "Available processors: " + noOfProcessors);

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        int initialPoolSize = forkJoinPool.getPoolSize();
        int commonPoolParallelism = ForkJoinPool.getCommonPoolParallelism();
        logger.info(() -> "Common Pool parallelism :" + commonPoolParallelism);
        logger.info(() -> "Common Pool size before:" + initialPoolSize);

        FibonacciRecursiveAction fibonacciRecursiveAction = new FibonacciRecursiveAction(12);
        forkJoinPool.invoke(fibonacciRecursiveAction);
        logger.info(() -> "Fibonacci: " + fibonacciRecursiveAction.fibonacciNumber());

        int afterPoolSize = forkJoinPool.getPoolSize();
        logger.info(() -> "Common Pool size after  :" + afterPoolSize);
    }

}
