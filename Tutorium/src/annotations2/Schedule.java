package annotations2;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.MonthDay;

/**
 * Created on 03.07.17.
 */

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Schedules.class)
public @interface Schedule {
    DayOfWeek dayOfWeek() default DayOfWeek.MONDAY;
    int dayOfMonth() default 1;
    int hour() default 12;
}
