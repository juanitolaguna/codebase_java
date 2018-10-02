package hackerrank_01;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 30.08.17.
 */
public class _01Anagrams {

    private static String a = "cabcc";
    private static String b = "deccc";

    public static void main(String[] args) {
        System.out.println(countDeletions(a, b));

    }

    private static long countDeletions(String first, String second) {

//        for (int c = 32; c < 128; c++) {
//            System.out.println(c + ": " + (char) c);
//        }

        int[] lettercounts = new int[26];

        for (char c : first.toCharArray()) {
            lettercounts[c - 'a']++;
        }
//        System.out.println(Arrays.toString(lettercounts));

        for (char c : second.toCharArray()) {
            lettercounts[c - 'a']--;
        }

//        System.out.println(Arrays.toString(lettercounts));

        int count = Arrays.stream(lettercounts).map(Math::abs).sum();

        return count;  
    }
}
