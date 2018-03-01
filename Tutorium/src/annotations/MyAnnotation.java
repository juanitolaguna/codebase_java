package annotations;
import java.lang.annotation.*;

/**
 * Created on 03.07.17.
 */

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnotations.class)
public @interface   MyAnnotation {
    String str() default "Testing";
    int val() default 9000;
}
