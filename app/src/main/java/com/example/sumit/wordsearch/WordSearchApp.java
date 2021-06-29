package com.example.sumit.wordsearch;

import android.app.Application;

import com.example.sumit.wordsearch.di.component.AppComponent;
import com.example.sumit.wordsearch.di.component.DaggerAppComponent;
import com.example.sumit.wordsearch.di.modules.AppModule;

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
