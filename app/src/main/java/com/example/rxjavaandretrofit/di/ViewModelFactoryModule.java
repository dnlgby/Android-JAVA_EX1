package com.example.rxjavaandretrofit.di;

import androidx.lifecycle.ViewModelProvider;


import com.example.rxjavaandretrofit.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);
}