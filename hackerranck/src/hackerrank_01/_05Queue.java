package hackerrank_01;

/**
 * Created on 05.09.17.
 */
public class _05Queue {
    private static class Node {
        private int data;
        private Node next;
        private Node head;
        private Node tail;

        private Node(int data) {
            this.data = data;
        }


        public boolean isEmpty() {
            return head == null;
        }

            public int peek() {
            return head.data;
        }

        public void add(int data) {
            Node node = new Node(data);
            if (tail != null) {
                tail.next = node;
            }
            tail = node;
            if (head == null) {
                head = node;
            }

        }

        public int remove() {
            int data = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return data;

        }
    }
}
