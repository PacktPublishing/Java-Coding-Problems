package modern.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        Random rnd = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add(1 + rnd.nextInt(10));
        }

        SumCountedCompleter sumCountedCompleter = new SumCountedCompleter(null, list);
        forkJoinPool.invoke(sumCountedCompleter);
        logger.info(() -> "Done! Result: " + sumCountedCompleter.getRawResult());

    }

}
