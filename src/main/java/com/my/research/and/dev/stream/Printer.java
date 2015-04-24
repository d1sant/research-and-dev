package com.my.research.and.dev.stream;

public class Printer {

    public void prepare() {
        System.out.println("Prepare");
    }
    public void print(Article article) {
        System.out.println(article);
    }
    public void sleep() {
        System.out.println("Sleep\n");
    }
}
