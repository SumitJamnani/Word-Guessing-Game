package com.example.sumit.WordGuessing.data.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sumit.WordGuessing.data.WordDataSource;
import com.example.sumit.WordGuessing.model.Word;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class WordSQLiteDataSource implements WordDataSource {

    private DbHelper mHelper;

    @Inject
    public WordSQLiteDataSource(DbHelper helper) {
        mHelper = helper;
    }

    @Override
    public List<Word> getWords() {
        SQLiteDatabase db = mHelper.getReadableDatabase();

        String cols[] = {
                DbContract.WordBank._ID,
                DbContract.WordBank.COL_STRING
        };

        Cursor c = db.query(DbContract.WordBank.TABLE_NAME, cols, null, null, null, null, null);

        List<Word> wordList = new ArrayList<>();
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {

                wordList.add(new Word(c.getInt(0), c.getString(1)));

                c.moveToNext();
            }
        }

        c.close();
        return wordList;
    }
}
