package pmp2;

/**
 * Created on 23/04/2017.
 */
public class Timeit {
    public static void code(Runnable code) {
        long start = System.nanoTime();

        try {
            code.run();
        } finally {
            long end = System.nanoTime();
            System.out.println("Time taken(s)" + (end - start)/1.0e9);
        }

    }
}
