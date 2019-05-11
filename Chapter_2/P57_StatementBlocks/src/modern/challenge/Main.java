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
                break new TennisPlayer();
            }
            case FOOTBALL-> {
                System.out.println("Creating a FootballPlayer ...");
                break new FootballPlayer();
            }
            case SNOOKER-> {
                System.out.println("Creating a SnookerPlayer ...");
                break new SnookerPlayer();
            }
            default->
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        };
    }
}
