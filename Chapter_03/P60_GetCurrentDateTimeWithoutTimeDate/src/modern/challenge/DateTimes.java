package modern.challenge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateTimes {

    private DateTimes() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String fromDateAsString(Date date, String pattern) {

        if (date == null || pattern == null || pattern.isBlank()) {
            // or throw IllegalArgumentException
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return sdf.format(date);
    }

    public static Date fromDateAsDate(Date date) throws ParseException {

        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateWithoutTime = sdf.parse(sdf.format(date));

        return dateWithoutTime;
    }

    public static Date fromDateAsTime(Date date) throws ParseException {
        
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date timeWithoutDate = sdf.parse(sdf.format(date));

        return timeWithoutDate;
    }
}
