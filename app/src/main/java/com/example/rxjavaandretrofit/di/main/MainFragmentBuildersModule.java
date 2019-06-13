package com.example.rxjavaandretrofit.di.main;

import com.example.rxjavaandretrofit.ui.CommentsFragment;
import com.example.rxjavaandretrofit.ui.PostsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract PostsFragment contributePostsFragment();

    @ContributesAndroidInjector
    abstract CommentsFragment contributeCommentsFragment();

}

