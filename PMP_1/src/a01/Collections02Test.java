package a01;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

/**
 * Testfälle für die Methoden in der Utility-Klasse a01.Collections02.
 *
 * @author Bernd Kahlbrandt
 */
public class Collections02Test {
    public static double EPS = 1.0E-6;
    private static Integer[] aNullGerade = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static Integer[] aNullUngerade = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static Integer[] aGerade = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static Integer[] aUngerade = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static Integer[] aMaxMin1 = {Integer.MAX_VALUE, Integer.MIN_VALUE};
    private static Integer[] aMaxMin2 = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};
    private static Integer[] aMax1 = {Integer.MAX_VALUE, Integer.MAX_VALUE, -Integer.MAX_VALUE, -Integer.MAX_VALUE};
    /**
     * Gerade Anzahl von int 0.
     */
    private static List<Integer> aListNullGerade = Arrays.asList(aNullGerade);
    /**
     * Ungerade Anzahl von int 0.
     */
    private static List<Integer> aListNullUngerade = Arrays.asList(aNullUngerade);
    /**
     * Gerade Anzahl von int's, die zu keiner {@link java.lang.ArithmeticException} führen dürfen.
     */
    private static List<Integer> aListGerade = Arrays.asList(aGerade);
    /**
     * Ungerade Anzahl von int's, die zu keiner {@link java.lang.ArithmeticException} führen dürfen.
     */
    private static List<Integer> aListUngerade = Arrays.asList(aUngerade);
    /**
     * Betragsmäßig große int's mit unterschiedlichen Vorzeichen,
     * die zu keiner {@link java.lang.ArithmeticException} führen dürfen.
     */
    private static List<Integer> aListMaxMin1 = Arrays.asList(aMaxMin1);
    /**
     * Betragsmäßig große int's mit unterschiedlichen Vorzeichen,
     * die zu einer {@link java.lang.ArithmeticException} führen müssen.
     */
    private static List<Integer> aListMaxMin2 = Arrays.asList(aMaxMin2);
    /**
     * Betragsmäßig große int's mit unterschiedlichen Vorzeichen,
     * die je nach Implementierung zu einer {@link java.lang.ArithmeticException} führen oder nicht.
     */
    private static List<Integer> aListMax1 = Arrays.asList(aMax1);
    /**
     * Eine Liste der size {@link java.lang.Integer#MAX_VALUE}. Dient zum Testen von Aufgabenteil 1.
     */
    private static List<Integer> intMaxList = new List<Integer>() {

        @Override
        public int size() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return null;
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Integer e) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Integer> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Integer> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Integer get(int index) {
            return null;
        }

        @Override
        public Integer set(int index, Integer element) {
            return null;
        }

        @Override
        public void add(int index, Integer element) {

        }

        @Override
        public Integer remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Integer> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Integer> listIterator(int index) {
            return null;
        }

        @Override
        public List<Integer> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    /**
     * Zum Test von Aufgabenteil 1.
     */
    private static Collection<Collection<Integer>> cc = Arrays.asList(aListNullUngerade, aListNullGerade);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testSumExact01() {
        assertEquals(0, Collections02.sumExact01(aListNullGerade));
        assertEquals(0, Collections02.sumExact01(aListNullUngerade));
        assertEquals(45, Collections02.sumExact01(aListGerade));
        assertEquals(45, Collections02.sumExact01(aListUngerade));
        assertEquals(-1, Collections02.sumExact01(aListMaxMin1));
    }

    	@Test
	public void testSumExact02() {
		assertEquals(0, Collections02.sumExact02(aListNullGerade));
		assertEquals(0, Collections02.sumExact02(aListNullUngerade));
		assertEquals(45, Collections02.sumExact02(aListGerade));
		assertEquals(45, Collections02.sumExact02(aListUngerade));
		assertEquals(Integer.MAX_VALUE - 1, Collections02.sumExact02(aListMaxMin2));
		assertEquals(0, Collections02.sumExact02(aListMax1));

	}
//
    @Test(expected = ArithmeticException.class)
    public void testsumExact01Exception1() {
        assertEquals(Integer.MAX_VALUE - 1, Collections02.sumExact01(aListMaxMin2));
    }

    @Test(expected = ArithmeticException.class)
    public void testsumExact01Exception2() {
        assertEquals(0, Collections02.sumExact01(aListMax1));
    }

    @Test(expected = ArithmeticException.class)
    public void testsumExact02Exception1() {
        assertEquals(0, Collections02.sumExact01(aListMax1));
    }

    @Test(expected = ArithmeticException.class)
    public void testsumExact02Exception2() {
        assertEquals(Integer.MAX_VALUE - 1, Collections02.sumExact01(aListMaxMin2));
    }

    @Test
    public void testGetBiggest() {
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), Collections02.getBiggest(aListMaxMin2));
        assertEquals(Integer.valueOf(0), Collections02.getBiggest(aListNullGerade));
    }

    @Test
    public void testAverageSize() {
        assertEquals(10.5, Collections02.averageSize(cc), EPS);
        assertEquals(Integer.MAX_VALUE, Collections02.averageSize(Arrays.asList(intMaxList, intMaxList)), EPS);
    }

}
