package com.my.research.and.dev;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Sets {

    public static void main(String[] args) {

        final Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("c");
        linkedHashSet.add("a");
        linkedHashSet.add("b");
        linkedHashSet.add("a");
        linkedHashSet.add("a");
        linkedHashSet.add("b");
        for (final String value : linkedHashSet) {
            System.out.println(value);
        }

        System.out.println("---");

        final Set<String> hashSet = new HashSet<>();
        hashSet.add("c");
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("a");
        hashSet.add("a");
        hashSet.add("b");
        for (final String value : hashSet) {
            System.out.println(value);
        }
    }
}
