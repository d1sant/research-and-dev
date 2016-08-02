package com.my.research.and.dev;

public class For {

    public static void main(String[] args) {
        final int[] values1 = new int[0];
        final int[] values2 = new int[]{};
        for(int value: values1) {
            System.out.println(value);
        }
        for(int value: values2) {
            System.out.println(value);
        }
        int reelIndx = 1;
        for (int i = 5; i < 11; i++) {
            System.out.println(i + " : " + reelIndx++);
            reelIndx = reelIndx > 3 ? 1 : reelIndx;
        }
    }
}
