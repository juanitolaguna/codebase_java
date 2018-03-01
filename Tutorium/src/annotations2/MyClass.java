package annotations2;

import com.sun.tools.javap.JavapTask;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created on 03.07.17.
 */
public class MyClass {

    @Schedule(dayOfWeek = DayOfWeek.MONDAY)
    @Schedule(dayOfWeek = DayOfWeek.FRIDAY)
    public static void myMethod1() {
        MyClass mc = new MyClass();

        try {
            Class<?> c = mc.getClass();
            Method method = c.getMethod("myMethod1");
            Annotation anno = method.getAnnotation(Schedules.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        myMethod1();
    }
}
