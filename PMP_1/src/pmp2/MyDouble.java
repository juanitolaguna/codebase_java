package pmp2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 30/04/2017.
 */
public class MyDouble {

    private static int sign(long bits) {
        return (bits >> 63 == 0) ? 1 : -1;
    }

    private static int exponent(long bits) {
        return (int) (bits >> 52) & (0x7ff);
    }

    private static long mantissa(long bits) {
        return (exponent(bits) == 0) ?
                (bits & 0xfffffffffffffL) << 1 : (bits & 0xfffffffffffffL) | 0x10000000000000L;
    }

    private static long getIntegerPart(long bits) {
        long mant = mantissa(bits);
        long exp = 1075 - exponent(bits);
        return mant >> exp;
    }

    private static double getFractionalPart(long bits) {
        long number = getIntegerPart(bits);
        long mant = mantissa(bits);
        long exp = exponent(bits) - 1075;
        double dec = mant * Math.pow(2, exp);
        return dec - number;
    }

    public static String toString(double n, int radix) {
        long bits = Double.doubleToLongBits(n);
        int sign = sign(bits);
        long integerPart = getIntegerPart(bits);
        double fractionalPart = getFractionalPart(bits);

        LinkedList<Character> iP = new LinkedList<>(); //integer Part
        List<Character> fP = new ArrayList<>(); // fractionalPart

        char digit;
        long mod;
        while (integerPart != 0) {
            mod = integerPart % radix;
            integerPart = integerPart / radix;
            digit = (mod < 10) ? (char) (48 + mod) : (char) (55 + mod);
            iP.addFirst(digit);
        }


        while (fractionalPart != 0) {
            fractionalPart = fractionalPart * radix;

            //cut away whole number
            long num = getIntegerPart(Double.doubleToLongBits(fractionalPart));
            fractionalPart = fractionalPart - num;

            digit = (num < 10) ? (char) (48 + num) : (char) (55 + num);
            fP.add(digit);
        }


        String s = (sign == -1) ? "-" : "";
        String iPart = iP.stream().map(Object::toString).collect(Collectors.joining());
        String fPart = fP.stream().map(Object::toString).collect(Collectors.joining());

        return s + iPart + '.' + fPart;
    }


    public static void main(String[] args) {
        String pi = MyDouble.toString(Math.PI, 16);
        String digit = MyDouble.toString(18.04, 2);
        String digit2 = MyDouble.toString(Math.PI, 2);
        System.out.println(pi);
        System.out.println(digit);
        System.out.println(digit2);

    }

}