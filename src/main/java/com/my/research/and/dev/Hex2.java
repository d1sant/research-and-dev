package com.my.research.and.dev;

public class Hex2 {

    public static void main(String[] args) {
        System.out.println(0x1FFL);
        System.out.println(0x1L);
        System.out.println(0x1L << 55);
        System.out.println(0xaaL);

        System.out.println(0xFL);
        System.out.println(0xFFFFFFFFFFFFFFFFL);
        System.out.println(0x0L);

        final int size = 1;
        System.out.println((size + 0xfffL) & ~0xfffL);
        System.out.println(0xfffL);
        System.out.println(size + 0xfffL);
        System.out.println(~0xfffL);
    }
}
