package de.tut.lambdas.basics;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 21/04/2017.
 */
public class FunctionComposition {
    public static void main(String[] args) {
        //given the values, double the even numbers and total
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int result = 0;
        for (int e : numbers) {
            if (e % 2 == 0) {
                result += e * 2;
            }
        }
        System.out.println(result);

        // Stream is a fancy iterator with a wealth of functions
        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> e * 2)
                        .sum()
        );

    }
}
