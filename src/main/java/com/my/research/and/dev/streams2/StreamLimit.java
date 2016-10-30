package com.my.research.and.dev.streams2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLimit {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> limitedList = list.stream().limit(100).collect(Collectors.toList());
        System.out.println(list.size());
        System.out.println(limitedList.size());
    }
}
