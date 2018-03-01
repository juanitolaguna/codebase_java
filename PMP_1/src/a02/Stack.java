package a02;

import java.util.EmptyStackException;
import java.util.Observable;

/**
 * Created on 02.07.17.
 */
public class Stack<T> implements IStack {
    private StackElement<T> top = null;
    private long counter = 0;

    @Override
    public void push(Object o) {
        top = new StackElement(top, o);
        counter++;
    }

    @Override
    public Object pop() throws EmptyStackException {
        T value;
            if (counter == 0) {
                throw new EmptyStackException();
            } else {
                value = top.value;
                top = top.prev;
                counter--;
            }
        return value;
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    private static class StackElement<T> {
        StackElement<T> prev;
        T value;

        public StackElement(StackElement prev, T value) {
            this.prev = prev;
            this.value = value;
        }

    }


}
