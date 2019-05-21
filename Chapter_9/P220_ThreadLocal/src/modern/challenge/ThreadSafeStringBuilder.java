package modern.challenge;

import java.util.Random;
import java.util.logging.Logger;

public class ThreadSafeStringBuilder implements Runnable {

    private static final Logger logger = Logger.getLogger(ThreadSafeStringBuilder.class.getName());
    private static final Random rnd = new Random();

    private static final ThreadLocal<StringBuilder> threadLocal
            = ThreadLocal.<StringBuilder>withInitial(() -> {
                return new StringBuilder("Thread-safe ");
            });

    @Override
    public void run() {
        logger.info(() -> "-> " + Thread.currentThread().getName()
                + " [" + threadLocal.get() + "]");

        try {
            Thread.sleep(rnd.nextInt(2000));
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception: " + ex);
        }

        // threadLocal.set(new StringBuilder(Thread.currentThread().getName()));
        threadLocal.get().append(Thread.currentThread().getName());

        logger.info(() -> "-> " + Thread.currentThread().getName()
                + " [" + threadLocal.get() + "]");

        threadLocal.set(null);
        // threadLocal.remove();

        logger.info(() -> "-> " + Thread.currentThread().getName()
                + " [" + threadLocal.get() + "]");
    }

}
