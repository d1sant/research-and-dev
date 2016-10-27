package com.my.research.and.dev.streams2;

import java.util.stream.IntStream;

public class IntStreams {

    public static void main(final String[] args) {

        IntStream.range(0, 5).forEach(System.out::println);
        IntStream.range(0, 5).filter(i -> i % 2 == 0).forEach(System.out::println);

        System.out.println(IntStream.range(0, 6).average().getAsDouble());
    }
}
