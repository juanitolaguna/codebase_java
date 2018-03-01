package a02;

import java.util.EmptyStackException;
/**
 * Ein minimalistisches Interface für einen Stack (Last-In First-Out Speicher).
 * @author Bernd Kahlbrandt
 *
 * @param <E> Typ der Elemente im Stack.
 */
public interface IStack<E> {
	/**
	 * Legt eine neues Element auf den Stack.
	 * @param e Das auf den Stack zu legende Element.
	 */
	void push(E e) ;
	/**
	 * Entfernt das oberste Element vom Stack und gibt es zurück.
	 * @return Das oberste Element des Stacks.
	 * @throws EmptyStackException wenn pop auf einem leeren Stack aufgerufen wird.
	 */
	E pop() throws EmptyStackException;
	/**
	 * Liefert <pre><code>true</code></pre>, wenn der Steck leer ist, andernfalls <pre><code>false</code></pre>.
	 * @return <pre><code>true</code></pre>, wenn der Steck leer ist, andernfalls <pre><code>false</code></pre>.
	 */
	boolean isEmpty();
}
