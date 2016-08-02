package com.my.research.and.dev.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Article {

    private String title;
    private Collection<String> tags = new HashSet<>();

    public Article(final String title, final String tag) {
        this(title, Arrays.<String> asList(tag));
    }

    public Article(final String title, final Collection<String> tags) {
        this.title = title;
        this.tags = tags;
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public String getTitle() {
        return title;
    }

    public Collection<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", tags=" + tags +
                '}';
    }
}
