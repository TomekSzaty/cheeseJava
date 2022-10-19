package org.example.logic;

public class FigureMove {
    private final int col;
    private final int row;
    private final boolean haveToCapture;
    private final boolean haveToBeFirstMove;
    private boolean canJump;
    private final boolean onlyInColorDirection;

    public FigureMove(int col, int row, boolean onlyInColorDirection, boolean haveToCapture, boolean haveToBeFirstMove) {
        this.col = col;
        this.row = row;
        this.onlyInColorDirection = onlyInColorDirection;
        this.haveToCapture = haveToCapture;
        this.haveToBeFirstMove = haveToBeFirstMove;
        canJump = false;
    }

    public FigureMove(int col, int row, boolean onlyInColorDirection, boolean haveToCapture, boolean haveToBeFirstMove, boolean canJump) {
        this.col = col;
        this.row = row;
        this.onlyInColorDirection = onlyInColorDirection;
        this.haveToCapture = haveToCapture;
        this.haveToBeFirstMove = haveToBeFirstMove;
        this.canJump = canJump;
    }


    public boolean isHaveToCapture() {
        return haveToCapture;
    }

    public boolean isHaveToBeFirstMove() {
        return haveToBeFirstMove;
    }

    public boolean isOnlyInColorDirection() {
        return onlyInColorDirection;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean isCanJump() {
        return canJump;
    }
}
