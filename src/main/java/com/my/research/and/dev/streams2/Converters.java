package com.my.research.and.dev.streams2;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Converters {

    public static void main(String[] args) {
        Collection<C1> c1s = Arrays.asList(C1.of(1), C1.of(2), C1.of(3));
        System.out.println(c1s);
        Collection<C2> c2s = c1s.stream().map(c1 -> C2.of(Integer.toString(c1.value))).collect(Collectors.toList());
        System.out.println(c2s);
        Collection<C2> c22s = c1s.stream().map(Converters::convert).collect(Collectors.toList());
        System.out.println(c22s);
     }

    private static C2 convert(C1 c1) {
        return C2.of(Integer.toString(c1.value));
    }
}

class C1 {
    final int value;
    private C1(final int value) {
        this.value = value;
    }
    static C1 of(final int value) {
        return new C1(value);
    }

    @Override
    public String toString() {
        return "C1{" +
                "value=" + value +
                '}';
    }
}
class C2 {
    final String value;
    private C2(final String value) {
        this.value = value;
    }
    static C2 of(final String value) {
        return new C2(value);
    }
    @Override
    public String toString() {
        return "C2{" +
                "value='" + value + '\'' +
                '}';
    }
}
