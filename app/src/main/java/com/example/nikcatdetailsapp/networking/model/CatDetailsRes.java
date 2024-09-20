package com.example.nikcatdetailsapp.networking.model;

public class CatDetailsRes {

    private String url;
    private String name;
    private String description;

    public CatDetailsRes(String url, String name, String description) {
        this.url = url;
        this.name = name;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
