package modern.challenge;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        System.out.println("Before JDK 8:");
        Date date  = new Date();
        System.out.println("Initial date: " + date);
        
        String dateAsString = DateTimes.fromDateAsString(date, "yyyy-MMM-dd");
        System.out.println("Only date as string: " + dateAsString);
        
        String timeAsString = DateTimes.fromDateAsString(date, "HH:mm:ss");
        System.out.println("Only time as string: " + timeAsString);

        Date dateAsDate = DateTimes.fromDateAsDate(date);
        System.out.println("\nOnly date as date: " + dateAsDate);
        
        Date timeAsDate = DateTimes.fromDateAsTime(date);
        System.out.println("Only time as date: " + timeAsDate);
        
        System.out.println("\nStarting with JDK 8:");
        
        LocalDate ld = LocalDate.now();        
        System.out.println("Only date: " + ld);
        
        LocalTime lt = LocalTime.now();        
        System.out.println("Only time: " + lt);
    }

}
