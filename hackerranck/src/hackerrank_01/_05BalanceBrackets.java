package hackerrank_01;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created on 06.09.17.
 */
public class _05BalanceBrackets {
    public static void main(String[] args) {
        System.out.println(isBalanced("[](){()}"));
    }

    // I have forgotten the break, in the third cycle the stack is emptied and goes to the default
    // which returns false.

    public static boolean isBalanced(String expression) {
        if ((expression.length() % 2) == 1) return false;
        else {
            char[] brackets = expression.toCharArray();
            LinkedList<Character> cList = new LinkedList<>();
            for (char bracket : brackets) {
                switch (bracket) {
                    case '{':
                        cList.addFirst('}');
                        break;
                    case '(':
                        cList.addFirst(')');
                        break;
                    case '[':
                        cList.addFirst(']');
                        break;
                    default:
                        if (cList.isEmpty() || bracket != cList.removeFirst()) return false;
                }
            }
            return cList.isEmpty();
        }
    }
}
