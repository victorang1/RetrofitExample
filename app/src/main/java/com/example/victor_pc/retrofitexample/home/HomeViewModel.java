package com.example.victor_pc.retrofitexample.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;

import com.example.victor_pc.retrofitexample.model.UserResponse;
import com.example.victor_pc.retrofitexample.profile.ProfileActivity;
import com.example.victor_pc.retrofitexample.repository.UserRepository;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<UserResponse> mUserItemResponse;
    private UserRepository mRepository;

    public void init() {
        if(mUserItemResponse != null) {
            return;
        }
        mRepository = UserRepository.getInstance();
        mUserItemResponse = mRepository.getUserList();
    }

    public LiveData<UserResponse> getUserData() {
        return mUserItemResponse;
    }
}
