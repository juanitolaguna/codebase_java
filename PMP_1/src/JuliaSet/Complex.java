package JuliaSet;

import java.text.DecimalFormat;
/**
 * A mutable Class that represents complex numbers, modeled after
 * the Ruby class Complex.
 * 
 * @author Ben Dzaebel, Edward Abiakin.
 */
public class Complex implements Comparable<Complex>{
	
	/**
	 * a -> The real part of the Complex number.
	 * b -> The imaginary part of the Complex number. 
	 */
	public double a, b;	
	/**
	 * Some constant Complex number that may be useful
	 */
	public static final Complex ONE = new Complex(1);
	public static final Complex ZERO = new Complex();
	
	/**
	 * Maximum number of decimal places for the toString() method.
	 */
	public static int stringPrecision = 4;
	
	//--------------Constructors----------------//
	/**
	 * Default Constructor 
	 */
	public Complex() {
		this(0,0); 
	}
	/** 
	 * Constructor for the rectangular form (a+bi).
	 * @param real the real part of the complex number.
	 * @param imaginary the imaginary part of the complex number.
	 */
	public Complex(double real, double imaginary) {
		a = real;
		b = imaginary;
	}
	/**
	 * Constructor if only the real part is given. b will be 0.
	 * @param real the real part of the complex number.
	 */
	public Complex(double real) {
		a = real;
		b = 0;
	}
	/**
	 * Copy Constructor
	 * @param c an object of type Complex.
	 */
	public Complex(Complex c) {
		this(c.getReal(), c.getImaginary());
	}
	//------------------------------------------//	
	/**
	 * Creates a new Complex object from cartesian coordinates.
	 * @param real the real part of the complex number.
	 * @param imaginary the imaginary part of the complex number.
	 * @return the new Complex instance. 
	 */
	public static Complex ofCartesian(double real, double imaginary) {
		return new Complex(real, imaginary);
	}	
	/**
	 * Creates a new Complex object from polar coordinates.
	 * @param modulus the modulus/abs of the complex number.
	 * @param argument the argument of the complex number.
	 * @return the new Complex instance. 
	 */
	public static Complex ofPolar(double modulus, double argument) {
		return new Complex(modulus * Math.cos(argument), modulus * Math.sin(argument));
	}
	
	/**
	 * @return the real part of the complex number.
	 */
	public double getReal() {
		return a;
	}	
	/**
	 * @return the imaginary part of the complex number.
	 */
	public double getImaginary() {
		return b;
	}	
	/**
	 * @return the modulus/abs of the complex number.
	 */
	public double getModulus() {
		return abs();
	}	
	/**
	 * @return the argument of the complex number.
	 */
	public double getArgument() {
		return Math.atan(b/a);
	}		
	/**
	 * Adds a complex number to the current number. (destructive)
	 * @param c an object of type Complex.
	 * @return reference to itself.
	 */
	public Complex add(Complex c) {
		a += c.getReal();
		b += c.getImaginary();
		return this;
	}
	/**
	 * Subtracts a complex number from the current number. (destructive)
	 * @param c an object of type Complex.
	 * @return reference to itself.
	 */
	public Complex sub(Complex c) {
		a -= c.getReal();
		b -= c.getImaginary();
		return this;
	}	
	/**
	 * Divides the current number by a given complex number. (destructive)
	 * @param c an object of type Complex.
	 * @return reference to itself.
	 */
	public Complex div(Complex c) {
		double real = (a * c.getReal() + b * c.getImaginary()) / c.abs2();
		double im =   (b * c.getReal() - a * c.getImaginary()) / c.abs2();
		a = real;
		b = im;
		return this;
	}	
	/**
	 * Overload for dividing by real numbers. (destructive)
	 * @param value a real value. 
	 * @return reference to itself.
	 */
	public Complex div(double value) {
		return div(new Complex(value));
	}	
	/**
	 * Multiplies the current number with a real scalar. (destructive)
	 * @param scalar a real value to multiply by.
	 * @return @return reference to itself.
	 */
	public Complex mult(double scalar) {
		a *= scalar;
		b *= scalar;
		return this;
	}	
	/**
	 * Multiplies the current number with another complex number. (destructive)
	 * @param c complex number to multiply with.
	 * @return reference to itself.
	 */
	public Complex mult(Complex c) {
		double real =      a * c.getReal() - b * c.getImaginary();
		double imaginary = a * c.getImaginary() + b * c.getReal();
		a = real;
		b = imaginary;
		return this;
	}	
	/**
	 * @return the absolute value of the current number.
	 */
	public double abs() {
		return Math.sqrt(a*a + b*b);
	}	
	/**
	 * @return the absolute value^2 of the current number.
	 */
	public double abs2() {
		return (a*a + b*b);
	}
	
	/**
	 * @return the negation of the current number.
	 */
	public Complex neg() {
		a = -a;
		b = -b;
		return this;
	}
	/**
	 * @return the complex conjugate of the current number.
	 */
	public Complex conjugate() {
		return new Complex(a, -b);
	}	
	
	@Override
	public String toString() {
		char sign = (b >= 0) ? '+' : '-'; 
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(stringPrecision);
		return "(" + df.format(a) + sign + df.format(Math.abs(b)) + "i)";
	}
	
	@Override
	public int compareTo(Complex other) {
		return (abs() < other.abs()) ? -1 : (abs() > other.abs()) ? 1 : 0;
	}
	
	@Override
	public int hashCode() {
	    long h = Double.doubleToLongBits(a) + Double.doubleToLongBits(b); //harmonization
	    return (int)h ^ (int)(h >>> 32);                                  //combine and s
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complex other = (Complex) obj;
		if (a != other.getReal())
			return false;
		if (b != other.getImaginary())
			return false;
		return true;
	}

}
