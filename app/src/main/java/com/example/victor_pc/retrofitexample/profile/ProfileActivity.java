package com.example.victor_pc.retrofitexample.profile;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.victor_pc.retrofitexample.R;
import com.example.victor_pc.retrofitexample.databinding.ActivityProfileBinding;
import com.example.victor_pc.retrofitexample.model.UserDetailResponse;
import com.example.victor_pc.retrofitexample.model.UserItemResponse;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding mBinding;
    private ProfileViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
    }

    private void initView() {
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        mViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        mViewModel.init(position);
        mViewModel.getUserDetail().observe(this, new Observer<UserDetailResponse>() {
            @Override
            public void onChanged(@Nullable UserDetailResponse userDetailResponse) {
                mBinding.setViewModel(userDetailResponse.getData());
                mBinding.setImageUrl(userDetailResponse.getData().getAvatar());
            }
        });
    }

    private void initLoading() {
        showGif();
        initView();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                removeGif();
            }
        }, 1000);
    }

    private void showGif() {
        mBinding.gif.setVisibility(View.VISIBLE);
        mBinding.llProfile.setVisibility(View.GONE);
    }

    private void removeGif() {
        mBinding.gif.setVisibility(View.GONE);
        mBinding.llProfile.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initLoading();
    }
}
