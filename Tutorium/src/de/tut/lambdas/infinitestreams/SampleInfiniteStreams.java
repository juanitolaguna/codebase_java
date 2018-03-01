package de.tut.lambdas.infinitestreams;

import java.util.stream.Stream;

/**
 * Created on 28/04/2017.
 */
public class SampleInfiniteStreams {
    public static void main(String[] args) {
        System.out.println(Stream.iterate(100, e -> e + 1));

        //Start with 100, create series
        //100, 101, 102, 103, ...
        //infinite streams cannot exist without lazyness
        //lazyness cannot exist without no-side effects
        //no side effects cannot exist without immutability s
    }
}
