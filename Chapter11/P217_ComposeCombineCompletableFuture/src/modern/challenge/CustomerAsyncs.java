package modern.challenge;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public final class CustomerAsyncs {

    private static final Logger logger = Logger.getLogger(CustomerAsyncs.class.getName());

    private CustomerAsyncs() {
        throw new AssertionError("Cannot be instantiated");
    }

    private static CompletableFuture<String> fetchOrder(String customerId) {

        return CompletableFuture.supplyAsync(() -> {
            return "Order of " + customerId;
        });
    }

    private static CompletableFuture<Integer> computeTotal(String order) {

        return CompletableFuture.supplyAsync(() -> {
            return order.length() + new Random().nextInt(1000);
        });
    }

    private static CompletableFuture<String> packProducts(String order) {

        return CompletableFuture.supplyAsync(() -> {
            return "Order: " + order + " | Product 1, Product 2, Product 3, ... ";
        });
    }

    public static void fetchOrderTotal(String customerId)
            throws InterruptedException, ExecutionException {

        /*
        CompletableFuture<CompletableFuture<Integer>> cfTotal
                = fetchOrder(customerId).thenApply(o -> computeTotal(o));

        int total = cfTotal.get().get();
        */
        
        CompletableFuture<Integer> cfTotal
                = fetchOrder(customerId).thenCompose(o -> computeTotal(o));

        int total = cfTotal.get();
        logger.info(() -> "Total: " + total + "\n");
    }

    public static void deliverParcel(String order)
            throws InterruptedException, ExecutionException {
        CompletableFuture<String> cfParcel = computeTotal(order)
                .thenCombine(packProducts(order), (total, products) -> {
                    return "Parcel-[" + products + " Invoice: $" + total + "]";
                });

        String parcel = cfParcel.get();
        logger.info(() -> "Delivering: " + parcel + "\n");
    }

    public static CompletableFuture<String> downloadInvoices(String invoice) {
        return CompletableFuture.supplyAsync(() -> {
            logger.info(() -> "Downloading invoice: " + invoice);
            return "Downloaded invoice: " + invoice;
        });
    }

    public static CompletableFuture<String> raffle(String customerId) {
        return CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(new Random().nextInt(5000));
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                logger.severe(() -> "Exception: " + ex);
            }

            return customerId;
        });
    }
}
