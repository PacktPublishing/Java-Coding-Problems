package modern.challenge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

public class Main {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(2019, 2, 28);

        System.out.println("LocalDate start of the day:");
        LocalDateTime ldDayStart1 = localDate.atStartOfDay();
        ZonedDateTime ldDayStartZone1 = localDate.atStartOfDay(ZoneId.of("Australia/Perth"));
        System.out.println("Start of the day without time zone via atStartOfDay(): " + ldDayStart1);
        System.out.println("Start of the day with time zone, Australia/Perth via atStartOfDay(): " + ldDayStartZone1);

        LocalDateTime ldDayStart2 = LocalDateTime.of(localDate, LocalTime.MIN);
        ZonedDateTime ldDayStartZone2 = LocalDateTime
                .of(localDate, LocalTime.MIN).atZone(ZoneId.of("Australia/Perth"));
        System.out.println("\nStart of the day without time zone via of(): " + ldDayStart2);
        System.out.println("Start of the day with time zone, Australia/Perth via of(): " + ldDayStartZone2);

        System.out.println("\n\nLocalDate end of the day:");
        LocalDateTime ldDayEnd1 = localDate.atTime(LocalTime.MAX);
        ZonedDateTime ldDayEndZone1 = localDate.atTime(LocalTime.MAX)
                .atZone(ZoneId.of("Australia/Perth"));
        System.out.println("End of the day without time zone via atTime(): " + ldDayEnd1);
        System.out.println("End of the day with time zone, Australia/Perth via atTime(): " + ldDayEndZone1);

        LocalDateTime ldDayEnd2 = LocalTime.MAX.atDate(localDate);
        ZonedDateTime ldDayEndZone2 = LocalTime.MAX.atDate(localDate)
                .atZone(ZoneId.of("Australia/Perth"));
        System.out.println("\nEnd of the day without time zone via atDate(): " + ldDayEnd2);
        System.out.println("End of the day with time zone, Australia/Perth via atDate(): " + ldDayEndZone2);

        System.out.println("\n\nLocalDateTime start of the day:");
        LocalDateTime localDateTime = LocalDateTime.of(2019, 2, 28, 18, 0, 0);
        LocalDateTime ldtDayStart = localDateTime.with(ChronoField.NANO_OF_DAY, LocalTime.MIN.toNanoOfDay());
        //LocalDateTime ldtDayStart = localDateTime.with(ChronoField.HOUR_OF_DAY, 0);
        ZonedDateTime ldtDayStartZone = localDateTime
                .with(ChronoField.NANO_OF_DAY, LocalTime.MIN.toNanoOfDay())
                .atZone(ZoneId.of("Australia/Perth"));
        System.out.println("\nStart of the day without time zone via with(): " + ldtDayStart);
        System.out.println("Start of the day with time zone, Australia/Perth via with(): " + ldtDayStartZone);

        LocalDateTime ldtDayEnd = localDateTime.with(ChronoField.NANO_OF_DAY, LocalTime.MAX.toNanoOfDay());
        // LocalDateTime ldtDayEnd = localDateTime.with(ChronoField.NANO_OF_DAY, 86399999999999L);
        ZonedDateTime ldtDayEndZone = localDateTime
                .with(ChronoField.NANO_OF_DAY, LocalTime.MAX.toNanoOfDay())
                .atZone(ZoneId.of("Australia/Perth"));
        System.out.println("\nEnd of the day without time zone via with(): " + ldtDayEnd);
        System.out.println("End of the day with time zone, Australia/Perth via with(): " + ldtDayEndZone);

        System.out.println("\n\nUTC start and end of the day:");
        ZonedDateTime zdt = ZonedDateTime.now(ZoneOffset.UTC);
        ZonedDateTime dayStartZdt = zdt.toLocalDate().atStartOfDay(zdt.getZone());
        ZonedDateTime dayEndZdt = zdt.toLocalDate().atTime(LocalTime.MAX).atZone(zdt.getZone());

        System.out.println("UTC time: " + zdt);
        System.out.println("Start day with UTC: " + dayStartZdt);
        System.out.println("End day with UTC: " + dayEndZdt);
    }

}
