package de.tut.lambdas.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;

/**
 * Created on 21/04/2017.
 */
public class Collect {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

        // double the even values and put that into a list


        //wrong way
        List<Integer> doubleOfEven = new ArrayList<>();


        numbers.stream()
                .filter(getEven())
                .mapToInt(doubleValueInt())
                .forEach(doubleOfEven::add);
        System.out.println(doubleOfEven);
        // Do not do this.
        // mutability is OK, sharing is nice, shared mutability is devils work
        // friends don't let friends do shared mutation.
        // potentially you're running this in a parallel stream, multipe streams change this variable at the same time.
        // So we can lose some data


        List<Integer> doubleOfEven2 =
                numbers.stream()
                        .filter(getEven())
                        .map(doubleValue())
                        .collect(Collectors.toList());
        System.out.println(doubleOfEven2);
        // you can put ist to Set rather than to a List to avoid duplicates;



    }

    private static ToIntFunction<Integer> doubleValueInt() {
        return e -> e * 2;
    }

    private static Function<Integer, Integer> doubleValue() {
        return e -> e * 2;
    }

    private static Predicate<Integer> getEven() {
        return e -> e % 2 == 0;
    }

}
