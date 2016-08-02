package com.my.research.and.dev;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

public class RangesWithWeights {

    public static void main(String[] args) {

        final Range<Integer> r1 = Range.closedOpen(0, 5);
        final Range<Integer> r2 = Range.closedOpen(5, 10);
        final Range<Integer> r3 = Range.closedOpen(10, 20);
        final Range<Integer> r4 = Range.closedOpen(20, 200);
        final Range<Integer> r5 = Range.atLeast(200);

        final RangeMap<Integer, Double> rm = TreeRangeMap.create();
        rm.put(r1, 111d);
        rm.put(r2, 222d);
        rm.put(r3, 333d);
        rm.put(r4, 444d);
        rm.put(r5, 555d);

        final Multimap<Double, Integer> mm = LinkedListMultimap.create(); // weight --> win
        populate(rm, mm, 4);
        populate(rm, mm, 5);
        populate(rm, mm, 6);

        final Double[] weights = mm.keySet().toArray(new Double[0]);
        final Double selectedWeight = weights[random(weights)];
        System.out.println(selectedWeight);
        System.out.println(mm.get(selectedWeight).iterator().next());
    }

    private static int random(final Double[] weights) {
        return 1;
    }

    private static void populate(final RangeMap<Integer, Double> rm, final Multimap<Double, Integer> mm, final int win) {
        final Double weight = rm.get(win);
        if (weight != null) {
            mm.put(weight, win);
        }
    }
}
