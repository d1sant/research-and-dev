package com.my.research.and.dev;

public class HexAndBooleanAlg {

    public static void main(String[] args) {
        final long zeroEight = 0x00000008L;
        final long eight = 0xFFFFFFF8L;
        System.out.println(zeroEight);
        System.out.println(eight);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE & zeroEight);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE & eight);
    }
}
