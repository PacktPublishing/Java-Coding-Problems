package modern.challenge;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        System.out.println("Before JDK 8:");

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int yearC = calendar.get(Calendar.YEAR);
        int monthC = calendar.get(Calendar.MONTH);
        int weekC = calendar.get(Calendar.WEEK_OF_MONTH);
        int dayC = calendar.get(Calendar.DATE);
        int hourC = calendar.get(Calendar.HOUR_OF_DAY);
        int minuteC = calendar.get(Calendar.MINUTE);
        int secondC = calendar.get(Calendar.SECOND);
        int millisC = calendar.get(Calendar.MILLISECOND);

        System.out.println("Date: " + date);
        System.out.println("Year: " + yearC + " Month: " + monthC
                + " Week: " + weekC + " Day: " + dayC + " Hour: " + hourC
                + " Minute: " + minuteC + " Second: " + secondC + " Millis: " + millisC);

        System.out.println("\nStarting with JDK 8:");
        
        LocalDateTime ldt = LocalDateTime.now();
        
        int yearLDT = ldt.getYear();
        int monthLDT = ldt.getMonthValue();
        int dayLDT = ldt.getDayOfMonth();
        int hourLDT = ldt.getHour();
        int minuteLDT = ldt.getMinute();
        int secondLDT = ldt.getSecond();
        int nanoLDT = ldt.getNano();                

        System.out.println("LocalDateTime: " + ldt);
        System.out.println("Year: " + yearLDT + " Month: " + monthLDT
                + " Day: " + dayLDT + " Hour: " + hourLDT + " Minute: " + minuteLDT 
                + " Second: " + secondLDT + " Nano: " + nanoLDT);
        
        int yearLDT2 = ldt.get(ChronoField.YEAR);
        int monthLDT2 = ldt.get(ChronoField.MONTH_OF_YEAR);
        int dayLDT2 = ldt.get(ChronoField.DAY_OF_MONTH);
        int hourLDT2 = ldt.get(ChronoField.HOUR_OF_DAY);
        int minuteLDT2 = ldt.get(ChronoField.MINUTE_OF_HOUR);
        int secondLDT2 = ldt.get(ChronoField.SECOND_OF_MINUTE);
        int nanoLDT2 = ldt.get(ChronoField.NANO_OF_SECOND);                
        
        System.out.println("Year: " + yearLDT2 + " Month: " + monthLDT2
                + " Day: " + dayLDT2 + " Hour: " + hourLDT2 + " Minute: " + minuteLDT2
                + " Second: " + secondLDT2 + " Nano: " + nanoLDT2);
    }

}
