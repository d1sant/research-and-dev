package com.my.research.and.dev.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Super {

    public static void count(Collection<? super Integer> ints, int n) {
        for (int i = 0; i < n; i++) {
            ints.add(i);
        }
    }

    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();
        count(ints, 5);
        assert ints.toString().equals("[0, 1, 2, 3, 4]");

        List<Number> nums = new ArrayList<>();
        count(nums, 5);
        nums.add(5.0);
        assert nums.toString().equals("[0, 1, 2, 3, 4, 5.0]");

        List<Object> objs = new ArrayList<>();
        count(objs, 5);
        objs.add("five");
        assert objs.toString().equals("[0, 1, 2, 3, 4, five]");
    }
}
