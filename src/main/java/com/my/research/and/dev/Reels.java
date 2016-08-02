package com.my.research.and.dev;

import java.util.Arrays;

public class Reels {

    private static final int[] SYMBOL_WEIGHTS = new int[]{2, 3, 4, 5, 7, 8, 10, 12, 15, 12};
    private static final int[] MY_REEL = new int[78];
    static {
        int index = 0;
        int weightIndex = 0;
        while (index < MY_REEL.length && weightIndex < SYMBOL_WEIGHTS.length) {
            Arrays.fill(MY_REEL, index, index + SYMBOL_WEIGHTS[weightIndex], weightIndex);
            index += SYMBOL_WEIGHTS[weightIndex];
            weightIndex++;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(MY_REEL));
    }
}
