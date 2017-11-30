package com.example.ivan.testdevabit.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DataChild {
    @SerializedName("subreddit")
    @Expose
    private String subreddit;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("name")
    private String name;
    @SerializedName("subreddit_name_prefixed")
    @Expose
    private String subredditNamePrefixed;
    @SerializedName("body")
    @Expose
    private String bodyComment;

    public String getSubreddit() {
        return subreddit;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getName() {
        return name;
    }

    public String getSubredditNamePrefixed() {
        return subredditNamePrefixed;
    }

    public String getBodyComment() {
        return bodyComment;
    }
}
