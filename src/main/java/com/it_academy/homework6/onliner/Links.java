package com.it_academy.homework6.onliner;

public enum Links {
    HOME_PAGE("https://www.onliner.by/"),
    CATALOG_PAGE("https://catalog.onliner.by/"),
    SUSHI_PAGE("https://catalog.onliner.by/sushivesla");
    private final String link;
    Links(String link) {
        this.link = link;
    }
    public String getLink(){
        return link;
    }
}
