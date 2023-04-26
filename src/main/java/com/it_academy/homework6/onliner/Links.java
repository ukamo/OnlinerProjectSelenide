package com.it_academy.homework6.onliner;

public enum Links {
    homepage("https://www.onliner.by/"),
    catalogpage("https://catalog.onliner.by/");


    private String link;
    Links(String link) {
        this.link = link;
    }
    public String getLink(){
        return link;
    }
}
