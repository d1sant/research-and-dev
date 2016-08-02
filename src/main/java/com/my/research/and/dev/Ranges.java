package com.my.research.and.dev;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeSet;

public class Ranges {

    public static void main(String[] args) {

        final Range<Integer> r1 = Range.closedOpen(0, 5);
        final Range<Integer> r2 = Range.closedOpen(5, 10);
        final Range<Integer> r3 = Range.closedOpen(10, 20);
        final Range<Integer> r4 = Range.closedOpen(20, 200);
        final Range<Integer> r5 = Range.atLeast(200);

        final RangeSet<Integer> rs = TreeRangeSet.create();
        rs.add(r1);
        rs.add(r2);
        rs.add(r3);
        rs.add(r4);
        rs.add(r5);

        System.out.println(rs.contains(4));
        System.out.println(rs.contains(5));
        System.out.println(rs.contains(11));
        System.out.println(rs.contains(199));
        System.out.println(rs.contains(1990));

        System.out.println(rs.contains(4));
        System.out.println(rs.contains(5));
        System.out.println(rs.contains(11));
        System.out.println(rs.contains(199));
        System.out.println(rs.contains(1990));

        final RangeMap<Integer, Integer> rm = TreeRangeMap.create();
        rm.put(r1, 111);
        rm.put(r2, 222);
        rm.put(r3, 333);
        rm.put(r4, 444);
        rm.put(r5, 555);

        System.out.println(rm.get(4));
        System.out.println(rm.get(5));
        System.out.println(rm.get(11));
        System.out.println(rm.get(199));
        System.out.println(rm.get(1990));
        System.out.println(rm.subRangeMap(Range.open(2, 12)));

        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10)); // {[1, 10]}
        rangeSet.add(Range.closedOpen(11, 15)); // disconnected range: {[1, 10], [11, 15)}
        rangeSet.add(Range.closedOpen(15, 20)); // connected range; {[1, 10], [11, 20)}
        rangeSet.add(Range.openClosed(0, 0)); // empty range; {[1, 10], [11, 20)}
        System.out.println(rangeSet);

        rangeSet.remove(Range.open(5, 10)); // splits [1, 10]; {[1, 5], [10, 10], [11, 20)}
        System.out.println(rangeSet);

        rangeSet.remove(Range.closed(2, 3));
        System.out.println(rangeSet);

        System.out.println(rangeSet.complement());
        System.out.println(rangeSet.encloses(Range.open(12, 13)));
        System.out.println(rangeSet.encloses(Range.open(4, 13)));
        System.out.println(rangeSet.span());
    }
}
