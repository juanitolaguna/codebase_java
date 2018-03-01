package a6_streams;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Created on 30.06.17.
 */
public class Streams2 {


    public static void main(String[] args) {
        LocalDate d1 = LocalDate.of(2017, 1, 1);
        LocalDate d2 = LocalDate.of(2117, 1, 1);
        getDistance(d1,d2);
    }

    private static void getDistance(LocalDate start, LocalDate limitValue) {
        LinkedList<LocalDate> ll = new LinkedList<>();
        List<Long> averageDistance = new ArrayList<>();
        Long limit = DAYS.between(start, limitValue);

        Stream.iterate(start, d -> d.plusDays(1))
                .limit(limit)
                .filter(d -> d.getMonth() == Month.MAY)
                .filter(d -> d.getDayOfMonth() == 1)
                .filter(d -> d.getDayOfWeek() == DayOfWeek.SATURDAY || d.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(d -> {
                    ll.addFirst(d);
                    if (ll.size() == 2) {
                        averageDistance.add(DAYS.between(ll.get(1), ll.get(0)));
                        ll.removeLast();
                    }
                });

        System.out.println(
                "MinDistance: " + averageDistance.stream().min(Long::compareTo) + "\n"
                + "MaxDistance: " + averageDistance.stream().max(Long::compareTo) + "\n"
                + "AverageDistance: " + averageDistance.stream().mapToDouble(Long::doubleValue).average()
        );
    }
}
