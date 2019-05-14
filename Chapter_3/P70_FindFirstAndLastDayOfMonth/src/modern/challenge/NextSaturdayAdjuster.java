package modern.challenge;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextSaturdayAdjuster implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {

        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

        if (dayOfWeek == DayOfWeek.SATURDAY) {
            return temporal;
        }

        if (dayOfWeek == DayOfWeek.SUNDAY) {
            return temporal.plus(6, ChronoUnit.DAYS);
        }

        return temporal.plus(6 - dayOfWeek.getValue(), ChronoUnit.DAYS);
    }

}
