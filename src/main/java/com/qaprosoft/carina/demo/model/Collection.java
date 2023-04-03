package com.qaprosoft.carina.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Collection {
    @JsonProperty
    public String id;
    @JsonFormat(pattern = "MM-dd-yyyy")
    public String created_at;
    @JsonFormat(pattern = "MM-dd-yyyy")
    public String updated_at;
    @JsonFormat(pattern = "MM-dd-yyyy")
    public String promoted_at;
    @JsonProperty
    public String width;
    @JsonProperty
    public String height;
    @JsonProperty
    public String color;
    @JsonProperty
    public String blur_hash;
    @JsonProperty
    public String description;
    @JsonProperty
    public String alt_description;
    @JsonIgnore
    public String urls;
    @JsonIgnore
    public String links;
    @JsonProperty
    public String likes;
    @JsonProperty
    public String liked_by_user;
    @JsonIgnore
    public String current_user_collections;
    @JsonProperty
    public String sponsorship;
    @JsonIgnore
    public String topic_submissions;
    @JsonProperty
    public User user;

    public String getId() {
        return id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getPromoted_at() {
        return promoted_at;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public String getBlur_hash() {
        return blur_hash;
    }

    public String getDescription() {
        return description;
    }

    public String getAlt_description() {
        return alt_description;
    }

    public String getUrls() {
        return urls;
    }

    public String getLinks() {
        return links;
    }

    public String getLikes() {
        return likes;
    }

    public String getLiked_by_user() {
        return liked_by_user;
    }

    public String getCurrent_user_collections() {
        return current_user_collections;
    }

    public String getSponsorship() {
        return sponsorship;
    }

    public String getTopic_submissions() {
        return topic_submissions;
    }

    public User getUser() {
        return user;
    }

}
