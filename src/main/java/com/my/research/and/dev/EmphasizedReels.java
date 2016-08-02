package com.my.research.and.dev;

import java.util.Arrays;

public class EmphasizedReels {

    private static final int[][] LINE_OFFSETS = {
            {  0,  0,  0,  0,  0 }, // 1
            { -1, -1, -1, -1, -1 }, // 2
            {  1,  1,  1,  1,  1 }, // 3
            { -1,  0,  1,  0, -1 }, // 4
            {  1,  0, -1,  0,  1 }, // 5
            { -1, -1,  0, -1, -1 }, // 6
            {  1,  1,  0,  1,  1 }, // 7
            {  0,  1,  1,  1,  0 },	// 8
            {  0, -1, -1, -1,  0 },	// 9
            {  0, -1,  0, -1,  0 },	// 10
    };

    public static void main(String[] args) {
        final int[] symbols = new int[] {0,4,5,6,7,8,9,10,12,14};
        final int[][] reels = getEmphasizedReels(symbols);
        for (int i = 0; i < 3; i++) {
            String line = "";
            for (int j = 0; j < 5; j++) {
                line += reels[j][i] + (j < 4 ? "," : "");
            }
            System.out.println(line);
        }
        System.out.println("\n");
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(getEmphasizedLineRes(reels, i)));
        }
    }

    private static int[][] getEmphasizedReels(final int[] emphasizedSymbols) {
        final int[][] reels = new int[5][3];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(reels[i], 0);
        }
        for (final int screenIndex : emphasizedSymbols) {
            final int x = screenIndex % 5;
            final int y = screenIndex / 5;
            reels[x][y] = 1;
        }
        return reels;
    }

    private static int[] getEmphasizedLineRes(final int[][] emphasizedReels, final int line) {
        final int[] lineRes = new int[emphasizedReels.length];
        for (int reel = 0; reel < lineRes.length; ++reel) {
            lineRes[reel] = emphasizedReels[reel][1 + LINE_OFFSETS[line][reel]];
        }
        return lineRes;
    }
}
