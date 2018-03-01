package pmp3_io;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created on 04.05.17.
 */
public class    SortByLastWord1 {
    public static void main(String[] args) {
        String filepath = "/Users/pawelsnatenkov/Documents/Workspaces_Projects/IntelliJProjects/PMP/PMP_1/src/pmp3_io/picasso.txt";
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

        // 2dimList - group by last elem of each line, set key to lowercase to ignore case when sorting
        Map<String, List<List<String>>> hashList = twoDimList.stream()
                .collect(groupingBy(lastWord()));

        //convert to TreeMap to obtain sorted result.
        Map<String, List<List<String>>> treeMap = new TreeMap<>(hashList);



        for (Map.Entry<String, List<List<String>>> entry : treeMap.entrySet()) {
//            System.out.println(entry);
            for (List<String> text : entry.getValue()) {
                System.out.println(String.join(" ", text));
            }
        }

        System.out.println(hashList);
    }

    private static Function<List<String>, String> lastWord() {
        return e -> !e.get(e.size() - 1).equals("-") ?
                e.get(e.size() - 1).toLowerCase() : e.get(e.size() - 2).toLowerCase();
    }


}
