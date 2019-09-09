package modern.challenge;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player(1, "Rafael Nadal");
        Player p2 = new Player(1, "Rafael Nadal");

        System.out.println(p1.equals(p2));

        System.out.println(Objects.equals(p1, p2));
        System.out.println("p1 hash code: " + p1.hashCode());
        System.out.println("p2 hash code: " + p2.hashCode());

        Set<Player> players = new HashSet<>();
        players.add(p1);
        players.add(p2);

        System.out.println("Set size: " + players.size());
        System.out.println("Set contains Rafael Nadal: " 
                + players.contains(new Player(1, "Rafael Nadal")));
    }
}
