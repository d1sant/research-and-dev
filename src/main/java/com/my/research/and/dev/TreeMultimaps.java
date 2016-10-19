package com.my.research.and.dev;

import com.google.common.collect.TreeMultimap;

import java.util.Random;

public class TreeMultimaps {

    private static final Random random = new Random();

    public static void main(String[] args) {
        final TreeMultimap<Integer, Integer> multimap = TreeMultimap.create();
        for (int i = 0; i < 10; i++) {
            multimap.put(i, random.nextInt());
            multimap.put(i, random.nextInt());
        }
        System.out.println(multimap.size());
    }
}
