package pmp1_complex;

import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created on 08/04/2017.
 */
public class ComplexTest {
    private Complex c1;
    private Complex c2;
    private Complex c3;
    double[] ary1 = new double[]{3.60555, 33.6901};


    @Before
    public void fixture() {
        c1 = new Complex(3, 2);
        c2 = new Complex(4, 3);
        c3 = new Complex(45, 30);
    }


    @org.junit.Test
    public void add() throws Exception {
        assertEquals(new Complex(7, 5), c1.add(c2));
    }

    @org.junit.Test
    public void sub() throws Exception {
        assertEquals(new Complex(-1, -1), c1.sub(c2));
    }

    @org.junit.Test
    public void mul() throws Exception {
        assertEquals(new Complex(6, 17), c1.mul(c2));

    }

    @org.junit.Test
    public void div() throws Exception {
        assertEquals(new Complex(0.72, -0.04), c1.div(c2));
    }

    @org.junit.Test
    public void abs() throws Exception {
        assertEquals(3.6055512754639892931119221, c1.abs(), 0.e-8);
        //Math.sqrt(Math.pow(3 , 2) + Math.pow(2, 2)
    }

    @org.junit.Test
    public void polar() throws Exception {
        assertArrayEquals(ary1, c1.polar(), 0.00005);
    }


}