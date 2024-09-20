package com.example.nikcatdetailsapp.networking.model;

import com.google.gson.annotations.SerializedName;

public class BreedModel {
@SerializedName("weight") public WeightModel weight;
    @SerializedName("id") public String id;
    @SerializedName("name")  public String name;
    @SerializedName("cfa_url") public String cfa_url;
    @SerializedName("vetstreet_url") public String vetstreet_url;
    @SerializedName("vcahospitals_url") public String vcahospitals_url;
    @SerializedName("temperament") public String temperament;
    @SerializedName("origin")  public String origin;
    @SerializedName("country_codes") public String country_codes;
    @SerializedName("country_code") public String country_code;
    @SerializedName("description") public String description;
    @SerializedName("life_span") public String life_span;
    @SerializedName("indoor") public int indoor;
    @SerializedName("lap") public int lap;
    @SerializedName("adaptability") public int adaptability;
    @SerializedName("affection_level") public int affection_level;
    @SerializedName("child_friendly") public int child_friendly;
    @SerializedName("cat_friendly") public int cat_friendly;
    @SerializedName("dog_friendly") public int dog_friendly;
    @SerializedName("energy_level") public int energy_level;
    @SerializedName("grooming") public int grooming;
    @SerializedName("health_issues") public int health_issues;
    @SerializedName("intelligence") public int intelligence;
    @SerializedName("shedding_level") public int shedding_level;
    @SerializedName("social_needs") public int social_needs;
    @SerializedName("stranger_friendly") public int stranger_friendly;
    @SerializedName("vocalisation") public int vocalisation;
    @SerializedName("bidability") public int bidability;
    @SerializedName("experimental") public int experimental;
    @SerializedName("hairless") public int hairless;
    @SerializedName("natural") public int natural;
    @SerializedName("rare") public int rare;
    @SerializedName("rex") public int rex;
    @SerializedName("suppressed_tail") public int suppressed_tail;
    @SerializedName("short_legs") public int short_legs;
    @SerializedName("wikipedia_url") public String wikipedia_url;
    @SerializedName("hypoallergenic") public int hypoallergenic;
    @SerializedName("reference_image_id") public String reference_image_id;


    public WeightModel getWeight() {
        return weight;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCfa_url() {
        return cfa_url;
    }

    public String getVetstreet_url() {
        return vetstreet_url;
    }

    public String getVcahospitals_url() {
        return vcahospitals_url;
    }

    public String getTemperament() {
        return temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public String getCountry_codes() {
        return country_codes;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getDescription() {
        return description;
    }

    public String getLife_span() {
        return life_span;
    }

    public int getIndoor() {
        return indoor;
    }

    public int getLap() {
        return lap;
    }

    public int getAdaptability() {
        return adaptability;
    }

    public int getAffection_level() {
        return affection_level;
    }

    public int getChild_friendly() {
        return child_friendly;
    }

    public int getCat_friendly() {
        return cat_friendly;
    }

    public int getDog_friendly() {
        return dog_friendly;
    }

    public int getEnergy_level() {
        return energy_level;
    }

    public int getGrooming() {
        return grooming;
    }

    public int getHealth_issues() {
        return health_issues;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getShedding_level() {
        return shedding_level;
    }

    public int getSocial_needs() {
        return social_needs;
    }

    public int getStranger_friendly() {
        return stranger_friendly;
    }

    public int getVocalisation() {
        return vocalisation;
    }

    public int getBidability() {
        return bidability;
    }

    public int getExperimental() {
        return experimental;
    }

    public int getHairless() {
        return hairless;
    }

    public int getNatural() {
        return natural;
    }

    public int getRare() {
        return rare;
    }

    public int getRex() {
        return rex;
    }

    public int getSuppressed_tail() {
        return suppressed_tail;
    }

    public int getShort_legs() {
        return short_legs;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public int getHypoallergenic() {
        return hypoallergenic;
    }

    public String getReference_image_id() {
        return reference_image_id;
    }
}

