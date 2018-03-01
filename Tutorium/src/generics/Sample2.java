package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 30/04/2017.
 */
public class Sample2 {
    public static <T extends Comparable<T>> void copy(List<T> source, List<T> target) {
        if (target.get(0).compareTo(source.get(0)) != 0) {
            //...
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        copy(list1, list2);
    }
}
//Liskovs substitutions principle: If you are using inheritance, we should use inheritance only when
// there is substitutability
// Inheritance is only to be used whe we want real substitutability.