package com.my.research.and.dev;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Range;
import com.google.common.collect.Table;

public class Tables {

    public static void main(String[] args) {
        Table<Integer, Integer, Integer> table = HashBasedTable.create(6, 12);
        table.put(1, 0, 10);
        table.put(1, 1, 11);
        table.put(1, 2, 12);
        table.put(1, 3, 13);
        table.put(1, 4, 14);
        table.put(2, 0, 20);
        table.put(2, 1, 21);
        table.put(2, 2, 22);
        table.put(2, 3, 23);
        table.put(2, 4, 24);
        System.out.println(table.column(1));
        System.out.println(table.get(1, 0));

        ImmutableMultimap.Builder<Integer, Integer> builder = ImmutableMultimap.builder();
        builder.putAll(1, ContiguousSet.create(Range.closed(0, 5), DiscreteDomain.integers()));
        builder.putAll(2, ContiguousSet.create(Range.closed(0, 0), DiscreteDomain.integers()));
        final Multimap<Integer, Integer> multimap = builder.build();
        System.out.println(multimap);
    }
}
