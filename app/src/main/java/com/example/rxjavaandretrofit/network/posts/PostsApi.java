package com.example.rxjavaandretrofit.network.posts;

import com.example.rxjavaandretrofit.models.Comment;
import com.example.rxjavaandretrofit.models.Post;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface PostsApi {

    @GET("posts")
    Single<List<Post>> getPosts();

    @GET("comments")
    Single<List<Comment>> getComments();

}



