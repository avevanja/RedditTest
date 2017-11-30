package com.example.ivan.testdevabit.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Child {

    @SerializedName("data")
    @Expose
    private DataChild data;

    public DataChild getData() {
        return data;
    }

    public void setData(DataChild data) {
        this.data = data;
    }
}
