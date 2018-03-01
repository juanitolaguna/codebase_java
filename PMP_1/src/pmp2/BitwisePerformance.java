package pmp2;

/**
 * Created on 29.05.17.
 */
public class BitwisePerformance {

    public static int rightShift() {
        return 60 >> 2;
    }

    public static int leftShift() {
        return 60 << 2;
    }

    public static int bitwiseAnd() {
        return 60 & 2;
    }

    public static int bitwiseXor() {
        return 60 ^ 2;
    }

    public static int bitwiseOr() {
        return 60 | 2;
    }

    public static int bitwiseCompliment() {
        return ~60;
    }

    public static int zerofillRightShift() {
        return 60 >>> 2;
    }


    public static void main(String[] args) {

        Timeit.code(() -> rightShift());
        Timeit.code(() -> leftShift());
        Timeit.code(() -> bitwiseAnd());
        Timeit.code(() -> bitwiseXor());
        Timeit.code(() -> bitwiseOr());
        Timeit.code(() -> bitwiseCompliment());
        Timeit.code(() -> bitwiseCompliment());
        Timeit.code(() -> zerofillRightShift());
    }
}
