package modern.challenge;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        System.out.println("Before JDK 8:");
        // yyyy-MM-dd
        Date date = new Date();
        
        SimpleDateFormat formatterD1 = new SimpleDateFormat("yyyy-MM-dd");
        String d1 = formatterD1.format(date);
        
        System.out.println(d1);
        
        // yyyy-MM-dd HH:mm:ss
        SimpleDateFormat formatterD2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d2 = formatterD2.format(date);
        
        System.out.println(d2);
        
        // E MMM yyyy HH:mm:ss.SSSZ
        SimpleDateFormat formatterD3 = new SimpleDateFormat("E MMM yyyy HH:mm:ss.SSSZ");
        String d3 = formatterD3.format(date);
        
        System.out.println(d3);
        
        System.out.println("\nStarting with JDK 8:");
        
        // yyyy-MM-dd
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatterLocalDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String ld1 = formatterLocalDate.format(localDate);

        // or shortly
        String ld2 = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println(ld1);
        System.out.println(ld2);
        
        // HH:mm:ss
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatterLocalTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String lt1 = formatterLocalTime.format(localTime);

        // or shortly
        String lt2 = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.println(lt1);
        System.out.println(lt2);
        
        // yyyy-MM-dd HH:mm:ss
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatterLocalDateTime = 
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String ldt1 = formatterLocalDateTime.format(localDateTime);

        // or shortly
        String ldt2 = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        System.out.println(ldt1);
        System.out.println(ldt2);
        
        // E MMM yyyy HH:mm:ss.SSSZ
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        DateTimeFormatter formatterZonedDateTime = 
                DateTimeFormatter.ofPattern("E MMM yyyy HH:mm:ss.SSSZ");
        String zdt1 = formatterZonedDateTime.format(zonedDateTime);

        // or shortly
        String zdt2 = ZonedDateTime.now()
                .format(DateTimeFormatter.ofPattern("E MMM yyyy HH:mm:ss.SSSZ"));                
        
        System.out.println(zdt1);
        System.out.println(zdt2);                                
        
        // E MMM yyyy HH:mm:ss.SSSZ
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        DateTimeFormatter formatterOffsetDateTime = 
                DateTimeFormatter.ofPattern("E MMM yyyy HH:mm:ss.SSSZ");
        String odt1 = formatterOffsetDateTime.format(offsetDateTime);

        // or shortly
        String odt2 = OffsetDateTime.now()
                .format(DateTimeFormatter.ofPattern("E MMM yyyy HH:mm:ss.SSSZ"));                
        
        System.out.println(odt1);
        System.out.println(odt2);
        
        // HH:mm:ss,Z
        OffsetTime offsetTime = OffsetTime.now();
        DateTimeFormatter formatterOffsetTime = 
                DateTimeFormatter.ofPattern("HH:mm:ss,Z");
        String ot1 = formatterOffsetTime.format(offsetTime);
        
        // or shortly
        String ot2 = OffsetTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss,Z"));
        
        System.out.println(ot1);
        System.out.println(ot2);
    }

}
