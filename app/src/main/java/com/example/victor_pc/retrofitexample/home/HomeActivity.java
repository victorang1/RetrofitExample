package com.example.victor_pc.retrofitexample.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.victor_pc.retrofitexample.R;
import com.example.victor_pc.retrofitexample.databinding.ActivityHomeBinding;
import com.example.victor_pc.retrofitexample.model.UserItemResponse;
import com.example.victor_pc.retrofitexample.model.UserResponse;
import com.example.victor_pc.retrofitexample.profile.ProfileActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding mBinding;
    private HomeViewModel mViewModel;
    private HomeAdapter mAdapter;
    private List<UserItemResponse> listUser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        mViewModel.init();
        mViewModel.getUserData().observe(this, new Observer<UserResponse>() {
            @Override
            public void onChanged(@Nullable UserResponse userResponse) {
                List<UserItemResponse> data = userResponse.getData();
                listUser.addAll(data);
                mAdapter.notifyDataSetChanged();
            }
        });
        initAdapter();
    }

    private void initAdapter() {
        OnClick listener = new OnClick() {
            @Override
            public void Click(int position) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        };
        mAdapter = new HomeAdapter(this, listUser, listener);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setHasFixedSize(true);
        mBinding.recyclerView.setAdapter(mAdapter);
    }

    public interface OnClick {
        void Click(int position);
    }
}
