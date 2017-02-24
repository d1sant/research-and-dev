package com.my.research.and.codility.lesson2;

import java.util.Arrays;

public class CyclicRotation {

    public static int[] rotate(int[] A, int K) {
        // write your code in Java SE 8
        final int[] b = new int[A.length];
        for (int i = 0; i < b.length; i++) {
            int index = Math.abs((i + K) % b.length);
            System.out.println(index);
            b[index] = A[i];
        }
        return b;
    }

    public static void main(String[] args) {
        test(3, 3, 8, 9, 7, 6);
        test(0,  3, 7);
        test(1,  3, 7);
        test(2,  3, 7);
        test(3, 1, 2, 3, 4, 5);
        test(4, 1, 2, 3, 4, 5);
        test(42, 1, 1, 2, 3, 5);
    }

    private static void test(int k, int... a) {
        System.out.println("k = " + k + " , " + Arrays.toString(a) + " -> " + Arrays.toString(rotate(a, k)));
    }
}
