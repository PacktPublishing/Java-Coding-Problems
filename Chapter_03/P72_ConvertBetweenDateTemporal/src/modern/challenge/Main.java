package modern.challenge;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        System.out.println("------------------------");
        System.out.println("Convert Date to Temporal");
        System.out.println("------------------------");

        System.out.println("\nConvert Date -> Instant:");
        Date date = new Date();        
        System.out.println("Instant from Date (UTC): " + DateConverters.dateToInstant(date));

        System.out.println("\nConvert Date -> LocalDate:");        
        System.out.println("LocalDate: " + DateConverters.dateToLocalDate(date));

        System.out.println("\nConvert Date -> LocalDateTime:");        
        System.out.println("LocalDateTime: " + DateConverters.dateToLocalDateTime(date));

        System.out.println("\nConvert Date -> ZonedDateTime:");        
        System.out.println("ZonedDateTime: " + DateConverters.dateToZonedDateTime(date));

        System.out.println("\nConvert Date -> OffsetDateTime:");
        System.out.println("OffsetDateTime: " + DateConverters.dateToOffsetDateTime(date));

        System.out.println("\nConvert Date -> LocalTime:");
        System.out.println("Local time: " + DateConverters.dateToLocalTime(date));
        
        System.out.println("\nConvert Date -> OffsetTime:");
        System.out.println("Offset time: " + DateConverters.dateToOffsetTime(date));
        
        System.out.println("------------------------");
        System.out.println("\n\nConvert Temporal to Date");
        System.out.println("------------------------");

        System.out.println("\nConvert Instant -> Date:");
        Instant instant = Instant.now();        
        System.out.println("Date from Instant (your default system time zone): " 
                + DateConverters.instantToDate(instant));

        System.out.println("\nConvert LocalDate -> Date:");
        LocalDate localDate = LocalDate.now();        
        System.out.println("Date: " + DateConverters.localDateToDate(localDate));

        System.out.println("\nConvert LocalDateTime -> Date:");
        LocalDateTime localDateTime = LocalDateTime.now();        
        System.out.println("Date: " + DateConverters.localDateTimeToDate(localDateTime));

        System.out.println("\nConvert ZonedDateTime -> Date:");
        ZonedDateTime zonedDateTime = ZonedDateTime.now();        
        System.out.println("Date: " + DateConverters.zonedDateTimeToDate(zonedDateTime));

        System.out.println("\nConvert OffsetDateTime -> Date:");
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("Date: " + DateConverters.offsetDateTimeToDate(offsetDateTime));

        System.out.println("\nConvert LocalTime -> Date:");
        LocalTime localTime = LocalTime.now();        
        System.out.println("Date: " + DateConverters.localTimeToDate(localTime));
        
        System.out.println("\nConvert OffsetTime -> Date:");
        OffsetTime offsetTime = OffsetTime.now();               
        System.out.println("Date: " + DateConverters.offsetTimeToDate(offsetTime));                        
    }
}
