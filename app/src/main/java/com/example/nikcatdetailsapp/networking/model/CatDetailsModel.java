package com.example.nikcatdetailsapp.networking.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CatDetailsModel {

    @SerializedName("breeds") public ArrayList<BreedModel> breeds;
    @SerializedName("id") private String id;
    @SerializedName("url") private String url;
    @SerializedName("width") private int width;
    @SerializedName("height") private int height;

    public CatDetailsModel(String id, String url, int width, int height) {
        this.id = id;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public ArrayList<BreedModel> getBreeds() {
        return breeds;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
