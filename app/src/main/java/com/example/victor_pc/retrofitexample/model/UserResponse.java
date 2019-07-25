package com.example.victor_pc.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {

    @SerializedName("page")
    public Integer page;

    @SerializedName("per_page")
    public Integer perPage;

    @SerializedName("total")
    public Integer total;

    @SerializedName("total_page")
    public Integer totalPages;

    @SerializedName("data")
    public List<UserItemResponse> data = new ArrayList<>();

    public List<UserItemResponse> getData() {
        return data;
    }
}
