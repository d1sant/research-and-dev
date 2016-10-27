package com.my.research.and.dev;

import java.util.Arrays;
import java.util.ListIterator;

public class ListIterators {

    public static void main(String[] args) {
        final ListIterator iterator = Arrays.asList(1, 2, 3, 4, 5, 6).listIterator();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hasPrevious());
        System.out.println(iterator.next());
        System.out.println(iterator.previous());
    }
}
