package com.example.victor_pc.retrofitexample.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.victor_pc.retrofitexample.R;
import com.example.victor_pc.retrofitexample.databinding.ItemLayoutBinding;
import com.example.victor_pc.retrofitexample.model.UserItemResponse;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private Context context;
    private List<UserItemResponse> listUser;
    private HomeActivity.OnClick listener;

    public HomeAdapter(Context context, List<UserItemResponse> listUser, HomeActivity.OnClick listener) {
        this.context = context;
        this.listUser = listUser;
        this.listener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemLayoutBinding itemBinding;

        public MyViewHolder(ItemLayoutBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ItemLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_layout, viewGroup, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {
        UserItemResponse user = listUser.get(position);
        myViewHolder.itemBinding.setImageUrl(user.getAvatar());
        myViewHolder.itemBinding.setViewModel(user);
        myViewHolder.itemBinding.itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.Click(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }
}
