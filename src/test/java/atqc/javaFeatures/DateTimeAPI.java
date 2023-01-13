package atqc.javaFeatures;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateTimeAPI {
    public static void main(String[] args) {

//        getCurrentDateTime();

//        getCustomDateTime();

//        addSubtractionLocalDateToCurrentDate();

//        addSubtractionLocalTimeToCurrentTime();

//        compareDate();
//        compareTime();
//        compareDateTime();

//        formatLocalDate();
//        formatLocalTime();

//        convertDateTimeToTimeZone();
    }


    public static void getCurrentDateTime(){
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
    }

    public static void getCustomDateTime(){
        System.out.println("Date: ---------------");
        System.out.println(LocalDate.of(2020, Month.SEPTEMBER, 23));
        System.out.println(LocalDate.of(2021, 1, 1));
        System.out.println(LocalDate.ofYearDay(2020, 255));

        System.out.println("\nTime: ---------------");
        System.out.println(LocalTime.of(12, 10));
        System.out.println(LocalTime.of(18, 15, 10));
        System.out.println(LocalTime.of(23, 59, 59, 700));
        System.out.println(LocalTime.ofSecondOfDay(9_124));
        System.out.println(LocalTime.ofNanoOfDay(100_000_000_000L));
    }

    public static void addSubtractionLocalDateToCurrentDate(){
        LocalDate now = LocalDate.now(); // 2018-01-21

        System.out.println("Adding Date: ---------------");
        System.out.println(now.plusDays(2));
        System.out.println(now.plusWeeks(1));
        System.out.println(now.plusMonths(3));
        System.out.println(now.plusMonths(3));
        System.out.println(now.plus(Period.ofDays(3)));
        System.out.println(now.plus(1, ChronoUnit.MILLENNIA));

        System.out.println("\nSubtraction Date: ---------------");
        System.out.println(now.minusDays(3));
        System.out.println(now.minusWeeks(2));
        System.out.println(now.minusWeeks(2));
        System.out.println(now.minusMonths(4));
        System.out.println(now.minus(Period.ofDays(1)));
        System.out.println(now.minus(1, ChronoUnit.CENTURIES));
    }

    public static void addSubtractionLocalTimeToCurrentTime(){
        LocalTime now = LocalTime.now();

        System.out.println("Adding Time: ---------------");
        System.out.println(now.plusNanos(100_000));
        System.out.println(now.plusSeconds(20));
        System.out.println(now.plusMinutes(20));
        System.out.println(now.plusHours(6));
        System.out.println(now.plus(Duration.ofMillis(100)));
        System.out.println(now.plus(1, ChronoUnit.HALF_DAYS));

        System.out.println("\nSubtraction Time: ---------------");
        System.out.println(now.minusSeconds(20));
        System.out.println(now.minusMinutes(20));
        System.out.println(now.minusHours(6));
        System.out.println(now.minus(Duration.ofMillis(100)));
        System.out.println(now.minus(1, ChronoUnit.HALF_DAYS));
    }

    public static void compareDate(){
        LocalTime now = LocalTime.now();
        LocalTime _2HoursAfter = now.plusHours(2);
        System.out.println(now.isAfter(_2HoursAfter));
        System.out.println(now.isBefore(_2HoursAfter));
    }

    public static void compareTime(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime monthAgo = now.minusMonths(1);
        System.out.println(now.isAfter(monthAgo));
        System.out.println(now.isBefore(monthAgo));
    }

    public static void compareDateTime(){
        LocalDate localDate = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println(localDate.compareTo(tomorrow) > 0);

        LocalTime localTime = LocalTime.now();
        LocalTime hourLater = localTime.plusHours(1);
        System.out.println(localTime.compareTo(hourLater) < 0 );

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime lastYear = localDateTime.minusYears(1);
        System.out.println(localDateTime.compareTo(lastYear) > 0);
    }

    public static void formatLocalDate(){
        LocalDate now = LocalDate.now();

        System.out.println(now.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(now.format(DateTimeFormatter.ofPattern("dd MMM yyyy")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.FRANCE)));
    }

    public static void formatLocalTime(){
        LocalTime now = LocalTime.now();

        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(now.format(DateTimeFormatter.ISO_TIME));
        System.out.println(now.format(DateTimeFormatter.ofPattern("hh:mm:ss ")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("h:mm a")));
    }

    public static void convertDateTimeToTimeZone(){
        ZonedDateTime now = ZonedDateTime.now(); // 2018-02-10T08:49:50.886682+01:00[Europe/Warsaw]

        LocalDate localDate = now.toLocalDate();
        LocalTime localTime = now.toLocalTime();
        ZoneId zone = ZoneId.of("Europe/Kiev");
        ZonedDateTime kievTime = ZonedDateTime.of(localDate, localTime, zone);

        System.out.println(kievTime);
        System.out.println(kievTime.withZoneSameInstant(ZoneId.of("America/New_York")));
    }


}
