package com.my.research.and.dev.streams2;

import java.util.Arrays;

public class AnyMatch {

    public static void main(String[] args) {
        final int[] values = {1,2,3,4,0,1,2};
        System.out.println(Arrays.stream(values).anyMatch(i -> i == 0));
        System.out.println(Arrays.stream(values).anyMatch(i -> i == 1));
        System.out.println(Arrays.stream(values).anyMatch(i -> i == 4));
        System.out.println(Arrays.stream(values).anyMatch(i -> i == 5));
    }
}
