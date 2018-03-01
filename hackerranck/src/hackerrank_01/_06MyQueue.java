package hackerrank_01;

import java.util.Stack;

/**
 * Created on 07.09.17.
 */
public class _06MyQueue<T> {
    Stack<T> stackNewestOnTop = new Stack<>();
    Stack<T> stackOldestOnTop = new Stack<>();

    public void enque(T value) {
        stackNewestOnTop.push(value);
    }

    public T peek() {
        prepareStack(stackNewestOnTop, stackOldestOnTop);
        T value = stackOldestOnTop.peek();
        return value;
    }

    public T deque() {
        prepareStack(stackNewestOnTop, stackOldestOnTop);
        T value = stackOldestOnTop.pop();
        return value;
    }

    @Override
    public String toString() {
        return "_06MyQueue{" +
                "stackNewestOnTop=" + stackNewestOnTop +
                ", stackOldestOnTop=" + stackOldestOnTop +
                '}';
    }


//    public void prepOldStack() {
//        if (stackOldestOnTop.empty()) {
//            while (!stackNewestOnTop.empty()) {
//                stackOldestOnTop.push(stackNewestOnTop.pop());
//            }
//        }
//    }

    public void prepareStack(Stack<T> first, Stack<T> second){
        if (second.empty()) {
            while (!first.empty()) {
                second.push(first.pop());
            }
        }
    }

    public static void main(String[] args) {
        _06MyQueue<Integer> myQueue = new _06MyQueue<>();
        myQueue.enque(42);
        myQueue.deque();
        myQueue.enque(14);
        System.out.println(myQueue.peek());
        myQueue.enque(28);
        System.out.println(myQueue.peek());
        myQueue.enque(60);
        myQueue.enque(78);
        myQueue.deque();
        myQueue.deque();
        System.out.println(myQueue);
    }
}

