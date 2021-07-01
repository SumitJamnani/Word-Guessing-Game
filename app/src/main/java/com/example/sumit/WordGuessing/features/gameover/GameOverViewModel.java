package com.example.sumit.WordGuessing.features.gameover;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.sumit.WordGuessing.data.GameDataSource;
import com.example.sumit.WordGuessing.model.GameDataInfo;

public class GameOverViewModel extends ViewModel {

    private GameDataSource mGameDataSource;
    private MutableLiveData<GameDataInfo> mOnGameDataInfoLoaded = new MutableLiveData<>();

    public GameOverViewModel(GameDataSource gameDataSource) {
        mGameDataSource = gameDataSource;
    }

    public void loadData(int gid) {
        mGameDataSource.getGameDataInfo(gid, mOnGameDataInfoLoaded::setValue);
    }

    public void deleteGameRound(int gid) {
        mGameDataSource.deleteGameData(gid);
    }

    public LiveData<GameDataInfo> getOnGameDataInfoLoaded() {
        return mOnGameDataInfoLoaded;
    }
}
