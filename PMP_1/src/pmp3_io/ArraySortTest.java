package pmp3_io;

import org.junit.*;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

/**
 * Created on 04.05.17.
 */
public class ArraySortTest {
    private String path;
    private String[] sAry;
    List<String> sortedList;

    @Before
    public void fixture() {
        path = "/Users/pawel/Desktop/IntelliJ-Projects/PMP_1/src/pmp3_io/picasso.txt";
        List<String> newList = SimpleIO.readToList(path);
        newList = newList.stream()
                .filter(e -> !e.isEmpty())
                .collect(Collectors.toList());

        sAry = new String[newList.size()];
        sAry = newList.toArray(sAry);
        Arrays.sort(sAry);

        sortedList = ArraySort.sort(path);
    }

    @org.junit.Test
    public void main() throws Exception {
        assertNotNull(sAry[0]);
        assertEquals(
                sAry[4].toString() , "Der Maler Pablo Picasso schreibt an seinen Kunsthändler Daniel-Henry Kahnweiler"
        );
        assertEquals(
                sAry[44].toString() , "wird ab sofort naiv gemalt."
        );

        assertTrue(ArraySort.check(sortedList));
    }

}