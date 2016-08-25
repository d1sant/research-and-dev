package com.my.research.and.dev;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContiguousSetTest {

    public static void main(String[] args) {

        final Set<Integer> rangeOfIndexes = ContiguousSet.create(Range.closed(1, 14), DiscreteDomain.integers());
        System.out.println(rangeOfIndexes);

        final Set<Integer> indexes = ImmutableSet.copyOf(rangeOfIndexes);
        System.out.println(indexes);
        final Sets.SetView<Integer> difference = Sets.difference(indexes, new HashSet<>(Arrays.asList(1, 2, 3, 4)));
        System.out.println(difference);
        System.out.println(Arrays.toString(difference.toArray(new Integer[difference.size()])));
        final double[] doubleDifference = difference.stream().mapToDouble(Integer::doubleValue).toArray();
        System.out.println(Arrays.toString(doubleDifference));
    }
}
