package com.example.sumit.WordGuessing;

import android.app.Application;

import com.example.sumit.WordGuessing.di.component.AppComponent;
import com.example.sumit.WordGuessing.di.component.DaggerAppComponent;
import com.example.sumit.WordGuessing.di.modules.AppModule;

public class WordSearchApp extends Application {

    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
