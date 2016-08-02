package com.my.research.and.dev.streams;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ToString {

    public static void main(String[] args) {
        final Set<Integer> stickyWilds = new TreeSet<>(Arrays.asList(new Integer[]{1,2,3,4}));
        System.out.println(stickyWilds.stream().map(Object::toString).collect(Collectors.joining(",")));
    }
}
