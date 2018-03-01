package generics;

import java.util.ArrayList;

/**
 * Created on 30/04/2017.
 */
public class Sample {
    // not totaly useles, generics have introduced a solution for a problem which exists in a static typed language
    // but for the amount of complexity that has been introduced in solving the problem,
    // you always gonna wonder "is it worth it?
    // counterpart .Net did a good job in implementing generics, the reason is,
    // the generic implementation in .Net has a reificatrion(?) which doesnt exist in Java today

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        System.out.println(total);
    }

}
