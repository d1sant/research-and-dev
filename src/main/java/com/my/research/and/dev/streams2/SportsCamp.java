package com.my.research.and.dev.streams2;

public class SportsCamp {

    private String name;
    private Integer day;

    public SportsCamp(String name, int day) {
        this.name = name;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(final Integer day) {
        this.day = day;
    }
}
