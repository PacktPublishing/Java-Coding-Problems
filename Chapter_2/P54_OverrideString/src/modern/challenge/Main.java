package modern.challenge;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) {
                
        User user = new User("sparg21", "kkd454ffc", "Leopold", "Mark", "markl@yahoo.com");
        
        System.out.println(user);
        logger.log(Level.INFO, "This user rocks: {0}", user);
    }    
    
}
