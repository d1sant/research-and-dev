package com.my.research.and.dev.streams2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Start {

    public static void main(String[] args) {

        // Example #3

        final Collection<SportsCamp> sport = Arrays.asList(
                new SportsCamp("Ivan", 5),
                new SportsCamp("Petr", 7),
                new SportsCamp("Ira", 10)
        );


        final String name = sport.stream().max((p1, p2) -> p1.getDay().compareTo(p2.getDay())).get().getName();
        System.out.println("Name=" + name);

        // Example #4

        final Collection<SportsCamp> sportWithNull = Arrays.asList(
                new SportsCamp("Ivan", 5),
                new SportsCamp( null, 15),
                new SportsCamp("Petr", 7),
                new SportsCamp("Ira", 10)
        );

        final String nameTest = sport.stream().filter((p) -> p.getName() != null).max((p1, p2) -> p1.getDay().compareTo(p2.getDay())).get().getName();
        System.out.println("NameWithNull=" + nameTest);

        // Example #5

        final Collection<SportsCamp> sportWithIvans = Arrays.asList(
                new SportsCamp("Ivan", 5),
                new SportsCamp( null, 15),
                new SportsCamp("Petr", 7),
                new SportsCamp("Ira", 10),
                new SportsCamp("Ivan", 17)
        );

        final long countName = sportWithIvans.stream().filter((p) -> p.getName() != null && p.getName().equals("Ivan")).count();
        System.out.println("countName=" + countName);

        final long countNameParallel = sportWithIvans.parallelStream().filter((p) -> p.getName() != null && p.getName().equals("Ivan")).count();
        System.out.println("countNameParallel=" + countNameParallel);

        final List<SportsCamp> onlyI = sportWithIvans.stream().filter(p -> p.getName() != null && p.getName().startsWith("I")).collect(Collectors.toList());
        System.out.println("SIZE=" + onlyI.size());

        final String campPeople = sportWithIvans.stream().filter(p -> p.getName() != null).map(SportsCamp::getName).collect(Collectors.joining(" and ", "In camp ", " rest all days."));
        System.out.println(campPeople);

        final Integer daySum = sport.stream().reduce(0, (sum, p) -> sum += p.getDay(), (sum1, sum2) -> sum1 + sum2);
        System.out.println("DaySize=" + daySum);
    }
}
