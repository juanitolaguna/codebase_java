package pmp4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 19.05.17.
 */
public class WorkersDay {

    public static List<Integer> getMondayYear() {
        List<Calendar> allWorkersDays = new ArrayList<>();
        for (int i = 1889; i < 2100; i++) {
            allWorkersDays.add(new GregorianCalendar(i, 5, 1));
        }

        List<Integer> allMondays = allWorkersDays.stream()
                .filter(e -> e.get(Calendar.DAY_OF_WEEK) == 1)
                .map(e -> e.get(Calendar.YEAR))
                .collect(Collectors.toList());

        return allMondays;
    }

    public static void main(String[] args) {
//        System.out.println("All WorkersDays Mondays:");
//        getMondayYear().forEach(e -> System.out.println(e));

        Stream.iterate(LocalDate.of(1889, 05, 01), d -> d.plusYears(1))
                .limit(2101 - 1889)
                .filter(d -> d.getDayOfWeek() == DayOfWeek.MONDAY)
                .forEach(System.out::println);


    }
}
