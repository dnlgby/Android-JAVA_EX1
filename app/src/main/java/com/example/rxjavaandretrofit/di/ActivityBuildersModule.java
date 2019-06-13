package com.example.rxjavaandretrofit.di;



import com.example.rxjavaandretrofit.di.main.MainFragmentBuildersModule;
import com.example.rxjavaandretrofit.di.main.MainModule;
import com.example.rxjavaandretrofit.di.main.MainScope;
import com.example.rxjavaandretrofit.di.main.MainViewModelsModule;
import com.example.rxjavaandretrofit.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @MainScope
    @ContributesAndroidInjector(
            modules = {MainViewModelsModule.class, MainFragmentBuildersModule.class, MainModule.class}
    )
    abstract MainActivity contributeMainActivity();

}
