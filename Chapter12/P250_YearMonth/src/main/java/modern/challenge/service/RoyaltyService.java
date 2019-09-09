package modern.challenge.service;

import modern.challenge.entity.Royalty;
import java.time.YearMonth;
import modern.challenge.repository.RoyaltyRepository;
import org.springframework.stereotype.Service;

@Service
public class RoyaltyService {

    private final RoyaltyRepository royaltyRepository;

    public RoyaltyService(RoyaltyRepository royaltyRepository) {
        this.royaltyRepository = royaltyRepository;
    }

    public void newRoyalty() {

        Royalty royalty = new Royalty();

        royalty.setId(1L);
        royalty.setAmount(45.5f);
        royalty.setPayedOn(YearMonth.now());

        royaltyRepository.save(royalty);
    }
    
    public void fetchRoyalty() {
        Royalty royalty = royaltyRepository.findById(1L).orElseThrow();
        
        System.out.println("Royalty of $" + royalty.getAmount() 
                + " payed on " + royalty.getPayedOn());
    }
}
