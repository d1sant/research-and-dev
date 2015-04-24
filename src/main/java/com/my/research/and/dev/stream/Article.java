package com.my.research.and.dev.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Article {

    private String name;
    private Collection<String> tags = new HashSet<>();

    public Article(final String name, final String tag) {
        this(name, Arrays.<String> asList(tag));
    }

    public Article(final String name, final Collection<String> tags) {
        this.name = name;
        this.tags = tags;
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public String getName() {
        return name;
    }

    public Collection<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", tags=" + tags +
                '}';
    }
}
