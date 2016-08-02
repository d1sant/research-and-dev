package com.my.research.and.dev.streams2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Streams {

    public static void main(String[] args) {

        // Example #1

        final List<Integer> testValues = new ArrayList<>();
        testValues.add(0, 15);
        testValues.add(1, 1);
        testValues.add(2, 2);
        testValues.add(3, 100);
        testValues.add(4, 50);

        final Optional<Integer> maxValue = testValues.stream().max(Integer::compareTo);
        System.out.println("MaxValue=" + maxValue);
        final Optional<Integer> minValue = testValues.stream().min(Integer::compareTo);
        System.out.println("MinValue=" + minValue);

        // Example #2

        final List<Integer> testValuesNull = new ArrayList<>();
        testValuesNull.add(0, null);
        testValuesNull.add(1, 1);
        testValuesNull.add(2, 2);
        testValuesNull.add(3, 100);
        testValuesNull.add(4, 50);

        // Optional<Integer> maxValueNull = testValuesNull.stream().max(Integer::compareTo); // will throw NPE
        final Optional<Integer> maxValueNotNull = testValuesNull.stream().filter((p) -> p != null).max(Integer::compareTo);
        System.out.println("MaxValueNotNull=" + maxValueNotNull);
    }

}
