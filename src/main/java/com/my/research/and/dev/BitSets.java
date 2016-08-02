package com.my.research.and.dev;

import java.util.BitSet;

public class BitSets {

    public static void main(String[] args) {

        BitSet bitSet1 = new BitSet();
        BitSet bitSet2 = new BitSet();
        bitSet2.set(0);
        bitSet2.set(6);
        bitSet1.set(0);
        bitSet1.set(1);
        bitSet1.set(2);
        bitSet1.set(3);
        bitSet1.set(4);
        bitSet1.set(5);
        bitSet1.set(6);
        System.out.println("bitSet2 " + bitSet2);
        System.out.println("bitSet1 " + bitSet1);
        System.out.println(convert(bitSet2));
        System.out.println(convert(bitSet1));
        bitSet2.and(bitSet1);
        System.out.println("bitSet2 & bitSet1 = " + bitSet2);

        for (int i = 1; i < 5; i++) {
            System.out.println(1 << i);
        }

        BitSet bitSet000 = new BitSet();
        BitSet bitSet100 = new BitSet();
        bitSet100.set(0);
        BitSet bitSet010 = new BitSet();
        bitSet010.set(1);
        BitSet bitSet110 = new BitSet();
        bitSet110.set(0);
        bitSet110.set(1);
        BitSet bitSet111 = new BitSet();
        bitSet111.set(0);
        bitSet111.set(1);
        bitSet111.set(2);

        System.out.println("000: " + convert(bitSet000));
        System.out.println("100: " + convert(bitSet100));
        System.out.println("010: " + convert(bitSet010));
        System.out.println("110: " + convert(bitSet110));
        System.out.println("111: " + convert(bitSet111));

        System.out.println("bitSet1 " + bitSet1);
        bitSet1.clear();
        System.out.println("bitSet1 " + bitSet1);
    }

    public static int convert(BitSet bitSet) {
        int value = 0;
        for (int i = 0; i < bitSet.length(); i++) {
            value += bitSet.get(i) ? (1 << i) : 0L;
        }
        return value;
    }
}
