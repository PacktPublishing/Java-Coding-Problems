package modern.challenge.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import modern.challenge.task.RecursiveActionRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
public class TransferService {

    private static final Logger logger = Logger.getLogger(TransferService.class.getName());

    // ForkJoinPool will start 1 thread for each available core   
    public static final ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

    private final ApplicationContext applicationContext;

    public TransferService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void transferFile(String fileName) throws IOException, InterruptedException {

        List<String> lines = Files.readAllLines(Path.of(fileName));

        logger.info(() -> "Start batching " + lines.size() + " lines ...");

        StopWatch watch = new StopWatch();
        watch.start();

        RecursiveActionRepository recursiveActionRepository
                = applicationContext.getBean(RecursiveActionRepository.class, new ArrayList<>(lines));
        forkJoinPool.invoke(recursiveActionRepository);

        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        watch.stop();

        logger.info(() -> "End batching. \n Total time: " + watch.getTotalTimeMillis()
                + "ms (" + watch.getTotalTimeSeconds() + " s)");
    }

}