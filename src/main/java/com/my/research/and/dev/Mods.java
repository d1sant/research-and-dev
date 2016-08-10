package com.my.research.and.dev;

public class Mods {

    public static void main(String[] args) {

        printRemainder(60);
        printRemainder(80);
        printRemainder(120);
        printRemainder(160);
        printRemainder(240);
        printRemainder(360);
        printRemainder(480);

        printRemainder(100);
        printRemainder(300);
        printRemainder(400);
        printRemainder(600);
        printRemainder(800);
        printRemainder(1500);
        printRemainder(3000);
        printRemainder(4500);
        printRemainder(6000);
    }

    private static void printRemainder(final double totalBet) {
        final double lineBet = totalBet / 100;
        final long lineBetMod = (long) (lineBet * 5);
        System.out.println(totalBet + " / " + lineBet + " [" + lineBetMod +  "] : " + lineBet % 1);
    }
}
