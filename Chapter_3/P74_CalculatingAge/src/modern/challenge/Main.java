package modern.challenge;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        System.out.println("Before JDK 8:");
        Calendar startDate = Calendar.getInstance();
        startDate.set(1977, 10, 2);
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(new Date());

        int yearsc = endDate.get(Calendar.YEAR) - startDate.get(Calendar.YEAR);

        if (yearsc > 0) {
            if (startDate.get(Calendar.MONTH) > endDate.get(Calendar.MONTH)
                    || (startDate.get(Calendar.MONTH) == endDate.get(Calendar.MONTH)
                    && startDate.get(Calendar.DAY_OF_MONTH) > endDate.get(Calendar.DAY_OF_MONTH))) {
                yearsc--;
            }
        }

        System.out.println(yearsc + "y");
        System.out.println("\nStarting with JDK 8");
        LocalDate startLocalDate = LocalDate.of(1977, 11, 2);
        LocalDate endLocalDate = LocalDate.now();

        long years = ChronoUnit.YEARS.between(startLocalDate, endLocalDate);
        System.out.println(years + "y ");

        Period periodBetween = Period.between(startLocalDate, endLocalDate);
        System.out.println(periodBetween.getYears() + "y "
                + periodBetween.getMonths() + "m "
                + periodBetween.getDays() + "d");
    }

}
