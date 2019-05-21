package modern.challenge;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public final class CustomerAsyncs {

    private static final Logger logger = Logger.getLogger(CustomerAsyncs.class.getName());

    private CustomerAsyncs() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void printOrder()
            throws InterruptedException, ExecutionException {

        CompletableFuture<Void> cfPrintOrder = CompletableFuture.runAsync(() -> {
            try {
                logger.info(() -> "Order is printed by: " + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        cfPrintOrder.get(); // wait for order to be printed, this is blocking
        logger.info("Customer order was printed ...\n");
    }

    public static void fetchOrderSummary()
            throws InterruptedException, ExecutionException {

        CompletableFuture<String> cfOrderSummary = CompletableFuture.supplyAsync(() -> {
            try {
                logger.info(() -> "Fetch order summary by: " + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            return "Order Summary #93443";
        });

        String summary = cfOrderSummary.get(); // wait for summary to be available, this is blocking
        logger.info(() -> "Order summary: " + summary + "\n");
    }

    public static void fetchOrderSummaryExecutor()
            throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture<String> cfOrderSummary = CompletableFuture.supplyAsync(() -> {
            try {
                logger.info(() -> "Fetch order summary by: " + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            return "Order Summary #91022";
        }, executor);

        String summary = cfOrderSummary.get(); // wait for summary to be available, this is blocking
        logger.info(() -> "Order summary: " + summary + "\n");

        executor.shutdownNow();
    }

    public static void fetchInvoiceTotalSign()
            throws InterruptedException, ExecutionException {

        CompletableFuture<String> cfFetchInvoice = CompletableFuture.supplyAsync(() -> {
            try {
                logger.info(() -> "Fetch invoice by: " + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            return "Invoice #3344";
        });

        CompletableFuture<String> cfTotalSign = cfFetchInvoice
                .thenApply(o -> o + " Total: $145")
                .thenApply(o -> o + " Signed");

        String result = cfTotalSign.get();
        logger.info(() -> "Invoice: " + result + "\n");
    }

    public static void fetchAndPrintOrder()
            throws InterruptedException, ExecutionException {

        CompletableFuture<Void> cfFetchAndPrintOrder = CompletableFuture.supplyAsync(() -> {
            try {
                logger.info(() -> "Fetch order by: " + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            return "Order #1024";
        }).thenAccept(
                o -> logger.info(() -> "Printing order "
                + o + " by: " + Thread.currentThread().getName()));

        cfFetchAndPrintOrder.get();
        logger.info("Order was fetched and printed \n");
    }

    public static void deliverOrderNotifyCustomer()
            throws InterruptedException, ExecutionException {

        CompletableFuture<Void> cfDeliverOrder = CompletableFuture.runAsync(() -> {
            try {
                logger.info(() -> "Order was delivered by: " + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        CompletableFuture<Void> cfNotifyCustomer = cfDeliverOrder.thenRun(() -> logger.info(()
                -> "Dear customer, your order has been delivered today by: "
                + Thread.currentThread().getName()));

        cfNotifyCustomer.get();
        logger.info(() -> "Order was delivered and customer was notified \n");
    }

    public static void fetchOrderTotalException()
            throws InterruptedException, ExecutionException {

        CompletableFuture<Integer> cfTotalOrder = CompletableFuture.supplyAsync(() -> {

            logger.info(() -> "Compute total: " + Thread.currentThread().getName());

            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Invoice service is not responding");
            }

            return 1000;

        }).exceptionally(ex -> {
            logger.severe(() -> "Exception: " + ex
                    + " Thread: " + Thread.currentThread().getName());

            return 0;
        });

        int result = cfTotalOrder.get();
        logger.info(() -> "Total: " + result + "\n");
    }

    public static void fetchInvoiceTotalSignChainOfException()
            throws InterruptedException, ExecutionException {

        CompletableFuture<String> cfFetchInvoice = CompletableFuture.supplyAsync(() -> {

            logger.info(() -> "Fetch invoice by: " + Thread.currentThread().getName());

            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Invoice service is not responding");
            }

            return "Invoice #3344";
        }).exceptionally(ex -> {
            logger.severe(() -> "Exception: " + ex
                    + " Thread: " + Thread.currentThread().getName());

            return "[Invoice-Exception]";
        }).thenApply(o -> {
            logger.info(() -> "Compute total by: " + Thread.currentThread().getName());

            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Total service is not responding");
            }
            return o + " Total: $145";
        }).exceptionally(ex -> {
            logger.severe(() -> "Exception: " + ex
                    + " Thread: " + Thread.currentThread().getName());

            return "[Total-Exception]";
        }).thenApply(o -> {
            logger.info(() -> "Sign invoice by: " + Thread.currentThread().getName());

            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Signing service is not responding");
            }

            return o + " Signed";
        }).exceptionally(ex -> {
            logger.severe(() -> "Exception: " + ex
                    + " Thread: " + Thread.currentThread().getName());

            return "[Sign-Exception]";
        });

        String result = cfFetchInvoice.get();
        logger.info(() -> "Result: " + result + "\n");
    }

    public static void fetchInvoiceTotalSignGlobalException()
            throws InterruptedException, ExecutionException {

        CompletableFuture<String> cfFetchInvoice = CompletableFuture.supplyAsync(() -> {

            logger.info(() -> "Fetch invoice by: " + Thread.currentThread().getName());

            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Invoice service is not responding");
            }

            return "Invoice #3344";
        }).thenApply(o -> {
            logger.info(() -> "Compute total by: " + Thread.currentThread().getName());

            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Total service is not responding");
            }
            return o + " Total: $145";
        }).thenApply(o -> {
            logger.info(() -> "Sign invoice by: " + Thread.currentThread().getName());

            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Signing service is not responding");
            }

            return o + " Signed";
        }).exceptionally(ex -> {
            logger.severe(() -> "Exception: " + ex
                    + " Thread: " + Thread.currentThread().getName());

            return "[No-Invoice-Exception]";
        });

        String result = cfFetchInvoice.get();
        logger.info(() -> "Result: " + result + "\n");
    }

    public static void printInvoiceException()
            throws InterruptedException, ExecutionException {

        CompletableFuture<String> cfServicePrinterIp = CompletableFuture.supplyAsync(() -> {

            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Printing service is not responding");
            }

            return "192.168.1.0";
        });

        CompletableFuture<String> cfBackupPrinterIp = CompletableFuture.supplyAsync(() -> {
            return "192.192.192.192";
        });

        CompletableFuture<Void> printInvoice = cfServicePrinterIp
                .exceptionallyCompose(th -> {
                    logger.severe(() -> "Exception: " + th
                            + " Thread: " + Thread.currentThread().getName());
                    return cfBackupPrinterIp;
                }).thenAccept((ip) -> logger.info(() -> "Printing at: " + ip));

        printInvoice.get();
        logger.info(() -> "Printing done ... \n");
    }

    public static void fetchOrderTotalExceptionAsync()
            throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture<Integer> totalOrder = CompletableFuture.supplyAsync(() -> {

            logger.info(() -> "Compute total by: " + Thread.currentThread().getName());

            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Computing service is not responding");
            }

            return 1000;

        }).exceptionallyAsync(ex -> {
            logger.severe(() -> "Exception: " + ex
                    + " Thread: " + Thread.currentThread().getName());

            return 0;
        }, executor);

        int result = totalOrder.get();
        logger.info(() -> "Total: " + result + "\n");

        executor.shutdownNow();
    }

    public static void fetchOrderTotalHandle()
            throws InterruptedException, ExecutionException {

        CompletableFuture<Integer> totalOrder = CompletableFuture.supplyAsync(() -> {

            logger.info(() -> "Compute total by: " + Thread.currentThread().getName());

            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Computing service is not responding");
            }

            return 1000;

        }).handle((res, ex) -> {
            if (ex != null) {
                logger.severe(() -> "Exception: " + ex
                        + " Thread: " + Thread.currentThread().getName());

                return 0;
            }

            if (res != null) {
                int vat = res * 24 / 100;
                res += vat;
            }

            return res;
        });

        int result = totalOrder.get();
        logger.info(() -> "Total: " + result + "\n");
    }

    public static CompletableFuture<Integer> taxes() {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        new Thread(() -> {
            try {
                int result = new Random().nextInt(100);
                Thread.sleep(10);
                completableFuture.complete(result);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }).start();

        return completableFuture;
    }
}
