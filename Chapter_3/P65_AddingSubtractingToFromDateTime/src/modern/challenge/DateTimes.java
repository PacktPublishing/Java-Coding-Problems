package modern.challenge;

import java.util.Calendar;
import java.util.Date;

public final class DateTimes {

    private DateTimes() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static Date addOrSubtractYears(Date date, int years) {

        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);

        return calendar.getTime();
    }

    public static Date addOrSubtractHours(Date date, int hours) {

        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);

        return calendar.getTime();
    }

}
