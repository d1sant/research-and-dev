package com.my.research.and.dev;

import java.util.*;

public class ListIterators {

    public static void main(String[] args) {
        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        final ListIterator iterator = list.listIterator();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hasPrevious());
        System.out.println(iterator.next());
        System.out.println(iterator.previous());

        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        final List<Integer> list1 = Arrays.asList(6, 5, 4, 3, 2, 1);
        Collections.reverse(list1);
        final List<Integer> list2 = Arrays.asList(7, 8, 9, 10, 11, 12);
        final List<Integer> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        System.out.println(result);
    }
}
