package modern.challenge;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

public final class DateConverters {

    public static final ZoneId DEFAULT_TIME_ZONE = ZoneId.systemDefault();

    private DateConverters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static Instant dateToInstant(Date date) {

        Objects.requireNonNull(date, "The provided date cannot be null");

        return date.toInstant();
    }

    public static LocalDate dateToLocalDate(Date date) {

        return dateToInstant(date).atZone(DEFAULT_TIME_ZONE).toLocalDate();
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {

        return dateToInstant(date).atZone(DEFAULT_TIME_ZONE).toLocalDateTime();
    }

    public static ZonedDateTime dateToZonedDateTime(Date date) {

        return dateToInstant(date).atZone(DEFAULT_TIME_ZONE);
    }

    public static OffsetDateTime dateToOffsetDateTime(Date date) {

        return dateToInstant(date).atZone(DEFAULT_TIME_ZONE).toOffsetDateTime();
    }

    public static LocalTime dateToLocalTime(Date date) {

        return LocalTime.ofInstant(dateToInstant(date), DEFAULT_TIME_ZONE);
    }

    public static OffsetTime dateToOffsetTime(Date date) {

        return OffsetTime.ofInstant(dateToInstant(date), DEFAULT_TIME_ZONE);
    }

    public static Date instantToDate(Instant instant) {

        Objects.requireNonNull(instant, "The provided Instant cannot be null");

        return Date.from(instant);
    }

    public static Date localDateToDate(LocalDate localDate) {

        Objects.requireNonNull(localDate, "The provided LocalDate cannot be null");

        return Date.from(localDate.atStartOfDay(DEFAULT_TIME_ZONE).toInstant());
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {

        Objects.requireNonNull(localDateTime, "The provided LocalDateTime cannot be null");

        return Date.from(localDateTime.atZone(DEFAULT_TIME_ZONE).toInstant());
    }

    public static Date zonedDateTimeToDate(ZonedDateTime zonedDateTime) {

        Objects.requireNonNull(zonedDateTime, "The provided ZonedDateTime cannot be null");

        return Date.from(zonedDateTime.toInstant());
    }

    public static Date offsetDateTimeToDate(OffsetDateTime offsetDateTime) {

        Objects.requireNonNull(offsetDateTime, "The provided OffsetDateTime cannot be null");

        return Date.from(offsetDateTime.toLocalDateTime()
                .toInstant(ZoneOffset.of(offsetDateTime.getOffset().getId())));
    }

    public static Date localTimeToDate(LocalTime localTime) {

        Objects.requireNonNull(localTime, "The provided LocalTime cannot be null");

        return Date.from(localTime.atDate(LocalDate.EPOCH)
                .toInstant(DEFAULT_TIME_ZONE.getRules().getOffset(Instant.now())));
    }

    public static Date offsetTimeToDate(OffsetTime offsetTime) {

        Objects.requireNonNull(offsetTime, "The provided OffsetTime cannot be null");

        return Date.from(offsetTime.atDate(LocalDate.EPOCH).toInstant());
    }

}
