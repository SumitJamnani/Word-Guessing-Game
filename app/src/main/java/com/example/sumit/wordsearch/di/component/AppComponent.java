package com.example.sumit.wordsearch.di.component;

import com.example.sumit.wordsearch.di.modules.AppModule;
import com.example.sumit.wordsearch.di.modules.DataSourceModule;
import com.example.sumit.wordsearch.features.FullscreenActivity;
import com.example.sumit.wordsearch.features.gamehistory.GameHistoryActivity;
import com.example.sumit.wordsearch.features.gameover.GameOverActivity;
import com.example.sumit.wordsearch.features.gameplay.GamePlayActivity;
import com.example.sumit.wordsearch.features.mainmenu.MainMenuActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by abdularis on 18/07/17.
 */

@Singleton
@Component(modules = {AppModule.class, DataSourceModule.class})
public interface AppComponent {

    void inject(GamePlayActivity activity);

    void inject(MainMenuActivity activity);

    void inject(GameOverActivity activity);

    void inject(FullscreenActivity activity);

    void inject(GameHistoryActivity activity);

}
