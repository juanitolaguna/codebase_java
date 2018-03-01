package pmp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 02/04/2017.
 */
public class A2_1 {
// Bei negativen Zahlen liefert diese Methode false.
// Die Modulo operation in Java liefert auch negative Zahlen.

//    public static boolean isOdd(int i) {
//        return i % 2 == 1;
//    }

    // Alternative dazu ist:
    public static boolean isOdd(int i){
        return i%2 != 0;
    }


    public static void main(String[] args) {
        System.out.println("1.1");

        // positive zahlen sind OK
        System.out.println(isOdd(33));
        // liefert false bei (i % 2 == 1)
        // liefert true bei  (i % 2 != 0) oder (i % 2 == 1 || i % 2 == -1)
        System.out.println(isOdd(-33));

        System.out.println("1.2");

        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = o1;
        Object o4 = o3;


        //Reflexiv
        System.out.println(o1.equals(o1));

        // Symmetrisch
        System.out.println(o3.equals(o1));

        //Transitiv
        System.out.println(o4.equals(o1));

        java.lang.Double.isNaN(1);




        double[] doubleArray = new double[3];
        System.out.println(Arrays.toString(doubleArray));
        String[] stringArray = new String[3];
        System.out.println(Arrays.toString(stringArray));
        List<MyDouble> doubleList = new ArrayList<>();





        // Knuthsche Implementierung....


    }
}
