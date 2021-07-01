package com.example.sumit.WordGuessing.commons;

public class GridIndex {

    public int row;
    public int col;

    public GridIndex() {
        this(0, 0);
    }

    public GridIndex(int row, int col) {
        set(row, col);
    }

    public void set(int row, int col) {
        this.row = row;
        this.col = col;
    }

}