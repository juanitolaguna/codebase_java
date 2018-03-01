package de.tut.lambdas.basics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created on 18/04/2017.
 */
public class Lambdas2 {
    public static boolean isGreaterThan3(int number) {
        System.out.println("isGreaterThan3" + number);
        return number > 3;
    }

    public static boolean isEven(int number) {
        System.out.println("isEven" + number);
        return number % 2 == 0;
    }

    public static int doubleIt(int number) {
        System.out.println("doubleIt" + number);
        return number * 2;
    }

    public static void main(String[] args) {
        // find the double of the first even numbers greater than 3
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

//        int result = 0;
//        for (int e : values) {
//            if (e > 3 && e % 2 == 0) {
//                result = e * 2;
//                break;
//            }
//        }
//        System.out.println(result);

        /*
        - a Stream is a fancy iterator given in Java 8

        - Higher Order Functions
        - lazy & composition
        - looping will take about 17 operations vs 8 operations
         */
        Predicate<Integer> isGT3 = number -> number > 3;

                values.stream()
                        .filter(isGT3)
                        .filter(Lambdas2::isEven)
                        .map(Lambdas2::doubleIt);
                List<Integer> number = Arrays.asList();

        System.out.println(values);

//                        .get()




    }
}
