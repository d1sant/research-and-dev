package com.my.research.and.dev;

public class Lines {

    public static void main(String[] args) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            if (i != 13) {
                sb.append(i).append(',');
            }
        }
        System.out.println(sb.toString());
    }
}
