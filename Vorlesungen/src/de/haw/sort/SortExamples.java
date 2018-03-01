package de.haw.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 11/04/2017.
 */
public class SortExamples {
    private static double[] doubleArray = new double[11];
    private static String[] stringArray = new String[11];
    private static List<Double> doubleList = new ArrayList<>();
    private static List<Long> longList = new ArrayList<>();
    private static List<String> stringList = new LinkedList<>();



    public static void main(String[] args) {
        fillContainer();
//        sortArray();
        printContainer();
    }

    private static void fillContainer() {
        Random rand = new Random(42);
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = rand.nextDouble();
        }
        try (Scanner sc = new Scanner(new File("/Users/pawel/Desktop/IntelliJ-Projects/Vorlesungen/src/de/haw/sort/SortExamples.java"))) {
            int i = 0;
            while (sc.hasNext() && i < stringArray.length) {
                stringArray[i++] = sc.next();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        longList = Stream.generate(new FibonacciMaker()).limit(50).collect(Collectors.toList());
    }

    private static void sortArray() {
        Arrays.sort(doubleArray);
    }

    private static void printContainer() {
        for (double d : doubleArray) {
            System.out.println(d);
        }
        Arrays.stream(stringArray).forEach(System.out::println);

        for (long f : longList)
            System.out.println(f);
    }

    private static class FibonacciMaker implements java.util.function.Supplier<Long> {
        private long prev = 0;
        private long current = 1;

        @Override
        public Long get() {
            long next = prev + current;
            prev = current;
            current = next;
            return prev;

        }

    }
}
