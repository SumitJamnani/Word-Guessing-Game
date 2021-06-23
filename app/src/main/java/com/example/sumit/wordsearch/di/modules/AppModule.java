package com.example.sumit.wordsearch.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.sumit.wordsearch.features.ViewModelFactory;
import com.example.sumit.wordsearch.data.GameDataSource;
import com.example.sumit.wordsearch.data.GameThemeRepository;
import com.example.sumit.wordsearch.data.WordDataSource;
import com.example.sumit.wordsearch.features.gamehistory.GameHistoryViewModel;
import com.example.sumit.wordsearch.features.gameover.GameOverViewModel;
import com.example.sumit.wordsearch.features.gameplay.GamePlayViewModel;
import com.example.sumit.wordsearch.features.mainmenu.MainMenuViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abdularis on 18/07/17.
 */

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
