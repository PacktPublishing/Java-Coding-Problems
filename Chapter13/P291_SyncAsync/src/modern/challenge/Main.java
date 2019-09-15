package modern.challenge;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
        
    public static void main(String[] args) 
            throws IOException, InterruptedException, ExecutionException, URISyntaxException {

       // trigger a sync request
       // logger.info("Trigger a sync request...");
       // SyncRequest sync = new SyncRequest();
       // sync.triggerSyncRequest();
       
       // Trigger async requests
       // logger.info("Trigger async request 1...");
       // AsyncOneRequest1 async1 = new AsyncOneRequest1();
       // async1.triggerOneAyncRequest();
       
       // logger.info("Trigger async request 2...");
       // AsyncOneRequest2 async2 = new AsyncOneRequest2();
       // async2.triggerOneAyncRequest();
       
        // logger.info("Wait all responses and display bodies on console ...");
        // WaitAllResponsesDisplayBodies responses = new WaitAllResponsesDisplayBodies();
        // responses.waitAllResponses();
       
        logger.info("Wait all responses and fetch bodies in a List ...");
        WaitAllResponsesFetchBodiesInList responses = new WaitAllResponsesFetchBodiesInList();
        responses.waitAllResponses();
    }

}
