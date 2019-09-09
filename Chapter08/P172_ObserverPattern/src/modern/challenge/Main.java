package modern.challenge;

public class Main {

    public static void main(String[] args) {

        FireStation fireStation = new FireStation();
        // fireStation.registerFireStation(new BrookhavenFireStation());
        // fireStation.registerFireStation(new DecaturFireStation());
        // fireStation.registerFireStation(new ViningsFireStation());

        fireStation.registerFireStation((String address) -> {
            if (address.contains("Brookhaven")) {
                System.out.println("Brookhaven fire station will go to this fire");
            }
        });

        fireStation.registerFireStation((String address) -> {
            if (address.contains("Vinings")) {
                System.out.println("Vinings fire station will go to this fire");
            }
        });

        fireStation.registerFireStation((String address) -> {
            if (address.contains("Decatur")) {
                System.out.println("Decatur fire station will go to this fire");
            }
        });

        fireStation.notifyFireStations(
                "Fire alert: WestHaven At Vinings 5901 Suffex Green Ln Atlanta");
    }

}
