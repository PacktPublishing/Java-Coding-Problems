package modern.challenge;

public class Main {

    public enum PlayerTypes {
        TENNIS,
        FOOTBALL,
        SNOOKER
    }

    public static void main(String[] args) {
        Player player = createPlayer(PlayerTypes.SNOOKER);        
    }

    private static Player createPlayer(PlayerTypes playerType) {
        return switch (playerType) {
            case TENNIS-> {
                System.out.println("Creating a TennisPlayer ...");
                yield new TennisPlayer();
            }
            case FOOTBALL-> {
                System.out.println("Creating a FootballPlayer ...");
                yield new FootballPlayer();
            }
            case SNOOKER-> {
                System.out.println("Creating a SnookerPlayer ...");
                yield new SnookerPlayer();
            }
            default->
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        };
    }
}
