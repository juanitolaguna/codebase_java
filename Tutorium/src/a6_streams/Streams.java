package a6_streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * Created on 28.06.17.
 */
public class Streams {
    static long steps = 1;


    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/pawel/Desktop/IntelliJ-Projects/Tutorium/src/a6_streams/bible.txt");

        // 1)

//        List<String> list = new ArrayList<>();
//        list = Files.readAllLines(path).stream()
//                .filter(e -> e.matches(".* 3:16.*"))
//                .collect(Collectors.toList());
//
//        list.stream().forEach(System.out::println);

//        Map<String, Long> map = Files.readAllLines(path).stream()
//                .filter(e -> e.matches(".* 3:16.*"))
//                .map(lines -> lines.split("[\\W]"))
//                .flatMap(Stream::of)
//                .filter(e -> !e.matches(""))
//                .collect(groupingBy(e -> e.toLowerCase(), Collectors.counting()));
//        System.out.println(map);
//
//        System.out.println();

        Map<String, Long> map2 = Files.readAllLines(path).stream()
                .filter(e -> e.matches(".* 3:16.*"))
                .flatMap(line -> Stream.of(line.split("[\\W]")))
                .filter(e -> !e.matches(""))
                .collect(groupingBy(String::toLowerCase, Collectors.counting()));
        System.out.println(map2);

        //2.1 Fibonacci

        //        int n0, n1 = 0, n2 = 1;
//        for (double x = 0; x < 25; x++) {
//            n0 = n1;
//            n1 = n2;
//            n2 = n0 + n1;
//            if (n0 >= 2) System.out.println(n0);
//        }

        System.out.print("Fibonacci: ");
        Stream.generate(new FibMaker()).limit(25).forEach(e -> System.out.print(e + " "));
        System.out.println();

        //2.2 Collatz
        System.out.print("Collatz: ");
        List<Long> list = new ArrayList<>();
        Stream.generate(new CollatzMaker(200)).limit(1000).peek(list::add).anyMatch(a -> a == 1);
        System.out.println(list);


        // 2.3
        System.out.print("Freitag der 13: ");
        Stream.iterate(LocalDate.of(2017, 1, 1), d -> d.plusDays(1))
                .limit(365 * 2)
                .filter(d -> d.getDayOfWeek() == DayOfWeek.FRIDAY)
                .filter(d -> d.getDayOfMonth() == 13)
                .forEach(d -> System.out.print(d + " "));

        System.out.println();

        // 2.4.1

        System.out.print("1.Mai: ");
        Stream.iterate(LocalDate.of(2017,1,1), d -> d.plusDays(1))
                .limit(365*50)
                .filter(d -> d.getMonth() == Month.MAY)
                .filter(d -> d.getDayOfMonth() == 1)
                .filter(d -> (d.getDayOfWeek() == DayOfWeek.SUNDAY) || d.getDayOfWeek() == DayOfWeek.SATURDAY)
                .forEach(d -> System.out.print(d + " "));

        //2.4.2
        System.out.print("3.Oktober: ");
        Stream.iterate(LocalDate.of(2017,1,1), d -> d.plusDays(1))
                .limit(365*50)
                .filter(d -> d.getMonth() == Month.OCTOBER)
                .filter(d -> d.getDayOfMonth() == 3)
                .filter(d -> (d.getDayOfWeek() == DayOfWeek.SUNDAY) || d.getDayOfWeek() == DayOfWeek.SATURDAY)
                .forEach(d -> System.out.print(d + " "));
    }


    public static class FibMaker implements Supplier<Long> {

        long next;
        private long prev = 0;
        private long current = 1;

        @Override
        public Long get() {
            next = current + prev;
            prev = current;
            current = next;
            return prev;
        }
    }

    public static class CollatzMaker implements Supplier<Long> {
        private long start;

        public CollatzMaker(long start) {
            this.start = start;
        }

        @Override
        public Long get() {
            if (start == 0) {
                start = 0;
            } else if (start % 2 == 0) {
                start = start / -2;
            } else if (start % 2 == 1) {
                start = 3 * start + 1;
            }
            return start;
        }
    }

}

