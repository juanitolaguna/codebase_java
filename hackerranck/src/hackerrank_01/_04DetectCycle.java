package hackerrank_01;

/**
 * Created on 05.09.17.
 */
public class _04DetectCycle {

    /*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A _07Node is defined as:
    class _07Node {
        int data;
        _07Node next;
    }
*/

    class Node {
        int data;
        Node next;
    }

    // Lets say the "Z" on the keyboard shows to "S"
    boolean hasCycle(Node head) {
        if (head == null) return false;
        Node slow = head;
        Node fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
