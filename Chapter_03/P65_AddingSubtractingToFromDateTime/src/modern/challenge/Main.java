package modern.challenge;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Main {

    public static void main(String[] args) {              
        
        System.out.println("Working with Date: ");
        Date date = new Date();
        Date dateAfterAddingYears = DateTimes.addOrSubtractYears(date, 2);
        Date dateAfterSubtractingYears = DateTimes.addOrSubtractYears(date, -2);
        System.out.println("Before adding 2 years: " + date
                + "\nAfter adding 2 years: " + dateAfterAddingYears
                + "\nAfter subtracting 2 years: " + dateAfterSubtractingYears);
        
        Date dateAfterAddingHours = DateTimes.addOrSubtractHours(date, 5);
        Date dateAfterSubtractingHours = DateTimes.addOrSubtractHours(date, -5);
        System.out.println("\nBefore adding 48 hours: " + date
                + "\nAfter adding 48 hours: " + dateAfterAddingHours
                + "\nAfter subtracting 48 hours: " + dateAfterSubtractingHours);
        
        System.out.println("\nWorking with LocalDateTime (similar for LocalDate, ZonedDateTime, OffsetDateTime): ");
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldtAfterAddingMinutes = ldt.plusMinutes(10);
        LocalDateTime ldtAfterSubtractingMinutes = ldt.minusMinutes(10);
        System.out.println("Before adding 10 minutes: " + ldt
                + "\nAfter adding 10 minutes: " + ldtAfterAddingMinutes
                + "\nAfter subtracting 10 minutes: " + ldtAfterSubtractingMinutes);
        
        System.out.println("\nWorking with Instant: ");
        Instant timestamp = Instant.now();
        Instant timestampAfterAddingHours = timestamp.plus(5, ChronoUnit.HOURS);
        Instant timestampAfterSubtractingHours = timestamp.minus(5, ChronoUnit.HOURS);
        System.out.println("Before adding 5 hours: " + timestamp
                + "\nAfter adding 5 hours: " + timestampAfterAddingHours
                + "\nAfter subtracting 5 hours: " + timestampAfterSubtractingHours);                
        
        
    }

}
