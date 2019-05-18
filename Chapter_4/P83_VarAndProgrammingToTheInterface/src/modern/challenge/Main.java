package modern.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
                
        var playerList = new ArrayList<String>();      // inferred as ArrayList<String>         
        var playerSet = new HashSet<String>();         // inferred as HashSet<String>
        var playerMap = new HashMap<String, String>(); // inferred as HashMap<String, String>                
    }
    
}
