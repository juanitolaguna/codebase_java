package pmp3_io;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 05.05.17.
 */
public class
SortByLastWord2 {
    public static List<List<String>> sort(String filepath) {
        List<String> listOfStrings = SimpleIO.readToList(filepath);
        //clean up List
        listOfStrings = listOfStrings.stream()
                .filter(e -> !e.isEmpty())
                .collect(Collectors.toList());

        List<List<String>> twoDimList = new ArrayList<>();
        List<String> line;

        for (String text : listOfStrings) {
            // split line to Array
            line = Arrays.asList(text.split(" "));
            twoDimList.add(line);
        }

        twoDimList.sort(compareLastWord());
//        for (List<String> satz : twoDimList) {
//            System.out.println(String.join(" ", satz));
//        }

        return twoDimList;
    }

    public static boolean check(List<List<String>> list) {
        List<String> l1;
        List<String> l2;
        String s1;
        String s2;

        boolean b = false;
        for (int i = 0; i < list.size() - 1; i++) {

            l1 = list.get(i);
            l2 = list.get(i + 1);
            s1 = l1.get(l1.size() - 1).equals("-") ? l1.get(l1.size() - 2) : l1.get(l1.size() - 1);
            s2 = l2.get(l2.size() - 1).equals("-") ? l2.get(l2.size() - 2) : l2.get(l2.size() - 1);

            b = s1.toLowerCase().compareTo(s2.toLowerCase()) <= 0 == true;
            if (b == false) {
                break;
            }
        }
        return b;
    }


    private static Comparator<List<String>> compareLastWord() {
        return Comparator.comparing(w -> !w.get(w.size() - 1).equals("-") ?
                w.get(w.size() - 1).toLowerCase() : w.get(w.size() - 2).toLowerCase());
    }
}
