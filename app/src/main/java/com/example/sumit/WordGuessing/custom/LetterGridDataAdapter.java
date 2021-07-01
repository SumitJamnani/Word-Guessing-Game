package com.example.sumit.WordGuessing.custom;

import java.util.Observable;

public abstract class LetterGridDataAdapter extends Observable {

    public abstract int getColCount();
    public abstract int getRowCount();
    public abstract char getLetter(int row, int col);

}
