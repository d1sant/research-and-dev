package com.my.research.and.dev.stream;

import java.util.Optional;

public class Printer {

    public void prepare() {
        System.out.println("Prepare");
    }
    public void print(Article article) {
        System.out.println(article);
    }
    public void print(Optional<Article> articleOptional) {
        print(articleOptional.get());
    }
    public void sleep() {
        System.out.println("Sleep\n");
    }
}
