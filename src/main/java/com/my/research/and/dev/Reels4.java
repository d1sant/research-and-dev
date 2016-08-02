package com.my.research.and.dev;

public class Reels4 {

    public static void main(String[] args) {

        for (int reel = 0; reel < 5; reel++) {
            for (int offset = -1; offset <= 2; offset++) {
                final int displayIndex = reel + 5 * (offset + 1);
                System.out.println(displayIndex);
            }
        }
    }
}
