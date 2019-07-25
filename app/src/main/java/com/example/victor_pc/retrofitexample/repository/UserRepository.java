package com.example.victor_pc.retrofitexample.repository;

import android.arch.lifecycle.MutableLiveData;
import com.example.victor_pc.retrofitexample.api.ApiClient;
import com.example.victor_pc.retrofitexample.api.ApiInterface;
import com.example.victor_pc.retrofitexample.model.UserDetailResponse;
import com.example.victor_pc.retrofitexample.model.UserItemResponse;
import com.example.victor_pc.retrofitexample.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static UserRepository instance;
    private List<UserItemResponse> data = new ArrayList<>();

    public static UserRepository getInstance() {
        if(instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public MutableLiveData<UserResponse> getUserList() {
        final MutableLiveData<UserResponse> result = new MutableLiveData<>();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final Call<UserResponse> call = apiInterface.getUser(1, 12);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()) {
                    result.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                result.setValue(null);
            }
        });
        return result;
    }

    public MutableLiveData<UserDetailResponse> getUserDetailFromAPI(int position) {
        final MutableLiveData<UserDetailResponse> result = new MutableLiveData<>();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final Call<UserDetailResponse> call = apiInterface.getUserDetail(position+1);
        call.enqueue(new Callback<UserDetailResponse>() {
            @Override
            public void onResponse(Call<UserDetailResponse> call, Response<UserDetailResponse> response) {
                if(response.isSuccessful()) {
                    result.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserDetailResponse> call, Throwable t) {
                result.setValue(null);
            }
        });
        return result;
    }
}
