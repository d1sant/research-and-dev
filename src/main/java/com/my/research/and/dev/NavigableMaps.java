package com.my.research.and.dev;

import com.google.common.collect.TreeMultimap;

import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class NavigableMaps {

    public static void main(String[] args) {

        final NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(1, "1");
        map.put(3, "3");
        map.put(5, "5");
        map.put(7, "7");
        map.put(9, "9");
        map.put(11, "11");

        final NavigableMap<Integer, String> subMap = map.subMap(2, true, 10, true);
        final NavigableMap<Integer, String> copyOfSumMap = new TreeMap<>(subMap);
        System.out.println(subMap);
        System.out.println(copyOfSumMap);

        map.remove(5);
        System.out.println(subMap);
        System.out.println(copyOfSumMap);

        System.out.println(map.ceilingKey(8));
        System.out.println(map.floorKey(8));

        final TreeMultimap<Integer, String> treeMap = TreeMultimap.create();
        treeMap.put(1, "1.1");
        treeMap.put(1, "1.2");
        treeMap.put(1, "1.3");
        treeMap.put(3, "3.1");
        treeMap.put(3, "3.2");
        treeMap.put(5, "5.1");
        treeMap.put(5, "5.2");

        System.out.println(treeMap.get(1));
        System.out.println(treeMap.get(1).first());
        System.out.println(treeMap.asMap().floorEntry(4).getValue());
        System.out.println(treeMap.asMap().ceilingEntry(4).getValue());

        System.out.println(map.headMap(4));
        System.out.println(map.tailMap(4));
        System.out.println(map.descendingMap().headMap(4));
        System.out.println(map.descendingMap().tailMap(4).values().stream().sorted((s1, s2) -> Integer.compare(Integer.valueOf(s1), Integer.valueOf(s2))).collect(Collectors.toList()));
    }
}
