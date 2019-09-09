package modern.challenge;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjuster;

public final class DateTimes {

    private DateTimes() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static LocalDate getDayAfterDays(LocalDate startDate, int days) {

        if (startDate == null) {
            throw new IllegalArgumentException("Start date cannot be null");
        }

        Period period = Period.ofDays(days);
        TemporalAdjuster ta = p -> p.plus(period);
        LocalDate endDate = startDate.with(ta);

        return endDate;
    }
}
