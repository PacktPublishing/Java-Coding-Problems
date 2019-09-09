package modern.challenge;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        System.out.println("Before JDK 8");

        Calendar calendar = Calendar.getInstance();

        calendar.set(2019, 1, 1);
        Date startDate = calendar.getTime();

        calendar.set(2019, 1, 21);
        Date endDate = calendar.getTime();

        Date day = startDate;
        while (day.before(endDate)) {

            // do something with this day
            System.out.println(day);

            calendar.setTime(day);
            calendar.add(Calendar.DATE, 1);
            day = calendar.getTime();
        }

        System.out.println("\nStarting with JDK 8");

        LocalDate startLocalDate = LocalDate.of(2019, 2, 1);
        LocalDate endLocalDate = LocalDate.of(2019, 2, 21);

        for (LocalDate date = startLocalDate; date.isBefore(endLocalDate); date = date.plusDays(1)) {
            // do something with this day
            System.out.println(date);
        }

        System.out.println("\nStarting with JDK 9");

        startLocalDate.datesUntil(endLocalDate).forEach(System.out::println);
    }

}
