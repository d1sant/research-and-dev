package com.my.research.and.dev;

import java.util.HashMap;
import java.util.Map;

public class ReelLines {

    public static void main(String[] args) {

        final Map<Integer, int[]> mapping = new HashMap<>();
        mapping.put(0, new int[]{ 1, 6, 11 });
        mapping.put(1, new int[]{ 2, 7, 12 });
        mapping.put(2, new int[]{ 3, 8, 13 });
        mapping.put(3, new int[]{ 4, 9, 14 });
        mapping.put(4, new int[]{ 5,10, 15 });

        final int[][] offsets = new int[][]{
                {0, 0, 0, 0, 0}, // 1
                {-1, -1, -1, -1, -1}, // 2
                {1, 1, 1, 1, 1}, // 3
                {-1, 0, 1, 0, -1}, // 4
                {1, 0, -1, 0, 1}, // 5
                {0, -1, -1, -1, 0}, // 6
                {0, 1, 1, 1, 0}, // 7
                {-1, -1, 0, 1, 1}, // 8
                {1, 1, 0, -1, -1}, // 9
                {0, 1, 0, -1, 0}, // 10
                {0, -1, 0, 1, 0}, // 11
                {-1, 0, 0, 0, -1}, // 12
                {1, 0, 0, 0, 1}, // 13
                {-1, 0, -1, 0, -1}, // 14
                {1, 0, 1, 0, 1}, // 15
                {0, 0, -1, 0, 0}, // 16
                {0, 0, 1, 0, 0}, // 17
                {-1, -1, 1, -1, -1}, // 18
                {1, 1, -1, 1, 1}, // 19
                {-1, 1, 1, 1, -1}, // 20
                {1, -1, -1, -1, 1}, // 21
                {0, 1, -1, 1, 0}, // 22
                {0, -1, 1, -1, 0}, // 23
                {-1, 1, -1, 1, -1}, // 24
                {1, -1, 1, -1, 1}, // 25
        };

        for (int i = 0; i < offsets.length; i++) {
            String res = "";
            for (int j = 0; j < 5; j++) {
                final int offset = offsets[i][j];
                res += mapping.get(j)[offset + 1] + (j <= 3 ? ", " : "");
            }
            System.out.println("line: " + (i + 1) + ": " + res + ((i + 1) % 5 == 0 ? "\n" : ""));
        }
    }
}
