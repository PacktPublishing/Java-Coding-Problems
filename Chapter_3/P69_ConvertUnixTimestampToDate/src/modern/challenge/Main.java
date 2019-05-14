package modern.challenge;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws ParseException {

        // 11/14/2019 @ 10:00pm (UTC)
        long unixTimestamp = 1573768800;

        Date date1 = new Date(unixTimestamp * 1000L);
        Date date2 = new Date(TimeUnit.MILLISECONDS.convert(unixTimestamp, TimeUnit.SECONDS));

        System.out.println(unixTimestamp + " as date-time in default time zone is " + date1);
        System.out.println(unixTimestamp + " as date-time in default time zone is " + date2);

        // JDK 8        
        Instant instant = Instant.ofEpochSecond(unixTimestamp);
        Date date3 = Date.from(instant);
        LocalDateTime date4 = LocalDateTime.ofInstant(instant, ZoneId.of("Australia/Perth"));
        ZonedDateTime date5 = ZonedDateTime.ofInstant(instant, ZoneId.of("Europe/Bucharest"));

        System.out.println(unixTimestamp + " as date-time in default time zone is " + date3);
        System.out.println("\n" + unixTimestamp + " as date-time in Australia/Perth time zone is " + date4);
        System.out.println(unixTimestamp + " as date-time in Europe/Bucharest time zone is "
                + date5.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss Z VV")));
        System.out.println("\n" + unixTimestamp + " as instant (UTC time) is " + instant);
    }

}
