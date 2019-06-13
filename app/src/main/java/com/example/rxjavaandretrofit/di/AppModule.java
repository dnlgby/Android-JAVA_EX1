package com.example.rxjavaandretrofit.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    static Context provideApplicationContext(Application application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    @Named("ServerUrl")
    static String provideServerUrl(){
        return "https://jsonplaceholder.typicode.com";
    }

}
