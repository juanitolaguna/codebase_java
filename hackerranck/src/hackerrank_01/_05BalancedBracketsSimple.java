package hackerrank_01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 05.09.17.
 */
public class _05BalancedBracketsSimple {

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));

    }

    public static String getComplement(String s) {
        String returnString;
        switch (s) {
            case "{" : returnString = "}"; break;
            case "(" : returnString = ")"; break;
            case "[" : returnString = "]"; break;
            default: returnString = s;
        }
        return returnString;
    }

    public static boolean isBalanced(String expression) {
        boolean b = true;
        LinkedList<String> expressionList =
                Stream.of(expression.split(""))
                        .collect(Collectors.toCollection(LinkedList::new));

        System.out.println(expression.length());

        while (!expressionList.isEmpty() && b) {
            b = getComplement(expressionList.pollFirst()).equals(expressionList.pollLast());
        }
        return b;
    }

}
