package a04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created on 02.07.17.
 */
public class InfiniteStreams {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2000,7,25);
        LocalDate end = LocalDate.of(2100,7,25);

        Stream.iterate(start, d -> d.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start,end))
                .filter(d -> d.getDayOfMonth() == 25)
                .filter(d -> d.getMonthValue() == 7)
                .filter(d -> d.getDayOfWeek() == DayOfWeek.SATURDAY)
                .forEach(d -> System.out.println(d));

    }

}
