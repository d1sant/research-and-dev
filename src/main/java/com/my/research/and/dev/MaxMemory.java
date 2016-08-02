package com.my.research.and.dev;

// VM options: -Xmx512m -XX:+UseG1GC

public class MaxMemory {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
    }
}
