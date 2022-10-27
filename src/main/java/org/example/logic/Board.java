package org.example.logic;

import org.example.Figure;
import org.example.logic.figures.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private BoardOrientation boardOrientation = BoardOrientation.WHITE_ON_TOP;
    private FigureColour whoseMove = FigureColour.WHITE;
    private final List<BoardRows> rows = new ArrayList<>();

    public Board(BoardOrientation boardOrientation) {
        this();
        this.boardOrientation = boardOrientation;
    }

    public Board() {
        for (int row = 0; row < 8; row++)
            rows.add(new BoardRows());
    }

    public void init() {
        FigureColour colour = (boardOrientation == BoardOrientation.WHITE_ON_TOP) ? FigureColour.WHITE : FigureColour.BLACK;
        setBeginningRowOfColour(colour, 0);
        setPawns(colour, 1);
        colour = oppositeColor(colour);
        setBeginningRowOfColour(colour, 7);
        setPawns(colour, 6);
    }

    private void setPawns(FigureColour colour, int row) {
        for (int col = 0; col < 8; col++) {
            setFigure(col, row, new Pawn(colour));
        }
    }

    private FigureColour oppositeColor(FigureColour colour) {
        return (colour == FigureColour.WHITE ? FigureColour.BLACK : FigureColour.WHITE);
    }

    private void setBeginningRowOfColour(FigureColour colour, int row) {
        setFigure(0, row, new Rook(colour));
        setFigure(1, row, new Knight(colour));
        setFigure(2, row, new Bishop(colour));
        if (boardOrientation == BoardOrientation.WHITE_ON_TOP) {
            setFigure(4, row, new Queen(colour));
            setFigure(3, row, new King(colour));
        }else {
            setFigure(3, row, new Queen(colour));
            setFigure(4, row, new King(colour));
        }
        setFigure(5, row, new Bishop(colour));
        setFigure(6, row, new Knight(colour));
        setFigure(7, row, new Rook(colour));
    }

    public Figure getFigure(int col, int row) {
        return rows.get(row).getCols().get(col);
    }

    public void setFigure(int col, int row, Figure figure) {
        rows.get(row).getCols().set(col, figure);
    }

    public boolean move(Move move) {
        boolean result = true;
        result = result && checkIfMovingFigure(move);
        result = result && checkFigureColor(move);
        result = result && targetFieldIsEmptyOrEnemy(move);
        result = result && isValidMove(move);
        if (result) {
            Figure figure = getFigure(move.getSourceCol(), move.getSourceRow());
            setFigure(move.getDestCol(), move.getDestRow(), figure);
            setFigure(move.getSourceCol(), move.getSourceRow(), new None());
            whoseMove = oppositeColor(whoseMove);
        }
        return result;
    }

    private boolean targetFieldIsEmptyOrEnemy(Move move) {
        return (getFigure(move.getDestCol(), move.getDestRow()) instanceof None) ||
                (getFigure(move.getDestCol(), move.getDestRow()).getColour() != whoseMove);
    }

    private boolean isValidMove(Move move) {
        boolean isCapture = !(getFigure(move.getDestCol(), move.getDestRow()) instanceof None);
        int deltaCol = move.getDestCol() - move.getSourceCol();
        int deltaRow = move.getDestRow() - move.getSourceCol();
        boolean isMoveIsColorDirection = isMoveIsColorDirection(move);
        return getFigure(move.getSourceCol(), move.getSourceRow()).getPossibleMoves().stream()
                .filter(pm -> pm.getCol() == deltaCol)
                .filter(pm -> pm.getRow() == deltaRow)
                .filter(pm -> pm.isHaveToCapture() == isCapture)
                .filter(pm -> !pm.isOnlyInColorDirection() || isMoveIsColorDirection)
                .findAny()
                .isPresent();
    }

    private boolean isMoveIsColorDirection(Move move) {
        boolean isMoveIsColorDirection;
        if (boardOrientation == BoardOrientation.WHITE_ON_TOP) {
            if (getFigure(move.getSourceCol(), move.getSourceRow()).getColour() == FigureColour.WHITE) {
                isMoveIsColorDirection = (move.getDestRow() > move.getSourceRow());
            } else {
                isMoveIsColorDirection = (move.getDestRow() < move.getSourceRow());
            }
        } else {
            if (getFigure(move.getSourceCol(), move.getSourceRow()).getColour() == FigureColour.WHITE) {
                isMoveIsColorDirection = (move.getDestRow() < move.getSourceRow());
            } else {
                isMoveIsColorDirection = (move.getDestRow() > move.getSourceRow());
            }
        }
        return isMoveIsColorDirection;
    }

    private boolean checkFigureColor(Move move) {
        return getFigure(move.getSourceCol(), move.getSourceRow()).getColour() == whoseMove;
    }

    private boolean checkIfMovingFigure(Move move) {
        return !(getFigure(move.getSourceCol(), move.getSourceRow()) instanceof None);
    }

    @Override
    public String toString() {
        String s = "|--|--|--|--|--|--|--|--|\n";
        for (int row = 0; row < 8; row++)
            s += rows.get(row).toString();
        s += "|--|--|--|--|--|--|--|--|\n";
        s += "Next Move: " + whoseMove;
        return s;
    }
}
