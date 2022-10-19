package org.example.logic;

public class FigureMove {
    private final int col;
    private final int row;

    public FigureMove(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
