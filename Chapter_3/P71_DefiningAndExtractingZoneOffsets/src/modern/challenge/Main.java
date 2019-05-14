package modern.challenge;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("Before JDK 8:");
        TimeZone timeZoneAP = TimeZone.getTimeZone("Australia/Perth");
        int offsetFromTimeZone = timeZoneAP.getRawOffset();
        String userFriendlyOffsetTimeZone = formatOffset(offsetFromTimeZone);
        System.out.println("Offset from TimeZone (Australia/Perth): " + userFriendlyOffsetTimeZone);

        Calendar calendar = Calendar.getInstance();
        // Summer time in Bucharest: 
        // Sunday, 31 March 2019, 1h forward -  Sunday, 27 October 2019, 1 hour backward
        // month 6 is a summer month in Bucharest, so you will get +03:00
        // month 11 is a winter month in Bucharest, so you will get +02:00
        calendar.set(2019, 11, 15);
        TimeZone timeZoneEB = TimeZone.getTimeZone("Europe/Bucharest");
        timeZoneEB.useDaylightTime();
        int offsetFromDate = timeZoneEB.getOffset(calendar.getTime().getTime());
        String userFriendlyOffsetDate = formatOffset(offsetFromDate);
        System.out.println("Offset from Calendar (Europe/Bucharest): " + userFriendlyOffsetDate);

        // JDK 8
        System.out.println("\n\nStarting with JDK 8:");
        // returns Z, which is +00:00
        ZoneOffset zoneOffsetUTC = ZoneOffset.UTC;
        System.out.println("ZoneOffset UTC: " + zoneOffsetUTC);
        // getting the system default time zone
        ZoneId defaultZoneId = ZoneOffset.systemDefault();
        System.out.println("Default zone id: " + defaultZoneId);

        // by default it deals with the Daylight Saving Times
        LocalDateTime ldt = LocalDateTime.of(2019, 3, 15, 0, 0);
        ZoneId zoneId = ZoneId.of("Europe/Bucharest");
        ZoneOffset zoneOffset = zoneId.getRules().getOffset(ldt);
        System.out.println("\nZoneOffset from LocalDateTime (Europe/Bucharest): " + zoneOffset);

        ZoneOffset zoneOffsetFromString = ZoneOffset.of("+02:00");
        System.out.println("\nZoneOffset from String: " + zoneOffsetFromString);
        // for example, use it to define an OffsetDateTime or an OffsetTime        
        OffsetTime offsetTime = OffsetTime.now(zoneOffsetFromString);
        OffsetDateTime offsetDateTime = OffsetDateTime.now(zoneOffsetFromString);
        System.out.println("OffsetTime from ZoneOffset of current date: " + offsetTime);
        System.out.println("OffsetDateTime from ZoneOffset of current date: " + offsetDateTime);

        ZoneOffset zoneOffsetFromHoursMinutes = ZoneOffset.ofHoursMinutes(8, 30);
        System.out.println("\nZoneOffset from hours and minutes: " + zoneOffsetFromHoursMinutes);

        ZoneOffset zoneOffsetFromOdt = offsetDateTime.getOffset();
        System.out.println("ZoneOffset from OffsetDateTime: " + zoneOffsetFromOdt);
    }

    private static String formatOffset(int offset) {

        if (offset == 0) {
            return "+00:00";
        }

        long offsetInHours = TimeUnit.MILLISECONDS.toHours(offset);
        long offsetInMinutesFromHours = TimeUnit.HOURS.toMinutes(offsetInHours);
        long offsetInMinutes = TimeUnit.MILLISECONDS.toMinutes(offset);

        offsetInMinutes = Math.abs(offsetInMinutesFromHours - offsetInMinutes);

        return String.format("%+03d:%02d", offsetInHours, offsetInMinutes);
    }

}
