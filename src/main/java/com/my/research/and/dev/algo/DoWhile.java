package com.my.research.and.dev.algo;

public class DoWhile {

    public static void main(final String[] args) {
        final int[] ints = new int[] {9,9,9,8,7,1,0};
        int value = 9;
        int prev = 0;
        do {
            System.out.println(prev + " / " + ints[prev]);
            prev++;
        } while (ints[prev] == value);
        System.out.println(prev + " / " + ints[prev]);
    }
}
