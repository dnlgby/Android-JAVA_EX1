package com.example.rxjavaandretrofit.di.main;


import com.example.rxjavaandretrofit.network.posts.PostsApi;
import com.example.rxjavaandretrofit.ui.adapters.CommentsListAdapter;
import com.example.rxjavaandretrofit.ui.adapters.PostsListAdapter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class MainModule {

    @MainScope
    @Provides
    static Retrofit provideRetrofitInstance(@Named("ServerUrl") String serverUrl) {
        return new Retrofit.Builder()
                .baseUrl(serverUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @MainScope
    @Provides
    static PostsApi provideTodosApi(Retrofit retrofit) {
        return retrofit.create(PostsApi.class);
    }


    @MainScope
    @Provides
    static PostsListAdapter providePostsAdapter() {
        return new PostsListAdapter();
    }


    @MainScope
    @Provides
    static CommentsListAdapter provideCommentsAdapter() {
        return new CommentsListAdapter();
    }

}
