package com.qaprosoft.carina.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty
    public String id;
    @JsonFormat(pattern = "MM-dd-yyyy")
    public String updated_at;
    @JsonProperty
    public String username;
    @JsonProperty
    public String name;
    @JsonProperty
    public String first_name;
    @JsonProperty
    public String last_name;
    @JsonProperty
    public String twitter_username;
    @JsonProperty
    public String portfolio_url;
    @JsonProperty
    public String bio;
    @JsonProperty
    public String location;
    @JsonIgnore
    public String links;
    @JsonIgnore
    public String profile_image;
    @JsonProperty
    public String instagram_username;
    @JsonProperty
    public String total_collections;
    @JsonProperty
    public String total_likes;
    @JsonProperty
    public String total_photos;
    @JsonProperty
    public String accepted_tos;
    @JsonProperty
    public String for_hire;
    @JsonIgnore
    public String social;

    public String getId() {
        return id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getTwitter_username() {
        return twitter_username;
    }

    public String getPortfolio_url() {
        return portfolio_url;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    public String getLinks() {
        return links;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public String getInstagram_username() {
        return instagram_username;
    }

    public String getTotal_collections() {
        return total_collections;
    }

    public String getTotal_likes() {
        return total_likes;
    }

    public String getTotal_photos() {
        return total_photos;
    }

    public String getAccepted_tos() {
        return accepted_tos;
    }

    public String getFor_hire() {
        return for_hire;
    }

    public String getSocial() {
        return social;
    }

}
