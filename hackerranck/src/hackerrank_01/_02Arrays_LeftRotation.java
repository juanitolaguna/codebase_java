package hackerrank_01;

import java.util.Arrays;

/**
 * Created on 28.08.17.
 */
public class _02Arrays_LeftRotation {

    static int[] ary = {1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateLeft(ary, 3)));
    }

    private static int[] rotateLeft(int[] a, int d) {
        int length = a.length;
        int[] rotated = new int[length];

        System.arraycopy(a, d, rotated, 0, length - d);
        System.arraycopy(a, 0, rotated, length - d, d);
        return rotated;
    }



}
