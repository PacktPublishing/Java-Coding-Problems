package modern.challenge;

public class HugeMelonPredicate implements MelonPredicate {

    @Override
    public boolean test(Melon melon) {                       
        return melon.getWeight() > 5000;
    }
    
}
