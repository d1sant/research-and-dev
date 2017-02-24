package com.my.research.and.dev.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {

    public static void main(final String[] args) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 700; i++) {
            stringBuilder.append("JokerJPoint");
        }
        final Pattern pattern = Pattern.compile("(Joker|JPoint)++");
        final Matcher matcher = pattern.matcher(stringBuilder.toString());
        System.out.println(matcher.find());
    }
}
