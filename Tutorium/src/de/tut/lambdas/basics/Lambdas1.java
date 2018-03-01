package de.tut.lambdas.basics;

import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created on 18/04/2017.
 */
public class Lambdas1 {
    public static void main(String[] args) {
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));

//        System.out.println(isDivisible(5));
    }

    private static boolean isPrime(final int number) {
//        imperative - saying how
//        mutability
//        for (int i = 2; i < number; i++) {
//            if (number % i == 0) return false;
//        }
//        return number > 1;

//        Declarative
//        what
//        immutability
        return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
    }

    // ??? this part is unclear

//    private static boolean isDivisible(final int number) {
//        Predicate<Integer> isDivisible = divisor -> number % divisor == 0;
//        return number > 1 && IntStream.range(2, number).noneMatch(index -> isDivisible(index));
//    }
}
