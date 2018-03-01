package samples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class LazyStreams {
    static long counter = 0l;

    public static void main(String[] args) {

        //filter first by the less common, it increases performance

        TimeitInstance time1 = new TimeitInstance();
        TimeitInstance time2 = new TimeitInstance();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();


        time1.code(() -> IntStream.iterate(1, n -> n + 1).limit(100).filter(e -> e % 2  == 0).peek(e -> add(e, list1))
                .filter(e -> e % 7 == 0).peek(e -> add(e, list2)).forEach(e -> System.out.print("")));


//        time2.code(() -> IntStream.iterate(1, n -> n + 1).limit(100).filter(e -> e % 2 == 0).peek(e -> list3.add(e))
//                .filter(e -> e % 7 == 0).peek(e -> list4.add(e)).forEach(e -> System.out.print("")));


        System.out.println();
        System.out.println(list1);
        System.out.println(list2);
        System.out.println();

        System.out.println(counter);
//        System.out.println(list3);
//        System.out.println(list4);
//        System.out.println();

//        System.out.println(time1.isFaster(time2));
//        System.out.println(time2.isFaster(time1));

//		System.out.println(time1.fasterTimes(time2));
//		System.out.println(time2.fasterTimes(time1));


    }

    private static void add(int e, List<Integer> list) {
        list.add(e);
        counter++;
        System.out.println("Added: " + e);
    }

    public static <T> void printStreamAsList(Stream<T> s, String message) {
        System.out.printf("%s: %s.%n", message, s.collect(Collectors.toList()));
    }
}

