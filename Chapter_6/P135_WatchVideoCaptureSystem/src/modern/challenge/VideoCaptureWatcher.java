package modern.challenge;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class VideoCaptureWatcher {

    public void watchVideoCaptureSystem(Path path) throws IOException, InterruptedException {

        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            System.out.println("Watching captures ...");
            
            //start an infinite loop           
            while (true) {

                //retrieve and remove the next watch key
                final WatchKey key = watchService.poll(11, TimeUnit.SECONDS);

                if (key == null) {
                    throw new IllegalStateException("The video capture system is jammed. Missed capture!");                    
                }

                //get list of events for the watch key
                for (WatchEvent<?> watchEvent : key.pollEvents()) {

                    //get the kind of event (create, modify, delete)
                    final Kind<?> kind = watchEvent.kind();

                    //handle OVERFLOW event
                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        continue;
                    }

                    if (kind == StandardWatchEventKinds.ENTRY_CREATE) {

                        //get the filename for the event
                        final WatchEvent<Path> watchEventPath = (WatchEvent<Path>) watchEvent;
                        final Path filename = watchEventPath.context();
                        final Path child = path.resolve(filename);

                        if (Files.probeContentType(child).equals("image/jpeg")) {

                            //print it out the video capture time
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
                            System.out.println("Video capture successfully at: " + dateFormat.format(new Date()));
                        } else {
                            Files.deleteIfExists(child);
                            throw new IllegalStateException("Unauthorized file type has been added!");  
                        }
                    }

                    //reset the key
                    boolean valid = key.reset();

                    //exit loop if the key is not valid (if the directory was deleted, per example)
                    if (!valid) {
                        break;
                    }
                }
            }
        }
    }
}
