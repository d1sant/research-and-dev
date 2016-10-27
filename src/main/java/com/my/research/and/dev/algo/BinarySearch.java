package com.my.research.and.dev.algo;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(final String[] args) {
        final List<Integer> list = Arrays.asList(2,3,5,7,20,30);
        System.out.println(list.get(binarySearch(list, 1, true)));
        System.out.println(list.get(binarySearch(list, 7, true)));
        System.out.println(list.get(binarySearch(list, 8, true)));
        System.out.println(list.get(binarySearch(list, 18, true)));
        System.out.println(list.get(binarySearch(list, 31, true)));
        System.out.println(list.get(binarySearch(list, 8, false)));
        System.out.println(list.get(binarySearch(list, 18, false)));
        System.out.println(list.get(binarySearch(list, 31, false)));
    }


    private static int binarySearch(final List<Integer> list, final long key, final boolean isLower) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            long midVal = list.get(mid);
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        final int index = low > high ? low - 1 : low; // key not found - return nearest lower
        return index;
    }
}
