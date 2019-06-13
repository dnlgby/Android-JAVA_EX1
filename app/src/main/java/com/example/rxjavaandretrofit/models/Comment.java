package com.example.rxjavaandretrofit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {

    @SerializedName("postId")
    @Expose()
    private int mPostId;

    @SerializedName("id")
    @Expose()
    private int mId;

    @SerializedName("name")
    @Expose()
    private String mName;

    @SerializedName("email")
    @Expose()
    private String mEmail;

    @SerializedName("body")
    @Expose()
    private String mBody;


    public Comment(int postId, int id, String name, String email, String body) {
        this.mPostId = postId;
        this.mId = id;
        this.mName = name;
        this.mEmail = email;
        this.mBody = body;
    }

    public int getPostId() {
        return mPostId;
    }

    public void setPostId(int postId) {
        this.mPostId = postId;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        this.mBody = body;
    }
}
