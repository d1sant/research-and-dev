package com.my.research.and.dev;

public class WeightIndex {

    public static void main(String[] args) {
        final int bonusSubOptA = 0;
        for (int bonusOpt = 1; bonusOpt < 6; bonusOpt++) {
            System.out.println(2 * (bonusOpt - 1) + bonusSubOptA);
        }
        System.out.println("===");
        final int bonusSubOptB = 1;
        for (int bonusOpt = 1; bonusOpt < 6; bonusOpt++) {
            System.out.println(2 * (bonusOpt - 1) + bonusSubOptB);
        }
    }
}
