package pmp3_io;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created on 06.05.17.
 */
public class SortByLastWordTest {
    private List<List<String>> result;
    private List<List<String>> expected;

    @Before
    public void fixture() {
        String filepath1 = "/Users/pawel/Desktop/IntelliJ-Projects/PMP_1/src/pmp3_io/picasso.txt";
        String filepath2 = "/Users/pawel/Desktop/IntelliJ-Projects/PMP_1/src/pmp3_io/picasso_sortiert.txt";

         result = SortByLastWord2.sort(filepath1);
         expected = SimpleIO.readToTwoDim(filepath2);

//        for (List<String> satz : expected) {
//            System.out.println(String.join(" ", satz));
//        }
    }

    @Test
    public void sort() throws Exception {

        assertNotNull(result);
        assertEquals(expected,result);
        assertTrue(SortByLastWord2.check(result));


    }

}