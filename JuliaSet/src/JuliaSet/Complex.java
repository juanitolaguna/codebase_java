package JuliaSet;

public class Complex {

    private double re;
    private double im;

    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }


    public Complex plus(Complex b) {
        re += b.re;
        im += b.im;
        return this;
    }

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public double lengthSQ() {
        return re * re + im * im;
    }

    public Complex times(Complex b) {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        re = real;
        im = imag;
        return this;

    }

    @Override
    public String toString() {
        return "ComplexConstant: re = " + getRe() + " im = " + getIm();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Complex complex = (Complex) o;

        if (Double.compare(complex.re, re) != 0) return false;
        return Double.compare(complex.im, im) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(re);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(im);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
