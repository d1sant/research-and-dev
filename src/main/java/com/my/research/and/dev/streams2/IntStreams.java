package com.my.research.and.dev.streams2;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreams {

    public static void main(final String[] args) {

        IntStream.range(0, 5).forEach(System.out::println);
        IntStream.range(0, 5).filter(i -> i % 2 == 0).forEach(System.out::println);

        System.out.println(IntStream.range(0, 6).average().getAsDouble());

        final List<Integer> listWithDuplicates = Arrays.asList(1, 1, 1, 2, 2, 1, 3, 2, 2, 5, 5, 1, 1, 1);
        // final List<Integer> listWithDuplicates = Arrays.asList(1, 2, 3);
        System.out.println(listWithDuplicates);

        final IntPredicate filter = i -> i + 1 == listWithDuplicates.size() || !listWithDuplicates.get(i).equals(listWithDuplicates.get(i + 1));
        final List<Integer> clearedList = IntStream.range(0, listWithDuplicates.size())
                .filter(filter)
                .mapToObj(listWithDuplicates::get)
                .collect(Collectors.toList());

        System.out.println(clearedList);
    }
}
