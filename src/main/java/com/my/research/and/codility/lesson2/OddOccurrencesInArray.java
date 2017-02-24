package com.my.research.and.codility.lesson2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

    public static int findOdd(int[] A) {
        final Map<Integer, Integer> counts = new HashMap<>(A.length / 2 + 1);
        for (final int aA : A) {
            Integer prev = counts.get(aA);
            counts.put(aA, prev != null ? ++prev : 1);
        }
        for (Map.Entry<Integer, Integer> count :counts.entrySet()) {
            if (count.getValue() % 2 != 0) {
                return count.getKey();
            }
        }
        return -1;
    }

    public static void test(int... a) {
        System.out.println(Arrays.toString(a) + " -> " + findOdd(a));
    }

    public static void main(String[] args) {
        test(1, 1, 3);
    }
}
