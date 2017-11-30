package com.example.ivan.testdevabit.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RedditListing {
    @SerializedName("data")
    @Expose
    private DataListing data;

    public DataListing getData() {
        return data;
    }

    public void setData(DataListing data) {
        this.data = data;
    }

}
