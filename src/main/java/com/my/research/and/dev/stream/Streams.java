package com.my.research.and.dev.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/**
 * Examples of usage Stream API.
 *
 * Based on following articles:
 * http://habrahabr.ru/post/256057/
 * http://www.deadcoderising.com/java-8-no-more-loops/
 */
public class Streams {

    private Collection<Article> articles = new ArrayList<>();

    public Streams(final Collection<Article> articles) {
        this.articles = articles;
    }

    public static void main(String[] args) {

        final Streams javaArticles = new Streams(Arrays.asList(new Article("First", "Java"), new Article("Second", "Java"), new Article("First", "Scala")));
        final Streams noJavaArticles = new Streams(Arrays.asList(new Article("First", "Closure"), new Article("Second", "Scala")));

        System.out.println(javaArticles.getFirstJavaArticleLegacy());
        System.out.println(noJavaArticles.getFirstJavaArticleLegacy());
        System.out.println(noJavaArticles.getFirstJavaArticleLegacy2() + "\n");

        System.out.println(javaArticles.getFirstJavaArticle());
        System.out.println(noJavaArticles.getFirstJavaArticle());
        System.out.println(noJavaArticles.getFirstJavaArticle2() + "\n");

        System.out.println(javaArticles.getFirstJavaArticle().map(Article::getTitle) + "\n");
    }

    public Article getFirstJavaArticleLegacy() {
        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                return article;
            }
        }
        return null;
    }

    public Article getFirstJavaArticleLegacy2() {
        final Article firstArticle = getFirstJavaArticleLegacy();
        return firstArticle != null ? firstArticle : fetchLatestArticleLegacy();
    }

    private Article fetchLatestArticleLegacy() {
        return articles.iterator().next();
    }

    public Optional<Article> getFirstJavaArticle() {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst();
    }

    public Article getFirstJavaArticle2() {
        return getFirstJavaArticle().orElseGet(this::fetchLatestArticle);
    }

    private Article fetchLatestArticle() {
        return articles.stream().findAny().get();
    }
}
