package com.example.nikcatdetailsapp.networking.model;

import com.google.gson.annotations.SerializedName;

public class WeightModel {

    @SerializedName("imperial") public String imperial;
    @SerializedName("metric") public String metric;

    public String getImperial() {
        return imperial;
    }

    public String getMetric() {
        return metric;
    }
}
