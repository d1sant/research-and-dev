package com.my.research.and.dev.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Examples of usage Stream API.
 *
 * Based on following articles:
 * http://habrahabr.ru/post/256057/
 * http://www.deadcoderising.com/java-8-no-more-loops/
 * http://www.deadcoderising.com/transactions-using-execute-around-method-in-java-8/
 */
public class Streams {

    private Collection<Article> articles = new ArrayList<>();

    public Streams(final Collection<Article> articles) {
        this.articles = articles;
    }

    public static void main(String[] args) {

        final List<Article> articles = Arrays.asList(new Article("First", "Java"), new Article("Second", "Java"), new Article("First", "Scala"), new Article("Third", "Clojure"));
        final Streams javaArticlesStream = new Streams(articles);
        final List<Article> articlesWithoutJava = Arrays.asList(new Article("First", "Closure"), new Article("Second", "Scala"));
        final Streams noJavaArticlesStream = new Streams(articlesWithoutJava);

        System.out.println(javaArticlesStream.getFirstJavaArticleLegacy());
        System.out.println(noJavaArticlesStream.getFirstJavaArticleLegacy());
        System.out.println(noJavaArticlesStream.getFirstJavaArticleLegacy2() + "\n");

        System.out.println(javaArticlesStream.getFirstJavaArticle());
        System.out.println(noJavaArticlesStream.getFirstJavaArticle());
        System.out.println(noJavaArticlesStream.getFirstJavaArticle2() + "\n");

        System.out.println(javaArticlesStream.getFirstJavaArticle().map(Article::getTitle) + "\n");

        final PrintHandler printHandler = new PrintHandler();
        printHandler.print(p -> p.print(javaArticlesStream.getFirstJavaArticle2()));
        printHandler.print(p -> articles.forEach(p::print));

        // refined
        printHandler.print(p -> p.print(javaArticlesStream.getFirst(article -> article.getTags().contains("Java"))));
        printHandler.print(p -> p.print(javaArticlesStream.getFirst(article -> article.getTags().contains("Scala"))));
        printHandler.print(p -> p.print(javaArticlesStream.getFirst(article -> article.getTags().contains("Clojure"))));

        // more refined
        final Function<String, Predicate<Article>> basedOnTag = tag -> article -> article.getTags().contains(tag);
        printHandler.print(p -> p.print(javaArticlesStream.getFirst(basedOnTag.apply("Java"))));
        printHandler.print(p -> p.print(javaArticlesStream.getFirst(basedOnTag.apply("Scala"))));
    }

    // Legacy approach
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

    // New approach based on Java 8 API
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

    // Refactored version of getFirstJavaArticle using predicates for generalization
    public Optional<Article> getFirst(Predicate<Article> predicate) {
        return articles.stream()
                .filter(predicate)
                .findFirst();
    }
}
