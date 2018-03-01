package pmp3_io;

import org.junit.*;


import static org.junit.Assert.*;

/**
 * Created on 02.05.17.
 */
public class SimpleIOTest {
    private String path1;

    public SimpleIOTest() {
    }

    @Before
    public void fixture() {
        path1 = "/Users/pawel/Desktop/IntelliJ-Projects/PMP_1/src/pmp3_io/picasso.txt";
    }

    @org.junit.Test
    public void get() throws Exception {
        assertNotNull(SimpleIO.readToList(path1));
        assertEquals("Der Maler Pablo Picasso schreibt an seinen Kunsthändler Daniel-Henry Kahnweiler",
                SimpleIO.readToList(path1).get(0));
        assertEquals("Wird ich nicht nach Tarif bezahlt,",
                SimpleIO.readToList(path1).get(16));
        assertEquals("ihm nur noch Herrn Incasso nennt.",
                SimpleIO.readToList(path1).get(65));
        assertEquals("",
                SimpleIO.readToList(path1).get(58));

    }
}