package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created on 03.07.17.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MyRepeatedAnnotations {
    MyAnnotation[] value();
}
