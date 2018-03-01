package pmp3_io;

import java.util.*;

/**
 * Created on 05.05.17.
 */
public class BinarySearch {
    public static void main(String[] args) {
        String filepath = "/Users/pawel/Desktop/IntelliJ-Projects/PMP_1/src/pmp3_io/picasso.txt";
        List<String> listOfStrings = SimpleIO.readToList(filepath);
        String[] text = String.join(" ", listOfStrings).split(" ");
        List<String> text2 = Arrays.asList(String.join(" ", listOfStrings).split(" "));

        Arrays.sort(text);
        text2.sort(String::compareTo);

        System.out.println("Array:");
        System.out.println("The index of \"Tarif\" is: " + Arrays.binarySearch(text, "Tarif"));
        System.out.println("The index of \"naiv\" is: " + Arrays.binarySearch(text, "naiv") + "\n");

        System.out.println("List:");
        System.out.println("The index of \"Tarif\" is: " + Collections.binarySearch(text2, "Tarif"));
        System.out.println("The index of \"naiv\" is: " + Collections.binarySearch(text2, "naiv"));


    }
}
