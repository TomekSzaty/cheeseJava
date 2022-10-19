package org.example.logic.figures;

import org.example.Figure;
import org.example.logic.FigureColour;
import org.example.logic.FigureMove;

import java.util.ArrayList;
import java.util.List;

public class Knight implements Figure {

    private final FigureColour colour;

    public Knight(FigureColour colour) {
        this.colour = colour;
    }

    @Override
    public FigureColour getColour() {
        return null;
    }

    @Override
    public List<FigureMove> getPossibleMoves() {
        List<FigureMove> moves = new ArrayList<>();
        addKnightMoves(moves, true);
        addKnightMoves(moves, false);
        return moves;
    }

    private void addKnightMoves(List<FigureMove> moves, boolean haveToCapture) {
        moves.add(new FigureMove(-1, -2, false, haveToCapture, false, true));
        moves.add(new FigureMove(1, -2, false, haveToCapture, false, true));
        moves.add(new FigureMove(2, -1, false, haveToCapture, false, true));
        moves.add(new FigureMove(2, 1, false, haveToCapture, false, true));
        moves.add(new FigureMove(1, 2, false, haveToCapture, false, true));
        moves.add(new FigureMove(-1, 2, false, haveToCapture, false, true));
        moves.add(new FigureMove(-2, 1, false, haveToCapture, false, true));
        moves.add(new FigureMove(-2, -1, false, haveToCapture, false, true));
    }

    @Override
    public String toString() {
        return getColourSymbol() + "K";
    }

    private String getColourSymbol() {
        return (colour == FigureColour.WHITE) ? "W" : "B";
    }
}
