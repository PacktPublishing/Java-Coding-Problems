package modern.challenge;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        logger.info("Printing customer order ...");
        CustomerAsyncs.printOrder();

        logger.info("Fetch order summary ...");
        CustomerAsyncs.fetchOrderSummary();

        logger.info("Fetch order summary (Executor) ...");
        CustomerAsyncs.fetchOrderSummaryExecutor();

        logger.info("Fetch order, compute total and sign ...");
        CustomerAsyncs.fetchInvoiceTotalSign();

        logger.info("Fetch and print order ...");
        CustomerAsyncs.fetchAndPrintOrder();

        logger.info("Deliver order and notify customer ...");
        CustomerAsyncs.deliverOrderNotifyCustomer();

        logger.info("exceptionally() ...");
        CustomerAsyncs.fetchOrderTotalException();
        
        logger.info("Chain exceptionally() ...");     
        CustomerAsyncs.fetchInvoiceTotalSignChainOfException();
        
        logger.info("Global exceptionally() ...");     
        CustomerAsyncs.fetchInvoiceTotalSignGlobalException();
        
        logger.info("exceptionallyCompose() ...");     
        CustomerAsyncs.printInvoiceException();

        logger.info("exceptionallyAsync() ...");
        CustomerAsyncs.fetchOrderTotalExceptionAsync();

        logger.info("exceptionallyHandle() ...");
        CustomerAsyncs.fetchOrderTotalHandle();

        logger.info("Computing taxes ...");
        CompletableFuture<Integer> cfTaxes = CustomerAsyncs.taxes();

        while (!cfTaxes.isDone()) {
            logger.info("Still computing ...");
        }

        int result = cfTaxes.get();
        logger.info(() -> "Result: " + result);
    }

}
