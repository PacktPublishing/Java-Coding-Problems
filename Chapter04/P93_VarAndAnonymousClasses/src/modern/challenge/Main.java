package modern.challenge;

public class Main {

    public static void main(String[] args) {

        // Prefer
        var weighter = new Weighter() {
            @Override
            public int getWeight(Player player) {
                return 85;
            }
        };

        Player player = new Player();
        int weight = weighter.getWeight(player);

        System.out.println("Player weight: " + weight);
    }
}
