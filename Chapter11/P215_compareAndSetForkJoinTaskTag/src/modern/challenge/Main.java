package modern.challenge;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        Task taskA = new Task("Task-A", new Adder(1));
        Task taskB = new Task("Task-B", new Adder(2), taskA);
        Task taskC = new Task("Task-C", new Adder(3), taskA, taskB);
        Task taskD = new Task("Task-D", new Adder(4), taskA, taskB, taskC);

        logger.info(() -> "Result: " + forkJoinPool.invoke(taskD));
    }

    private static class Adder implements Callable {

        private static final AtomicInteger result = new AtomicInteger();
        private Integer nr;

        public Adder(Integer nr) {
            this.nr = nr;
        }

        @Override
        public Integer call() {

            logger.info(() -> "Adding number: " + nr
                    + " by thread:" + Thread.currentThread().getName());

            return result.addAndGet(nr);
        }
    }
    
    
}
