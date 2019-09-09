package modern.challenge;

public class Main {

    public enum PlayerTypes {
        TENNIS,
        FOOTBALL,
        SNOOKER,
        GOLF,
        VOLLEY
    }

    public static void main(String[] args) {        
        SportType sportType = fetchSportTypeByPlayerType(PlayerTypes.VOLLEY);
        System.out.println("Sport type: " + sportType);
    }

    private static SportType fetchSportTypeByPlayerType(PlayerTypes playerType) {
        return switch (playerType) {
            case TENNIS, GOLF, SNOOKER->
                new Individual();
            case FOOTBALL, VOLLEY->
                new Team();            
        };
    }

}
