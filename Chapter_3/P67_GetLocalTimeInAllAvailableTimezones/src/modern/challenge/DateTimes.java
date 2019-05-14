package modern.challenge;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public final class DateTimes {

    private DateTimes() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static List<String> localTimeToAllTimeZones7() {

        List<String> result = new ArrayList<>();

        String[] zoneIds = TimeZone.getAvailableIDs();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd'T'HH:mm:ss a Z");
        SimpleDateFormat zoneFormatter = new SimpleDateFormat("yyyy-MMM-dd'T'HH:mm:ss a Z");

        Date date = new Date();

        for (String zoneId : zoneIds) {
            zoneFormatter.setTimeZone(TimeZone.getTimeZone(zoneId));

            result.add(formatter.format(date) + " in "
                    + zoneId + " is " + zoneFormatter.format(date));
        }

        return result;

    }

    public static List<String> localTimeToAllTimeZones8() {

        List<String> result = new ArrayList<>();
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd'T'HH:mm:ss a Z");

        ZonedDateTime zlt = ZonedDateTime.now();

        zoneIds.forEach((zoneId) -> {
            result.add(zlt.format(formatter) + " in " + zoneId + " is "
                    + zlt.withZoneSameInstant(ZoneId.of(zoneId)).format(formatter));
        });

        return result;
    }

}
