package modern.challenge;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws ParseException {

        System.out.println("Before Java 8 (default formatting styles): ");

        DateFormat defaultDateFormatUS
                = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US);
        // convert String to Date
        // https://bugs.openjdk.java.net/browse/JDK-8206961 - why ",", read there
        Date usDate = defaultDateFormatUS.parse("01/15/95, 5:23 AM"); 
        // convert Date to String
        String usDateAsString = usDate.toString();
        String usDateAsFormattedString = defaultDateFormatUS.format(usDate);
        System.out.println("SHORT format of date & time in US locale: " + usDateAsString);
        System.out.println("SHORT format of date & time in US locale (formatted): " + usDateAsFormattedString);

        DateFormat defaultDateFormatDE
                = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.GERMAN);
        // convert String to Date
        // https://bugs.openjdk.java.net/browse/JDK-8206961 - why ",", read there
        Date deDate = defaultDateFormatDE.parse("15.01.95, 5:23 AM");
        // convert Date to String
        String deDateAsString = deDate.toString();
        String deDateAsFormattedString = defaultDateFormatDE.format(deDate);
        System.out.println("SHORT format of date & time in German locale: " + deDateAsString);
        System.out.println("SHORT format of date & time in German locale (formatted): " + deDateAsFormattedString);

        System.out.println("\nBefore Java 8 (custom formatting styles): ");

        // convert String to Date        
        DateFormat simpleDateFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss zzz");
        //simpleDateFormatter.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        Date dateSimpleFormatted = simpleDateFormatter.parse("1-Jun-2020 08:22:34 GMT");
        // convert Date to String
        String dateAsDefaultString = dateSimpleFormatted.toString();
        String dateAsFormattedString = simpleDateFormatter.format(dateSimpleFormatted);
        System.out.println("Default format: " + dateAsDefaultString);
        System.out.println("Explicit format: " + dateAsFormattedString);

        System.out.println("\nJava 8, convert without formatter:");

        // convert String to LocalDate
        LocalDate localDate = LocalDate.parse("2020-06-01");
        // convert LocalDate to String
        String localDateAsDefaultString = localDate.toString();
        System.out.println("LocalDate: " + localDateAsDefaultString + "( year: " + localDate.getYear()
                + ", month: " + localDate.getMonthValue() + ", day: " + localDate.getDayOfMonth() + " )");

        LocalTime localTime = LocalTime.parse("12:23:44");
        // convert LocalTime to String
        String localTimeAsDefaultString = localTime.toString();
        System.out.println("LocalTime: " + localTimeAsDefaultString + "( hour: " + localTime.getHour()
                + ", minute: " + localTime.getMinute() + ", second: " + localTime.getSecond() + " )");

        // convert String to LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse("2020-06-01T11:20:15");
        // convert LocalDateTime to String
        String localDateTimeAsDefaultString = localDateTime.toString();
        System.out.println("LocalDateTime: " + localDateTimeAsDefaultString + "( year: " + localDateTime.getYear()
                + ", month: " + localDateTime.getMonthValue() + ", day: " + localDateTime.getDayOfMonth()
                + ", hour: " + localDateTime.getHour() + ", minute: " + localDateTime.getMinute()
                + ", second: " + localDateTime.getSecond() + " )");

        // convert String to OffsetDateTime
        OffsetDateTime offsetDateTime = OffsetDateTime.parse("2007-12-03T10:15:30+01:00");
        // convert OffsetDateTime to String
        String offsetDateTimeAsDefaultString = offsetDateTime.toString();
        System.out.println("OffsetDateTime: " + offsetDateTimeAsDefaultString + "( year: " + offsetDateTime.getYear()
                + ", month: " + offsetDateTime.getMonthValue() + ", day: " + offsetDateTime.getDayOfMonth()
                + ", hour: " + offsetDateTime.getHour() + ", minute: " + offsetDateTime.getMinute()
                + ", second: " + offsetDateTime.getSecond() + ", offset: " + offsetDateTime.getOffset() + " )");

        // convert String to OffsetTime
        OffsetTime offsetTime = OffsetTime.parse("10:15:30+01:00");
        // convert OffsetTime to String
        String offsetTimeAsDefaultString = offsetTime.toString();
        System.out.println("OffsetTime: " + offsetTimeAsDefaultString
                + "( hour: " + offsetTime.getHour() + ", minute: " + offsetTime.getMinute()
                + ", second: " + offsetTime.getSecond() + ", offset: " + offsetTime.getOffset() + " )");

        // convert String to ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2020-06-01T10:15:30+09:00[Asia/Tokyo]");
        // convert ZonedDateTime to String
        String zonedDateTimeAsDefaultString = zonedDateTime.toString();
        System.out.println("ZonedDateTime: " + zonedDateTimeAsDefaultString + "( year: " + zonedDateTime.getYear()
                + ", month: " + zonedDateTime.getMonthValue() + ", day: " + zonedDateTime.getDayOfMonth()
                + ", hour: " + zonedDateTime.getHour() + ", minute: " + zonedDateTime.getMinute()
                + ", second: " + zonedDateTime.getSecond() + ", offset: " + zonedDateTime.getOffset()
                + ", zone: " + zonedDateTime.getZone() + " )");

        System.out.println("\nJava 8, convert with formatter:");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        // convert String to LocalDate
        LocalDate localDateFormatted = LocalDate.parse("01.06.2020", dateFormatter);
        // convert LocalDate to String              
        String localDateAsFormattedString = dateFormatter.format(localDateFormatted);
        System.out.println("Date: " + localDateAsFormattedString + "( year: " + localDateFormatted.getYear()
                + ", month: " + localDateFormatted.getMonthValue() + ", day: " + localDateFormatted.getDayOfMonth() + " )");

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH|mm|ss");
        // convert String to LocalTime
        LocalTime localTimeFormatted = LocalTime.parse("12|23|44", timeFormatter);
        // convert LocalTime to String              
        String localTimeAsFormattedString = timeFormatter.format(localTimeFormatted);
        System.out.println("Time: " + localTimeAsFormattedString + "( hour: " + localTimeFormatted.getHour()
                + ", minute: " + localTimeFormatted.getMinute() + ", second: " + localTimeFormatted.getSecond() + " )");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss");
        // convert String to LocalDateTime
        LocalDateTime localDateTimeFormatted = LocalDateTime.parse("01.06.2020, 11:20:15", dateTimeFormatter);
        // convert LocalDateTime to String        
        String localDateTimeAsFormattedString = dateTimeFormatter.format(localDateTimeFormatted);
        System.out.println("DateTime: " + localDateTimeAsFormattedString + "( year: " + localDateTimeFormatted.getYear()
                + ", month: " + localDateTimeFormatted.getMonthValue() + ", day: " + localDateTimeFormatted.getDayOfMonth()
                + ", hour: " + localDateTimeFormatted.getHour() + ", minute: " + localDateTimeFormatted.getMinute()
                + ", second: " + localDateTimeFormatted.getSecond() + " )");

        DateTimeFormatter offsetDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd, HH:mm:ss, XXXXX");
        // convert String to OffsetDateTime
        OffsetDateTime offsetDateTimeFormatted = OffsetDateTime.parse("2007.12.03, 10:15:30, +01:00", offsetDateTimeFormatter);
        // convert OffsetDateTime to String        
        String offsetDateTimeAsFormattedString = offsetDateTimeFormatter.format(offsetDateTimeFormatted);
        System.out.println("OffsetDateTime: " + offsetDateTimeAsFormattedString + "( year: " + offsetDateTimeFormatted.getYear()
                + ", month: " + offsetDateTimeFormatted.getMonthValue() + ", day: " + offsetDateTimeFormatted.getDayOfMonth()
                + ", hour: " + offsetDateTimeFormatted.getHour() + ", minute: " + offsetDateTimeFormatted.getMinute()
                + ", second: " + offsetDateTimeFormatted.getSecond() + ", offset: " + offsetDateTimeFormatted.getOffset() + " )");

        DateTimeFormatter offsetTimeFormatter = DateTimeFormatter.ofPattern("HH mm ss XXXXX");
        // convert String to OffsetTime
        OffsetTime offsetTimeFormatted = OffsetTime.parse("10 15 30 +01:00", offsetTimeFormatter);
        // convert OffsetTime to String
        String offsetTimeAsFormattedString = offsetTimeFormatter.format(offsetTimeFormatted);
        System.out.println("OffsetTime: " + offsetTimeAsFormattedString
                + "( hour: " + offsetTimeFormatted.getHour() + ", minute: " + offsetTimeFormatted.getMinute()
                + ", second: " + offsetTimeFormatted.getSecond() + ", offset: " + offsetTimeFormatted.getOffset() + " )");

        DateTimeFormatter zonedDateTimeFormatter
                = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ssXXXXX '['VV']'");
        // DateTimeFormatter zonedDateTimeFormatter 
        //      = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ssXXXXX '['VV']'").withZone(ZoneId.of("Europe/Paris"));        
        // convert String to ZonedDateTime                 
        ZonedDateTime zonedDateTimeFormatted
                = ZonedDateTime.parse("01.06.2020, 11:20:15+09:00 [Asia/Tokyo]", zonedDateTimeFormatter);
        // convert ZonedDateTime to String        
        String zonedDateTimeAsFormattedString = zonedDateTimeFormatted.format(zonedDateTimeFormatter);
        System.out.println("ZonedDateTime: " + zonedDateTimeAsFormattedString + "( year: " + zonedDateTimeFormatted.getYear()
                + ", month: " + zonedDateTimeFormatted.getMonthValue() + ", day: " + zonedDateTimeFormatted.getDayOfMonth()
                + ", hour: " + zonedDateTimeFormatted.getHour() + ", minute: " + zonedDateTimeFormatted.getMinute()
                + ", second: " + zonedDateTimeFormatted.getSecond() + ", offset: " + zonedDateTimeFormatted.getOffset()
                + ", zone: " + zonedDateTimeFormatted.getZone() + " )");
    }
}
