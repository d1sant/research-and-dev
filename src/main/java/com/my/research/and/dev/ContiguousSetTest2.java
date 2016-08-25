package com.my.research.and.dev;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

import java.util.Set;

public class ContiguousSetTest2 {

    public static void main(String[] args) {

        final Set<Integer> rangeOfIndexes = ContiguousSet.create(Range.closed(0, 19), DiscreteDomain.integers());
        System.out.println(rangeOfIndexes.size());
        for (final int index: rangeOfIndexes) {
            System.out.println(index + " - " + (index / 4 + 1) + " : " + (index % 4 + 1));
        }
    }
}
