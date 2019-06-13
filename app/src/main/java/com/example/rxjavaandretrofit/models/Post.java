package com.example.rxjavaandretrofit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("userId")
    @Expose()
    private int mUserId;

    @SerializedName("id")
    @Expose()
    private int mId;

    @SerializedName("title")
    @Expose()
    private String mTitle;

    @SerializedName("body")
    @Expose()
    private String mBody;

    public Post(int userId, int id, String title, String body) {
        this.mUserId = userId;
        this.mId = id;
        this.mTitle = title;
        this.mBody = body;
    }


    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        this.mUserId = userId;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        this.mBody = body;
    }
}
