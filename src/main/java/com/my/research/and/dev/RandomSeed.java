package com.my.research.and.dev;

import java.util.Random;

public class RandomSeed {

    public static void main(String[] args) {
        final long seed = System.currentTimeMillis();
        System.out.println("Seed: " + seed);
        final Random random = new Random(seed);
        final int[] ints = new int[100];
        for (int i = 0; i < 100; i++) {
            ints[i] = random.nextInt(5);
        }
        final Random random2 = new Random(seed);
        for (int i = 0; i < 100; i++) {
            System.out.println("Prev: " + ints[i] + ", Cur: " + random2.nextInt(5));
        }
    }
}
