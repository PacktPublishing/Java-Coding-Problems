package modern.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

public class SumRecursiveTask extends RecursiveTask<Integer> {

    private static final Logger logger = Logger.getLogger(SumRecursiveTask.class.getName());
    private static final int THRESHOLD = 10;

    private final List<Integer> worklist;

    public SumRecursiveTask(List<Integer> worklist) {
        this.worklist = worklist;
    }

    @Override
    protected Integer compute() {
        if (worklist.size() <= THRESHOLD) {
            return partialSum(worklist);
        }
        /*
        int size = worklist.size();

        List<Integer> worklistLeft = worklist.subList(0, (size + 1) / 2);
        List<Integer> worklistRight = worklist.subList((size + 1) / 2, size);

        SumRecursiveAction leftTask = new SumRecursiveAction(worklistLeft);
        leftTask.fork();

        SumRecursiveAction rightTask = new SumRecursiveAction(worklistRight);

        Integer secondTaskResult = rightTask.compute();
        Integer firstTaskResult = leftTask.join();

        return firstTaskResult + secondTaskResult;
        */
        
        return ForkJoinTask.invokeAll(createSubtasks())
                .stream()
                .mapToInt(ForkJoinTask::join)
                .sum();         
    }

    private List<SumRecursiveTask> createSubtasks() {

        List<SumRecursiveTask> subtasks = new ArrayList<>();

        int size = worklist.size();

        List<Integer> worklistLeft = worklist.subList(0, (size + 1) / 2);
        List<Integer> worklistRight = worklist.subList((size + 1) / 2, size);

        subtasks.add(new SumRecursiveTask(worklistLeft));
        subtasks.add(new SumRecursiveTask(worklistRight));

        return subtasks;
    }

    private Integer partialSum(List<Integer> worklist) {

        int sum = worklist.stream()
                .mapToInt(e -> e)
                .sum();

        logger.info(() -> "Partial sum: " + worklist + " = " 
                + sum + "\tThread: " + Thread.currentThread().getName());

        return sum;
    }
}
