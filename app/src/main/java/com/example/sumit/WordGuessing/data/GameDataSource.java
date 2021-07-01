package com.example.sumit.WordGuessing.data;

import com.example.sumit.WordGuessing.data.entity.GameDataEntity;
import com.example.sumit.WordGuessing.model.GameDataInfo;
import com.example.sumit.WordGuessing.model.UsedWord;

import java.util.List;

public interface GameDataSource {

    interface GameRoundCallback {

        void onLoaded(GameDataEntity gameRound);

    }

    interface InfosCallback {

        void onLoaded(List<GameDataInfo> infoList);
    }

    interface StatCallback {

        void onLoaded(GameDataInfo gameDataInfo);

    }

    void getGameData(int gid, GameRoundCallback callback);

    void getGameDataInfos(InfosCallback callback);

    void getGameDataInfo(int gid, StatCallback callback);

    long saveGameData(GameDataEntity gameRound);

    void deleteGameData(int gid);

    void deleteGameDatas();

    void saveGameDataDuration(int gid, int newDuration);

    void markWordAsAnswered(UsedWord usedWord);
}
