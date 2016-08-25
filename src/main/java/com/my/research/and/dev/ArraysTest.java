package com.my.research.and.dev;

import java.util.Arrays;

public class ArraysTest {

    public static void main(String[] args) {

        final int[][] array = new int[3][5];
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        final Integer[][] objArray = new Integer[3][5];
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(objArray));
            System.out.println(objArray[i][0]);
        }

        final int[] array1 = new int[3];
        for (int i = 0; i < 5; i++) {
            array1[0]++;
        }
        System.out.println(Arrays.toString(array1));
    }
}
