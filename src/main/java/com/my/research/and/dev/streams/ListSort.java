package com.my.research.and.dev.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListSort {

    public static void main(String[] args) {
        final List<Integer> list = Arrays.asList(3, 2, 7, 1, 4);
        System.out.println(list);
        final List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
        Collections.reverse(list);
        System.out.println(list);
    }
}
