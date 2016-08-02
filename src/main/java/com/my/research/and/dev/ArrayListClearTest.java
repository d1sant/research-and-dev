package com.my.research.and.dev;

import java.util.ArrayList;
import java.util.List;

public class ArrayListClearTest {

    public static void main(String[] args) {

        final List<Long> l = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            l.add((long) i);
        }
        System.out.println(l);
        l.clear();

        for (int i = 15; i < 20; i++) {
            l.add((long) i);
        }
        System.out.println(l);
    }
}
