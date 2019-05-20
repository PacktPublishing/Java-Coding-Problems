package modern.challenge;

import java.util.ArrayList;
import java.util.List;

public class FireStation implements FireStationRegister {
    
    private final List<FireObserver> fireObservers = new ArrayList<>();
    
    @Override
    public void registerFireStation(FireObserver fo) {
        
        if (fo != null) {
            fireObservers.add(fo);
        }
    }
    
    @Override
    public void notifyFireStations(String address) {
                 
        if (address != null) {                       
            for (FireObserver fireObserver : fireObservers) {
                fireObserver.fire(address);
            }
        }
    }
    
}
