package modern.challenge;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // explicit type
        System.out.println("Explicit type:");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }

        // using var
        System.out.println("\n\nLVTI:");
        for (var i = 0; i < 5; i++) { // 'i' is inferred of type int
            System.out.print(i + " ");
        }

        List<Player> players = List.of(new Player(), new Player(), new Player());

        System.out.println("\n\nExplicit type:");
        for (Player player : players) {
            System.out.print(player + " ");
        }

        System.out.println("\n\nLVTI:");
        for (var player : players) { // 'player' is inferred of type Player
            System.out.print(player + " ");
        }               
    }
}
