package org.example.logic.figures;

import org.example.Figure;
import org.example.logic.FigureColour;
import org.example.logic.FigureMove;

import java.util.ArrayList;
import java.util.List;

public class Queen implements Figure {

    private final FigureColour colour;

    public Queen(FigureColour colour) {
        this.colour = colour;
    }

    @Override
    public FigureColour getColour() {
        return colour;
    }

    @Override
    public List<FigureMove> getPossibleMoves() {
        List<FigureMove> moves = new ArrayList<>();
        addQueenMoves(moves, false);
        addQueenMoves(moves, true);
        return moves;
    }

    private void addQueenMoves(List<FigureMove> moves, boolean haveToCapture) {
        for (int delta = -1; delta > -8; delta--)
            moves.add(new FigureMove(delta, delta, false, haveToCapture, false));
        for (int delta = -1; delta > -8; delta--)
            moves.add(new FigureMove(delta, -delta, false, haveToCapture, false));
        for (int delta = 1; delta < 8; delta++)
            moves.add(new FigureMove(delta, delta, false, haveToCapture, false));
        for (int delta = 1; delta < 8; delta++)
            moves.add(new FigureMove(delta, -delta, false, haveToCapture, false));
        for (int col = -1; col > -8; col--)
            moves.add(new FigureMove(col, 0, false, haveToCapture, false));
        for (int col = 1; col < 8; col++)
            moves.add(new FigureMove(col, 0, false, haveToCapture, false));
        for (int row = -1; row > -8; row--)
            moves.add(new FigureMove(0, row, false, haveToCapture, false));
        for (int row = 1; row < 8; row++)
            moves.add(new FigureMove(0, row, false, haveToCapture, false));
    }

    @Override
    public String toString() {
        return getColourSymbol() + "Q";
    }

    private String getColourSymbol() {
        return (colour == FigureColour.WHITE) ? "W" : "B";
    }
}
