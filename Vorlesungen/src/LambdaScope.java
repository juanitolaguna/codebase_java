import java.util.function.Consumer;

/**
 * Created on 25/04/2017.
 */
public class LambdaScope {
    private double x = 3.14;

    public void blah() {
        someMethod(x -> x += this.x);
    }
    public static void main(String[] args) {

    }

    private void someMethod(Consumer<Double> object) {
        // TODO
    }
}

// Funktionale Interfaces
