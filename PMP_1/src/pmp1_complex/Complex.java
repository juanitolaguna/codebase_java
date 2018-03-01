package pmp1_complex;

/**
 * Created on 29/03/2017.
 */
public class Complex {

    private double real;
    private double imaginary;


    public Complex() {
        this(0, 0);
    }

    public Complex(double r, double i) {
        real = r;
        imaginary = i;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public Complex add(Complex other) {
        double real = this.getReal() + other.getReal();
        double imaginary = this.getImaginary() + other.getImaginary();
        return new Complex(real, imaginary);
    }

    public Complex sub(Complex other) {
        double real = this.getReal() - other.getReal();
        double imaginary = this.getImaginary() - other.getImaginary();
        return new Complex(real, imaginary);
    }

    public Complex mul(Complex other) {
        double real = this.getReal() * other.getReal() - this.getImaginary() * other.getImaginary();
        double imaginary = this.getReal() * other.getImaginary() + other.getReal() * this.getImaginary();
        return new Complex(real, imaginary);
    }

    public Complex div(Complex other) {
        Complex numerator = this.mul(other.conjugate());
        double denominator = Math.pow(other.getReal(), 2) + Math.pow(other.getImaginary(), 2);
        return new Complex(numerator.getReal() / denominator, numerator.getImaginary() / denominator);
    }


    public Complex conjugate() {
        imaginary = this.getImaginary() * (-1);
        return new Complex(this.getReal(), imaginary);
    }

    public double abs() {
        return Math.sqrt(Math.pow(this.getReal(), 2) + Math.pow(this.getImaginary(), 2));
    }


    public double[] polar() {
        double radius = this.abs();
        double angle = 180 * Math.atan2(this.getImaginary(), this.getReal()) / Math.PI;
        double[] polarArray = {radius, angle};
        return polarArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Complex complex = (Complex) o;

        if (Double.compare(complex.real, real) != 0) return false;
        return Double.compare(complex.imaginary, imaginary) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(real);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(imaginary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Complex: " + "real=" + real + ", imaginary=" + imaginary;
    }

}
