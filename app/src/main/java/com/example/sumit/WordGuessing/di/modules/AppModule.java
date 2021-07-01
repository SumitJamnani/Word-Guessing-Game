package com.example.sumit.WordGuessing.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.sumit.WordGuessing.features.ViewModelFactory;
import com.example.sumit.WordGuessing.data.GameDataSource;
import com.example.sumit.WordGuessing.data.GameThemeRepository;
import com.example.sumit.WordGuessing.data.WordDataSource;
import com.example.sumit.WordGuessing.features.gamehistory.GameHistoryViewModel;
import com.example.sumit.WordGuessing.features.gameover.GameOverViewModel;
import com.example.sumit.WordGuessing.features.gameplay.GamePlayViewModel;
import com.example.sumit.WordGuessing.features.mainmenu.MainMenuViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Application mApp;

    public AppModule(Application application) {
        mApp = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApp;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    ViewModelFactory provideViewModelFactory(GameDataSource gameDataSource,
                                             WordDataSource wordDataSource) {
        return new ViewModelFactory(
                new GameOverViewModel(gameDataSource),
                new GamePlayViewModel(gameDataSource, wordDataSource),
                new MainMenuViewModel(new GameThemeRepository()),
                new GameHistoryViewModel(gameDataSource)
        );
    }
}
