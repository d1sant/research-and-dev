package com.my.research.and.dev;

public class Shifts {

    public static void main(String[] args) {

        System.out.println(1 << 1);
        System.out.println(1 << 2);
        System.out.println(1 << 3);
        System.out.println(2 << 3);
        System.out.println(3 << 3);

        boolean a, b, c;
        a = true; b = false; c = false;
        c |= a;

        System.out.println(a | b);
        System.out.println(a & b);
        System.out.println(c);

        System.out.println(5 | 2);
    }
}
