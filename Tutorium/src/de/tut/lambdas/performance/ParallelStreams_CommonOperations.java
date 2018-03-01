package de.tut.lambdas.performance;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 21/04/2017.
 */
public class ParallelStreams_CommonOperations {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Timeit.code(() ->
                System.out.println(
                        numbers.parallelStream()
                                .filter(e -> e % 2 == 0)
                                .mapToInt(ParallelStreams_CommonOperations::compute) // we do not need parameter because it is a stream(???)
                                .sum()));


        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2.0)
                        .reduce(0.0, (carry, e) -> carry + e)

        );


        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToDouble(e -> e * 2.0)
                        .sum()

        );


    }

    public static int compute(int number) {
        // assume this is time intensive
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
        }

        return number * 2;
    }

/*
     Just because you can parallelize it doesnt mean that you should do it...
     reasons: parallelStream means -v I do not mind using a lot of threads(a lot of resources)
     so i can get the answer faster.
     Lambdas are cool but streams are awsome:
     Stream is an abstraction not a physical object. Set, List, Map is a collection of data.
     A stream is a bunch of functions you will evaluate eventually , (there is no data sitting in a stream),
     unlike a list or a set, you cannot point to a data in a stream - it doesn't exist.  Its a non mutating pipeline.
     Passing from function to function, you are not mutating the collection, and avoiding shared mutability - which is
     not to change things in a shared context.(?)

    FUNCTIONS:
    - filter: take the values in a stream, block some and let some gop through
    - input: Stream<T> filter takes Predicate<T>
    - 0 <= number of elements in the output <= number of input
    ?? - Lambdas are backed by Interfaces.

    - map: transform values
    - number of output == number of input
    - no guarantee on the type of the output with the respect to the type of the input
    - parameter: Stream<T> map takes Function<T, R> to return Stream<R> (transformation operation)
    like for ex. double each of the value.
    see .map(e -> e * 2.0) in is Integer out is Double

    - both, filter and map stay in their swim-lanes

    - reduce cuts across the swim-lanes
    .reduce(0.0, (carry, e) -> carry + e)); => 60
    - reduce Stream<T> takes two params:
    first param is of type <T>
    second param is of type BiFunction<R, T, R> to produce a result of <R> //<input type, elem type, output type>

                    filter          map         reduce
                                                0.0
                                                 \
            x1      /block                        \
                ---------------------------------  \
            x2      -> let go       x2'             +
            ---------------------------------
            x3      /block
            ---------------------------------
            x4      -> let go       x4'
            ---------------------------------
*/


}
