package modern.challenge;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        // get an Instant
        Instant timestamp = Instant.now();
        System.out.println("Timestamp: " + timestamp);

        // String to Instant
        Instant timestampFromString = Instant.parse("2019-02-24T14:31:33.197021300Z");
        System.out.println("\nTimestamp from string: " + timestampFromString);

        // Plus two hours
        Instant twoHourLater = Instant.now().plus(2, ChronoUnit.HOURS);
        System.out.println("\nTwo hours later: " + twoHourLater);

        // Minus 10 minutes
        Instant tenMinutesEarlier = Instant.now().minus(10, ChronoUnit.MINUTES);
        System.out.println("Ten minutes earlier: " + tenMinutesEarlier);

        // check if one Instant is after another Instant
        Instant timestamp1 = Instant.now();
        Instant timestamp2 = timestamp1.plusSeconds(10);
        boolean isAfter = timestamp1.isAfter(timestamp2);
        System.out.println("\n" + timestamp1 + " is " + (isAfter ? "" : "not ") + "after " + timestamp2);

        // check if one Instant is before another Instant
        boolean isBefore = timestamp1.isBefore(timestamp2);
        System.out.println(timestamp1 + " is " + (isBefore ? "" : "not ") + "before " + timestamp2);

        // difference between two Instants
        long difference = timestamp1.until(timestamp2, ChronoUnit.SECONDS);
        System.out.println("Between " + timestamp1 + " and " + timestamp2 + " there are " + difference + " seconds");

        // convert Instant to LocalDateTime
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
        System.out.println("\nInstant to LocaleDateTime: " + ldt);
        // convert LocalDateTime to Instant
        Instant instantLDT = LocalDateTime.now().toInstant(ZoneOffset.UTC);
        System.out.println("LocaleDateTime to Instant: " + instantLDT);

        // convert Instant to ZonedDateTime
        ZonedDateTime zdt = Instant.now().atZone(ZoneId.of("Europe/Paris"));
        System.out.println("Instant to ZonedDateTime: " + zdt + " (offset: " + zdt.getOffset() + ")");
        // convert ZonedDateTime to Instant
        Instant instantZDT = LocalDateTime.now().atZone(ZoneId.of("Europe/Paris")).toInstant();
        System.out.println("ZonedDateTime to Instant: " + instantZDT);

        // convert Instant to OffsetDateTime
        OffsetDateTime odt = Instant.now().atOffset(ZoneOffset.of("+02:00"));
        System.out.println("Instant to OffsetDateTime: " + odt + " (offset: " + odt.getOffset() + ")");
        // convert OffsetDateTime to Instnat
        Instant instantODT = LocalDateTime.now().atOffset(ZoneOffset.of("+02:00")).toInstant();
        System.out.println("OffsetDateTime to Instant: " + instantODT);
    }
}
