package JuliaSet;


public class JuliaSet {

    public static Complex c = new Complex(0, 0);

    public static double calc(double x, double y, int iterations) {
        Complex z0 = new Complex(x, y);
        Complex current = new Complex(x, y);
        double r = Math.max(c.abs(), 2);

        int i;
        for (i = 0; i <= iterations; i++) {
            current.mult(current).add(c);
            if (current.abs() > r) break;
        }

        if (i >= iterations) return -1;
        else return i;
    }
}
