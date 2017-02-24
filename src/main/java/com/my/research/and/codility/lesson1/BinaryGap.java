package com.my.research.and.codility.lesson1;

public class BinaryGap {

    private static int evaluateGap(final int v) {
        final String x = Integer.toBinaryString(v);
        int max, tmp;
        max = tmp = 0;
        for (char c : x.toCharArray()) {
            if (c == '0') {
                tmp++;
            } else {
                if (tmp > max) {
                   max = tmp;
                }
                tmp = 0;
            }
        }
        return max;
    }

    private static void test(final int v) {
        System.out.println("v = " + v + ", " + Integer.toBinaryString(v) + " -> " + evaluateGap(v));
    }

    public static void main(String[] args) {
        test(529);
        test(1041);
        test(15);
    }
}
