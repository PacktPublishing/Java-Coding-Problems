package modern.challenge;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Main {

    static TemporalAdjuster NEXT_SATURDAY = TemporalAdjusters.ofDateAdjuster(today -> {

        DayOfWeek dayOfWeek = today.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.SATURDAY) {
            return today;
        }

        if (dayOfWeek == DayOfWeek.SUNDAY) {
            return today.plusDays(6);
        }

        return today.plusDays(6 - dayOfWeek.getValue());
    });

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2019, Month.FEBRUARY, 27);
        LocalDate firstDayOfFeb = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfFeb = date.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println("First day of Feb, 2019: " + firstDayOfFeb);
        System.out.println("Last day of Feb, 2019: " + lastDayOfFeb);

        LocalDate datePlus21Days = DateTimes.getDayAfterDays(date, 21);
        System.out.println("\n21 days after 27 Feb 2019 is : " + datePlus21Days);

        LocalDate nextSaturday1 = date.with(NEXT_SATURDAY);
        System.out.println("\nNext Saturday is (1): " + nextSaturday1);

        NextSaturdayAdjuster nsa = new NextSaturdayAdjuster();
        LocalDate nextSaturday2 = date.with(nsa);
        System.out.println("Next Saturday is (2): " + nextSaturday2);
    }

}
