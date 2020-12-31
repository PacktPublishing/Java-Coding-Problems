package modern.challenge;

import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

public class Converters {

    private Converters() {
        throw new AssertionError("Cannot be instantiatied");
    }

    public static YearMonth toYearMonth(Date date) {

        if (date == null) {
            throw new IllegalArgumentException("The given date cannot be null");
        }

        return YearMonth.from(date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
    }

    public static Date toDate(YearMonth ym) {

        if (ym == null) {
            throw new IllegalArgumentException("The given year-month cannot be null");
        }

        return Date.from(ym.atDay(1)
                .atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
