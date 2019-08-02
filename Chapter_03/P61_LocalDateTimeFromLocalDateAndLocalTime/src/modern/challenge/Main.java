package modern.challenge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
                       
        LocalDate localDate = LocalDate.now();
        String localDateAsString = localDate
                .format(DateTimeFormatter.ofPattern("yyyy-MMM-dd"));
        System.out.println("LocalDate: " + localDateAsString);
        
        LocalTime localTime = LocalTime.now();
        String localTimeAsString = localTime
                .format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
        System.out.println("LocalTime: " + localTimeAsString);
        
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        
        String localDateTimeAsString = localDateTime
                .format(DateTimeFormatter.ofPattern("yyyy-MMM-dd hh:mm:ss a"));
        
        System.out.println("LocalDateTime: " + localDateTimeAsString);
    }
    
}
