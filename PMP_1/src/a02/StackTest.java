package a02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * Diese Klasse enthält Testfälle, die Ihnen in der Klausur helfen sollen, Ihren
 * Code auf elementare Fehler zu überprüfen. Ich teste:
 * <ul>
 * <li>Die Zeilen aus data/riesenhasen.txt</li>
 * </ul>
 * 
 * @author Bernd Kahlbrandt
 *
 */
public class StackTest {
	/**
	 * Ein Stack von {@link java.lang.String} zum Testen.
	 */
	private IStack<String> stringStack;
	/**
	 * Ein {@link java.util.Deque} zum Testen der Korrektheit der
	 * {@link a02.IStack}-Implementierung
	 */
	private Deque<String> stringControllStack;
	private List<IStack<String>> listToFillAHash = new LinkedList<>();
	private Map<IStack<String>, Boolean> hash = new HashMap<>();

	/**
	 * Legt eine neuen leeren Stack von Strings an.
	 */
	@Before
	public void setUp() {
		stringStack = new Stack<>();
		stringControllStack = new LinkedList<>();
		for (int i = 0; i < 11; i++) {
			listToFillAHash.add(new Stack<>());
		}
	}

	/**
	 * Füllt einen Stack von Strings mit den Zeilen aus data/riesenhasen.txt.
	 */
	private void createTestData() {
		Random rand = new Random();
		try {
			Files.lines(Paths.get("/Users/pawel/Desktop/IntelliJ-Projects/PMP_1/src/a02/picasso.txt")).forEach(this.stringStack::push);
			Files.lines(Paths.get("/Users/pawel/Desktop/IntelliJ-Projects/PMP_1/src/a02/picasso.txt")).forEach(this.stringControllStack::addLast);
			Files.lines(Paths.get("/Users/pawel/Desktop/IntelliJ-Projects/PMP_1/src/a02/picasso.txt")).forEach(listToFillAHash.get(rand.nextInt(10))::push);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (IStack<String> stack : listToFillAHash) {
			hash.put(stack, stack.isEmpty());
		}
	}

	/**
	 * Hier test ich:
	 * <ul>
	 * <li>Ob ein Stack in den ein Element gelegt wurde nicht leer ist. Es
	 * werden also auch {@link IStack#pop} und {@link IStack#isEmpty} verwendet.
	 * </li>
	 * <li>Ich füge die Zeilen aus data/riesenhasen.txt mittels
	 * {@link IStack#push} in den Stack ein und prüfe, ob der Stack nicht leer
	 * ist und prüfe durch Vergleich mit einem Deque, ob {@link IStack#pop} die
	 * Zeilen in der richtigen Reihenfolge liefert.</li>
	 * <li>Anschließende teste ich, ob der Stack nun leer ist.</li>
	 * </ul>
	 */
	@Test
	public void testPushPop() {
		this.stringStack.push("42");
		assertFalse(this.stringStack.isEmpty());
		assertEquals("42", this.stringStack.pop());
		assertTrue(this.stringStack.isEmpty());
		createTestData();
		while (!stringControllStack.isEmpty()) {
			assertEquals(stringControllStack.pollLast(), stringStack.pop());
		}
		assertTrue(stringStack.isEmpty());
		
	}

	/**
	 * Hier test ich:
	 * <ul>
	 * <li>Ob bei einem leeren Stack {@link IStack#pop} eine
	 * {@link java.util.EmptyStackException} geworfen wird.
	 * <li></li>
	 * </ul>
	 */

	@Test(expected = EmptyStackException.class)
	public void testPopEmpty() {
		assertEquals("42", stringStack.pop());
	}

	/**
	 * Hier test ich:
	 * <ul>
	 * <li>Ob {@link IStack#pop} bei einem nicht-leeren Stack  keine
	 * {@link java.util.EmptyStackException} geworfen wird.</li>
	 * <li>Ob ein einelementiger Stack nach einem 
	 * {@link a02.IStack#pop} wieder leer ist.</li>
	 * </ul>
	 */
	@Test
	public void testPop() {
		this.stringStack.push("42");
		assertEquals("42", stringStack.pop());
		assertTrue(stringStack.isEmpty());
	}

	/**
	 * Hier test ich:
	 * <ul>
	 * <li>Ob beim leeren Stack {@link a02.IStack#isEmpty()} true liefert.</li>
	 * <li>Ob {@link a02.IStack#isEmpty()} bei einem Dtack mit den Zeilen von
	 * data/riesenhasen.txt false liefert.</li>
	 * </ul>
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(this.stringStack.isEmpty());
		createTestData();
		assertFalse(this.stringStack.isEmpty());
	}


}
