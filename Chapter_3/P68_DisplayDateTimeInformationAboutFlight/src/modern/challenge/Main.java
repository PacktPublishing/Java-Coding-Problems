package modern.challenge;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a, MMM dd, yyyy");
        DateTimeFormatter zoneFormatter = DateTimeFormatter.ofPattern("hh:mm a, MMM dd, yyyy Z VV");

        LocalDateTime ldt = LocalDateTime.of(2019, Month.FEBRUARY, 26, 16, 00);

        System.out.println("Perth LocalDateTime: " + ldt.format(formatter)
                + " | Scheduled Flight Time: 15 hours and 30 minutes\n");

        ZonedDateTime auPerthDepart = ldt.atZone(ZoneId.of("Australia/Perth"));
        ZonedDateTime euBucharestDepart = auPerthDepart.withZoneSameInstant(ZoneId.of("Europe/Bucharest"));

        ZonedDateTime auPerthArrive = auPerthDepart.plusHours(15).plusMinutes(30);
        ZonedDateTime euBucharestArrive = auPerthArrive.withZoneSameInstant(ZoneId.of("Europe/Bucharest"));

        OffsetDateTime utcAtDepart = auPerthDepart.withZoneSameInstant(ZoneId.of("UTC")).toOffsetDateTime();
        OffsetDateTime utcAtArrive = auPerthArrive.withZoneSameInstant(ZoneId.of("UTC")).toOffsetDateTime();

        System.out.println("UTC time at depart is: " + utcAtDepart.format(formatter));
        System.out.println("UTC time at arrive is: " + utcAtArrive.format(formatter));
        System.out.println("\nAt depart, in Perth is: " + auPerthDepart.format(zoneFormatter));
        System.out.println("At arrive, in Perth is: " + auPerthArrive.format(zoneFormatter));
        System.out.println("\nAt depart, in Bucharest is: " + euBucharestDepart.format(zoneFormatter));
        System.out.println("At arrive, in Bucharest is: " + euBucharestArrive.format(zoneFormatter));
        
    }

}
