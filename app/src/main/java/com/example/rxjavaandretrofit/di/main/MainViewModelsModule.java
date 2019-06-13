package com.example.rxjavaandretrofit.di.main;

import androidx.lifecycle.ViewModel;

import com.example.rxjavaandretrofit.di.ViewModelKey;
import com.example.rxjavaandretrofit.ui.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindMainViewModel(MainViewModel viewModel);

}
