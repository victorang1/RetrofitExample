package com.example.victor_pc.retrofitexample.profile;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.victor_pc.retrofitexample.model.UserDetailResponse;
import com.example.victor_pc.retrofitexample.model.UserItemResponse;
import com.example.victor_pc.retrofitexample.repository.UserRepository;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<UserDetailResponse> mUserDetail;
    private UserRepository mRepository;

    public void init(int position) {
        if(mUserDetail != null) {
            return;
        }
        mRepository = UserRepository.getInstance();
        mUserDetail = mRepository.getUserDetailFromAPI(position);
    }

    public LiveData<UserDetailResponse> getUserDetail() {
        return mUserDetail;
    }
}
