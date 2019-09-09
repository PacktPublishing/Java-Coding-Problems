package modern.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        logger.info("Exemplify thenCompose():");
        CustomerAsyncs.fetchOrderTotal("Customer #1");

        logger.info("Exemplify thenCombine():");
        CustomerAsyncs.deliverParcel("#332");

        logger.info("Exemplify allOf():");
        List<String> invoices = Arrays.asList("#2334", "#122", "#55");

        CompletableFuture<String>[] cfInvoices = invoices.stream()
                .map(CustomerAsyncs::downloadInvoices)
                .toArray(CompletableFuture[]::new);

        CompletableFuture<Void> cfDownloaded = CompletableFuture.allOf(cfInvoices);

        cfDownloaded.get();
        logger.info("All invoices have been downloaded ...");

        List<String> results = cfDownloaded.thenApply(e -> {

            List<String> downloaded = new ArrayList<>();
            for (CompletableFuture<String> cfInvoice : cfInvoices) {
                downloaded.add(cfInvoice.join());
            }

            return downloaded;
        }).get();

        results.forEach(r -> logger.info(r));
        logger.info("Done!\n");

        logger.info("Exemplify anyOf():");
        List<String> customers = Arrays.asList("#1", "#4", "#2", "#7", "#6", "#5");

        CompletableFuture<String>[] cfCustomers = customers.stream()
                .map(CustomerAsyncs::raffle)
                .toArray(CompletableFuture[]::new);

        CompletableFuture<Object> cfWinner = CompletableFuture.anyOf(cfCustomers);

        Object winner = cfWinner.get();
        logger.info(() -> "Winner: " + winner);
    }

}
