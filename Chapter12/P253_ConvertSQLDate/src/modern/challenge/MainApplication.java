package modern.challenge;

import java.time.LocalDate;
import java.time.ZoneId;

public class MainApplication {

    public static void main(String[] args) {

        System.out.println("LocalDate to java.sql.Date:");
        LocalDate localDate = LocalDate.now(ZoneId.of("Europe/Paris"));
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        LocalDate backToLocalDate = sqlDate.toLocalDate();
        System.out.println("LocalDate: " + localDate + " java.sql.Date: " + sqlDate);
        System.out.println("Back to LocalDate: " + backToLocalDate);

        System.out.println("\njava.util.Date to java.sql.Date:");
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDateFromUtilDate = new java.sql.Date(utilDate.getTime());
        java.util.Date backToUtilDate = new java.util.Date(sqlDateFromUtilDate.getTime());
        System.out.println("java.util.Date: " + utilDate + " java.sql.Date: " + sqlDateFromUtilDate);
        System.out.println("Back to java.util.Date: " + backToUtilDate);
           
        System.out.println("\njava.util.Date to java.sql.Timestamp:");
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(utilDate.getTime());
        java.util.Date backToUtilDateFromSqlTimestamp = new java.util.Date(sqlTimestamp.getTime());        
        System.out.println("java.util.Date to java.sql.Timestamp: " + sqlTimestamp);
        System.out.println("Back to java.sql.Timestamp: " + backToUtilDateFromSqlTimestamp);
    }
}