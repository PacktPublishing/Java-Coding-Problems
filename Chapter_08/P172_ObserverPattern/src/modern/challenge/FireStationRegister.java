package modern.challenge;

public interface FireStationRegister {
    
    void registerFireStation(FireObserver fo);
    void notifyFireStations(String address);    
}
