package pmp4;

import java.math.BigDecimal;

/**
 * Created on 19.05.17.
 */
public class NumericPrecision {
    public static float npFloat1(float r, float p, int n) {
        if (n < 0) throw new IllegalArgumentException("n darf nich kleiner 0 sein");

        for (int i = 0; i <= n; i++) {
            p = (p + r * p * (1 - p));
        }
        return p;
    }

    public static float npFloat2(float r, float p, int n) {
        if (n < 0) throw new IllegalArgumentException("n darf nich kleiner 0 sein");

        for (int i = 0; i <= n; i++) {
            p = (r + 1) * p - r * (p * p);
        }
        return p;
    }

    public static float npFloat3(float r, float p, int n) {
        if (n < 0) throw new IllegalArgumentException("n darf nich kleiner 0 sein");

        for (int i = 0; i <= n; i++) {
            p = p * (r + 1 - r * p);
        }
        return p;
    }

    public static float npFloat4(float r, float p, int n) {
        if (n < 0) throw new IllegalArgumentException("n darf nich kleiner 0 sein");

        for (int i = 0; i <= n; i++) {
            p = p * (1 - r * p) + r * p;
        }
        return p;
    }


    public static double npDouble1(double r, double p, int n) {
        if (n < 0) throw new IllegalArgumentException("n darf nich kleiner 0 sein");
        for (int i = 0; i <= n; i++) {
            p = (p + r * p * (1 - p));
        }
        return p;
    }

    public static double npDouble2(double r, double p, int n) {
        if (n < 0) throw new IllegalArgumentException("n darf nich kleiner 0 sein");
        for (int i = 0; i <= n; i++) {
            p = (r + 1) * p - r * (p * p);
        }
        return p;
    }

    public static double npDouble3(double r, double p, int n) {
        if (n < 0) throw new IllegalArgumentException("n darf nich kleiner 0 sein");
        for (int i = 0; i <= n; i++) {
            p = p * (r + 1 - r * p);
        }
        return p;
    }

    public static double npDouble4(double r, double p, int n) {
        if (n < 0) throw new IllegalArgumentException("n darf nich kleiner 0 sein");
        for (int i = 0; i <= n; i++) {
            p = p * (1 - r * p) + r * p;
        }
        return p;
    }

    public static BigDecimal npBD1(BigDecimal r, BigDecimal p, int n) {
        if (n < 0) throw new IllegalArgumentException("n darf nich kleiner 0 sein");

        BigDecimal bg1 = new BigDecimal(1);
        for (int i = 0; i <= n; i++) {
            p = (p.add(r.multiply(p.multiply(bg1.subtract(p)))));
        }
        return p;
    }

    public static BigDecimal npBD2(BigDecimal r, BigDecimal p, int n) {
        if (n < 0) throw new IllegalArgumentException("n darf nich kleiner 0 sein");

        BigDecimal bg1 = new BigDecimal(1);
        for (int i = 0; i <= n; i++) {
            p = ((r.add(bg1)).multiply(p).subtract(r)).multiply(p).pow(2);
        }
        return p;
    }

    public static BigDecimal npBD3(BigDecimal r, BigDecimal p, int n) {
        if (n < 0) throw new IllegalArgumentException("n darf nich kleiner 0 sein");

        BigDecimal bg1 = new BigDecimal(1);
        for (int i = 0; i <= n; i++) {
            p = p.multiply((r.add(bg1).subtract(r).multiply(p)));
        }
        return p;
    }

    public static BigDecimal npBD4(BigDecimal r, BigDecimal p, int n) {
        if (n < 0) throw new IllegalArgumentException("n darf nich kleiner 0 sein");

        BigDecimal bg1 = new BigDecimal(1);
        for (int i = 0; i <= n; i++) {
            p = p.multiply((bg1.subtract(r).multiply(p))).add(r).multiply(p);
        }
        return p;
    }


    public static void main(String[] args) {
        System.out.println(npFloat1(3, 0.01F, 20));
        System.out.println(npFloat2(3, 0.01F, 20));
        System.out.println(npFloat3(3, 0.01F, 20));
        System.out.println(npFloat4(3, 0.01F, 20));
        System.out.println();


        System.out.println(npDouble1(3, 0.01, 20));
        System.out.println(npDouble2(3, 0.01, 20));
        System.out.println(npDouble3(3, 0.01, 20));
        System.out.println(npDouble4(3, 0.01, 20));
        System.out.println();


        System.out.println(npBD1(new BigDecimal(3),  new BigDecimal(0.01), 5));
        System.out.println(npBD2(new BigDecimal(3),  new BigDecimal(0.01), 5));
        System.out.println(npBD3(new BigDecimal(3),  new BigDecimal(0.01), 5));
        System.out.println(npBD4(new BigDecimal(3),  new BigDecimal(0.01), 5));
        System.out.println();


//        System.out.println();
//
//        System.out.println(npFloat1(3,  0.01F, 50));
//        System.out.println(npDouble1(3,  0.01, 50));
//        System.out.println(npBD1(new BigDecimal(3),  new BigDecimal(0.01), 50));
//        System.out.println();
//
//        System.out.println(npFloat1(3,  0.01F, 100));
//        System.out.println(npDouble1(3,  0.01, 100));
//        System.out.println(npBD1(new BigDecimal(3),  new BigDecimal(0.01), 100));
//        System.out.println();
//
//        System.out.println(npFloat1(3,  0.01F, 1000));
//        System.out.println(npDouble1(3,  0.01, 1000));
//        System.out.println(npBD1(new BigDecimal(3),  new BigDecimal(0.01), 1000));
//        System.out.println();
//
//        System.out.println(npFloat1(3,  0.01F, 10000));
//        System.out.println(npDouble1(3,  0.01, 10000));
//        System.out.println(npBD1(new BigDecimal(3),  new BigDecimal(0.01), 10000).doubleValue());
//        System.out.println();
    }
}
