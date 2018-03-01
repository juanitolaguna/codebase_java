package a01;

import java.util.*;


/**
 * Created on 01.07.17.
 */
public class Collections02 {

    public static <T> Double averageSize(Collection<Collection<T>> col) {
        return col.stream().mapToDouble(Collection::size).average().orElse(Integer.MAX_VALUE);
    }

    public static <T extends Comparable> T getBiggest(Collection<? extends T> col) {
        return col.stream().max(Comparable::compareTo).get();
    }

    public static <T extends Integer> int sumExact01(List<T> list) {
        return list.stream().mapToInt(e -> e).reduce((a, b) -> {
            if (b > 0 ? a > Integer.MAX_VALUE - b : a < Integer.MIN_VALUE - b) {
                throw new ArithmeticException();
            }
            return a + b;

        }).orElse(0);
    }


    public static <T extends Integer> int sumExact02(List<T> list) throws ArithmeticException {
        return list.stream().mapToInt(e -> e).reduce((a, b) -> {
            int c;
            try {

                if (b > 0 ? a > Integer.MAX_VALUE - b : a < Integer.MIN_VALUE - b) {
                    throw new ArithmeticException();
                }

            } catch (ArithmeticException e) {
                e.printStackTrace();
            } finally {
                c = a + b;
            }
            return c;
        }).orElse(0);

    }


}
