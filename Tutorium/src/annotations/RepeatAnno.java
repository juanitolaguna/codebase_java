package annotations;


import java.lang.annotation.Annotation;
import java.lang.reflect.*;





/**
 * Created on 03.07.17.
 */
public class RepeatAnno {

    @MyAnnotation(str = "First Annotation", val = -1)
    @MyAnnotation(str = "Second Annotation", val = 100)

    public static void myMethod() {
        RepeatAnno ob = new RepeatAnno();
        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMethod");

             Annotation annotation = m.getAnnotation(MyRepeatedAnnotations.class);
            System.out.println(annotation);
        } catch (NoSuchMethodException e) {
            System.out.println("Method no found!");
        }
    }

    public static void main(String[] args) {
        myMethod();
    }

}
