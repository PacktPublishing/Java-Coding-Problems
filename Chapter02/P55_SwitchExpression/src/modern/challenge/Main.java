package modern.challenge;

public class Main {

    public enum PlayerTypes {
        TENNIS,
        FOOTBALL,
        SNOOKER,
        UNKNOWN
    }

    public static void main(String[] args) {
        // switch statement
        Player playerSwitchStatementUgly = createPlayerSwitchStatementUgly(PlayerTypes.TENNIS);
        Player playerSwitchStatementNice = createPlayerSwitchStatementNice(PlayerTypes.TENNIS);

        // switch expression
        Player playerSwitchExpression = createPlayerSwitchExpression(PlayerTypes.TENNIS);
        Player playerSwitchExpressionBreak = createPlayerSwitchExpressionBreak(PlayerTypes.TENNIS);
    }

    private static Player createPlayerSwitchStatementUgly(PlayerTypes playerType) {

        Player player = null;

        switch (playerType) {
            case TENNIS:
                player = new TennisPlayer();
                break;
            case FOOTBALL:
                player = new FootballPlayer();
                break;
            case SNOOKER:
                player = new SnookerPlayer();
                break;
            case UNKNOWN:
                throw new UnknownPlayerException("Player type is unknown");
            default:
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        }

        return player;
    }

    private static Player createPlayerSwitchStatementNice(PlayerTypes playerType) {
        switch (playerType) {
            case TENNIS:
                return new TennisPlayer();
            case FOOTBALL:
                return new FootballPlayer();
            case SNOOKER:
                return new SnookerPlayer();
            case UNKNOWN:
                throw new UnknownPlayerException("Player type is unknown");
            default:
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        }
    }

    private static Player createPlayerSwitchExpression(PlayerTypes playerType) {
        return switch (playerType) {
            case TENNIS->
                new TennisPlayer();
            case FOOTBALL->
                new FootballPlayer();
            case SNOOKER->
                new SnookerPlayer();
            case UNKNOWN->
                throw new UnknownPlayerException("Player type is unknown");
            // default is not mandatory
            default->
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        };
    }

    private static Player createPlayerSwitchExpressionBreak(PlayerTypes playerType) {
        return switch (playerType) {
            case TENNIS:
                break new TennisPlayer();
            case FOOTBALL:
                break new FootballPlayer();
            case SNOOKER:
                break new SnookerPlayer();
            case UNKNOWN:
                throw new UnknownPlayerException("Player type is unknown");
            // default is not mandatory
            default:
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        };
    }
}
