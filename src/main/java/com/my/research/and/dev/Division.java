package com.my.research.and.dev;

public class Division {

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(i % 14 + 1);
        }

        System.out.println(divide(6)[0] + " : " + divide(6)[1]);
        System.out.println(divide(101)[0] + " : " + divide(101)[1]);
        System.out.println(divide(100)[0] + " : " + divide(100)[1]);
    }

    private static int[] divide(final int quantity) {
        return new int[]{quantity / 2 + quantity % 2, quantity / 2};
    }
}
