package generics;

/**
 * Created on 01/05/2017.
 */
public class Box<T> {
    private T object;

    public void set(T object) {
        this.object = object;
    }

    public T get() {
        return object;
    }
}
