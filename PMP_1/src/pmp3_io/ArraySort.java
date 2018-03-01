package pmp3_io;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 04.05.17.
 */
public class ArraySort {

    public static List<String> sort(String filepath) {
        List<String> listOfStrings = SimpleIO.readToList(filepath);

        listOfStrings = listOfStrings.stream()
                .filter(e -> !e.isEmpty())
                .collect(Collectors.toList());

        String[] sAry = new String[listOfStrings.size()];
        sAry = listOfStrings.toArray(sAry);
        Arrays.sort(sAry);
        List<String> list = Arrays.asList(sAry);

        return list;

    }


    public static boolean check(List<String> list) {
        
        boolean b = false;
        for (int i = 0; i < list.size() - 1; i++) {
            b = list.get(i).compareTo(list.get(i + 1)) < 0 == true;
            if (b == false) {
                break;
            }
        }
        return b;
    }
}
