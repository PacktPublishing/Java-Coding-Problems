package modern.challenge;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Before Java 7 in Project Coin
        // explicitly specifying generic class's instantiation parameter type
        List<String> players1 = new ArrayList<String>();

        // From Java 7 onwards using Project Coin
        // inferring generic class's instantiation parameter type 
        List<String> players2 = new ArrayList<>();

        // Avoid
        var playerList1 = new ArrayList<>(); // is inferred as ArrayList<Object>

        // Prefer
        var playerList2 = new ArrayList<String>(); // inferred as ArrayList<String>
    }

}
