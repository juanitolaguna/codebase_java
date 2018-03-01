package a03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.stream.Stream;
import java.time.temporal.ChronoUnit.*;

/**
 * Created on 02.07.17.
 */
public class DateTime {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2016,6,28,6,0);
        LocalDateTime end = LocalDateTime.of(2016,7,1,12,0);

        // 1)
        long minutes = ChronoUnit.MINUTES.between(start, end);
        System.out.println(minutes);

        //2)
        double minutes2 = Stream.iterate(start, d -> d.plusMinutes(1))
                .limit(ChronoUnit.MINUTES.between(start, end))
                .skip(8*60).count();
        System.out.println(minutes);


        ;
    }
}
