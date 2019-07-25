package com.example.victor_pc.retrofitexample.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.victor_pc.retrofitexample.BR;
import com.google.gson.annotations.SerializedName;

public class UserItemResponse extends BaseObservable{

    @SerializedName("id")
    protected Integer id;

    @SerializedName("email")
    protected String email;

    @SerializedName("first_name")
    protected String first_name;

    @SerializedName("last_name")
    protected String last_name;

    @SerializedName("avatar")
    protected String avatar;

    public UserItemResponse() {
    }

    public UserItemResponse(Integer id, String email, String first_name, String last_name) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Bindable
    public Integer getId() {
        return id;
    }

    public UserItemResponse setId(Integer id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
        return this;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public UserItemResponse setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.id);
        return this;
    }

    @Bindable
    public String getFirst_name() {
        return first_name;
    }

    public UserItemResponse setFirst_name(String first_name) {
        this.first_name = first_name;
        notifyPropertyChanged(BR.id);
        return this;
    }

    @Bindable
    public String getLast_name() {
        return last_name;
    }

    public UserItemResponse setLast_name(String last_name) {
        this.last_name = last_name;
        notifyPropertyChanged(BR.id);
        return this;
    }

    @Bindable
    public String getAvatar() {
        return avatar;
    }

    public UserItemResponse setAvatar(String avatar) {
        this.avatar = avatar;
        notifyPropertyChanged(BR.id);
        return this;
    }

    @Bindable
    public String getName() {
        return first_name + " " + last_name;
    }

    @BindingAdapter("profileImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl).apply(new RequestOptions().circleCrop())
                .into(view);
    }
}
