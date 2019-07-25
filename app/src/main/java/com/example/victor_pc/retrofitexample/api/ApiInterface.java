package com.example.victor_pc.retrofitexample.api;

import com.example.victor_pc.retrofitexample.model.UserDetailResponse;
import com.example.victor_pc.retrofitexample.model.UserItemResponse;
import com.example.victor_pc.retrofitexample.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/users")
    Call<UserResponse> getUser(
            @Query("page") Integer page,
            @Query("per_page") Integer per_page);

    @GET("/api/users/{page}")
    Call<UserDetailResponse> getUserDetail(
        @Path("page") Integer page);
}
