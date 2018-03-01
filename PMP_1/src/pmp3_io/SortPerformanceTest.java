package pmp3_io;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Created on 03.05.17.
 */
public class SortPerformanceTest {
    public static void main(String[] args) {
        String filepath = "/Users/pawel/Desktop/IntelliJ-Projects/PMP_1/src/pmp3_io/picasso.txt";
        List<String> listOfStrings = SimpleIO.readToList(filepath);

        listOfStrings = listOfStrings.stream()
                .filter(e -> !e.isEmpty())
                .collect(Collectors.toList());


        String[] sAry = new String[listOfStrings.size()];
        sAry = listOfStrings.toArray(sAry);

        String[] finalsAry = sAry;
        System.out.print("sort: ");
        Timeit.code(() -> Arrays.sort(finalsAry));
        System.out.print("parallelSort: ");
        Timeit.code(() -> Arrays.parallelSort(finalsAry));
    }
}



