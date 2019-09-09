package modern.challenge;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        Duration t = Duration.ofSeconds(65);
        System.out.println("Seconds part: " + t.toSecondsPart());
        
        Duration fromHours = Duration.ofHours(10);
        System.out.println("\nDuration from hours: " + fromHours);

        Duration fromMinutes = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println("Duration from minutes: " + fromMinutes);
        
        LocalDateTime localDateTime = LocalDateTime.of(2018, 3, 12, 4, 14, 20, 670);
        Duration fromLocalDateTime = Duration.ofMinutes(localDateTime.getMinute());
        System.out.println("Duration from minutes of a LocalDateTime: " + fromLocalDateTime);
        
        LocalTime localTime = LocalTime.of(4, 14, 20, 670);
        Duration fromLocalTime = Duration.ofNanos(localTime.getNano());
        System.out.println("Duration from nanos of a LocalTime: " + fromLocalTime);

        Duration durationFromString = Duration.parse("P2DT3H4M");
        System.out.println("Duration from String: " + durationFromString);

        Instant startInstant = Instant.parse("2015-11-03T12:11:30.00Z");
        Instant endInstant = Instant.parse("2016-12-06T15:17:10.00Z");
        Duration durationBetweenInstant = Duration.between(startInstant, endInstant);
        System.out.println("\nDuration between two Instant: " + durationBetweenInstant);
        System.out.println("Between " + startInstant + " and "
                + endInstant + " there are " + durationBetweenInstant.getSeconds() + " second(s)");
        System.out.println("Expressed in days and hours: "
                + durationBetweenInstant.toDays() + "d:" + durationBetweenInstant.toHoursPart() + "h");
        System.out.println("Expressed as d:h:m:s:n: " + durationToDHMSN(durationBetweenInstant));

        LocalDateTime startLocalDateTime = LocalDateTime.of(2018, 3, 12, 4, 14, 20, 670);
        LocalDateTime endLocalDateTime = LocalDateTime.of(2019, 7, 20, 6, 10, 10, 720);
        Duration durationBetweenLDT = Duration.between(startLocalDateTime, endLocalDateTime);
        System.out.println("\nDuration between two LocalDateTime: " + durationBetweenLDT);
        System.out.println("Between " + startLocalDateTime + " and "
                + endLocalDateTime + " there are " + durationBetweenLDT.getSeconds() + " second(s)");
        System.out.println("Expressed in days and hours: "
                + durationBetweenLDT.toDays() + "d:" + durationBetweenLDT.toHoursPart() + "h");
        System.out.println("Expressed as d:h:m:s:n: " + durationToDHMSN(durationBetweenLDT));

        LocalTime startLocalTime = LocalTime.of(4, 14, 20, 670);
        LocalTime endLocalTime = LocalTime.of(6, 10, 10, 720);
        Duration durationBetweenLT = Duration.between(startLocalTime, endLocalTime);
        System.out.println("\nDuration between two LocalTime: " + durationBetweenLT);
        System.out.println("Between " + startLocalTime + " and "
                + endLocalTime + " there are " + durationBetweenLT.getSeconds() + " second(s)");
        System.out.println("Expressed in hours and minutes: "
                + durationBetweenLT.toMinutes() + "m:" + durationBetweenLT.toSecondsPart() + "s");
        System.out.println("Expressed as d:h:m:s:n: " + durationToDHMSN(durationBetweenLT));

        System.out.println(startLocalTime + " is after "
                + endLocalTime + " ? " + durationBetweenLT.isNegative());

        Duration durationBetweenPlus5Hours = durationBetweenLT.plusHours(5);
        System.out.println("\nDuration between plus 5 hours: " + durationBetweenPlus5Hours);
        
        Duration d1 = Duration.ofMinutes(20);
        Duration d2 = Duration.ofHours(2);
        Duration d1d2 = d1.plus(d2);
        System.out.println(d1 + "+" + d2 + "=" + d1d2);
    }

    private static String durationToDHMSN(Duration duration) {

        if (duration == null) {
            // or throw IllegalArgumentException
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(duration.toDays())
                .append("d:")
                .append(duration.toHoursPart())
                .append("h:")
                .append(duration.toMinutesPart())
                .append("m:")
                .append(duration.toSecondsPart())
                .append("s:")
                .append(duration.toNanosPart())
                .append("n");

        return sb.toString();
    }
}
