package pmp1_complex;

/**
 * Created on 02/04/2017.
 */
public final class MathUtils {

    private MathUtils() {
    }

    public static Complex exp(Complex z) {
        double expReal = Math.exp(z.getReal());
        double r = expReal * Math.cos(z.getImaginary());
        double i = expReal * Math.sin(z.getImaginary());
        return new Complex(r, i);
    }

    public static Complex sin(Complex z) {
        double expOfIm = Math.exp(z.getImaginary());
        double expOfImInverted = 1 / expOfIm;
        double r = Math.sin(z.getReal()) * (expOfIm + expOfImInverted) / 2;
        double i = Math.cos(z.getReal()) * (expOfIm - expOfImInverted) / 2;
        return new Complex(r, i);
    }

    public static Complex cos(Complex z) {
        double expOfIm = Math.exp(z.getImaginary());
        double expOfImInverted = 1 / expOfIm;
        double r = Math.cos(z.getReal()) * (expOfIm + expOfImInverted) / 2;
        double i = -Math.sin(z.getReal()) * (expOfIm - expOfImInverted) / 2;
        return new Complex(r, i);
    }

}
