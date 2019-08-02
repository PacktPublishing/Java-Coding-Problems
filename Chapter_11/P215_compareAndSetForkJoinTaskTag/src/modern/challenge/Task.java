package modern.challenge;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

public class Task<Integer> extends RecursiveTask<Integer> {

    private static final Logger logger = Logger.getLogger(Task.class.getName());

    private static final short UNVISITED = 0;
    private static final short VISITED = 1;

    private Set<Task<Integer>> dependencies = new HashSet<>();

    private final String name;
    private final Callable<Integer> callable;

    @SuppressWarnings("unchecked")
    public Task(String name, Callable<Integer> callable, Task<Integer>... dependencies) {
        this.name = name;
        this.callable = callable;
        this.dependencies = Set.of(dependencies);
    }

    @Override
    protected Integer compute() {

        dependencies.stream()
                .filter((task) -> (task.updateTaskAsVisited()))
                .forEachOrdered((task) -> {
                    logger.info(() -> "Tagged: " + task + "(" + task.getForkJoinTaskTag() + ")");
                    task.fork();
                });

        for (Task task : dependencies) {
            task.join();
        }

        try {
            return callable.call();
        } catch (Exception ex) {
            logger.severe(() -> "Exception: " + ex);
        }

        return null;
    }

    public boolean updateTaskAsVisited() {
        return compareAndSetForkJoinTaskTag(UNVISITED, VISITED);
    }

    @Override
    public String toString() {
        return name;
    }
}
