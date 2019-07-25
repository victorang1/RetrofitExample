package com.example.victor_pc.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserDetailResponse {

    @SerializedName("data")
    public UserItemResponse data;

    public UserItemResponse getData() {
        return data;
    }
}
