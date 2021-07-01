package com.example.sumit.WordGuessing.di.component;

import com.example.sumit.WordGuessing.di.modules.AppModule;
import com.example.sumit.WordGuessing.di.modules.DataSourceModule;
import com.example.sumit.WordGuessing.features.FullscreenActivity;
import com.example.sumit.WordGuessing.features.gamehistory.GameHistoryActivity;
import com.example.sumit.WordGuessing.features.gameover.GameOverActivity;
import com.example.sumit.WordGuessing.features.gameplay.GamePlayActivity;
import com.example.sumit.WordGuessing.features.mainmenu.MainMenuActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataSourceModule.class})
public interface AppComponent {

    void inject(GamePlayActivity activity);

    void inject(MainMenuActivity activity);

    void inject(GameOverActivity activity);

    void inject(FullscreenActivity activity);

    void inject(GameHistoryActivity activity);

}
