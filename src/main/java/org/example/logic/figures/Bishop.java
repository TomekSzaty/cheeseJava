package org.example.logic.figures;

import org.example.Figure;
import org.example.logic.FigureColour;
import org.example.logic.FigureMove;

import java.util.ArrayList;
import java.util.List;

public class Bishop implements Figure {

    private final FigureColour colour;

    public Bishop(FigureColour colour) {
        this.colour = colour;
    }

    @Override
    public FigureColour getColour() {
        return colour;
    }

    @Override
    public List<FigureMove> getPossibleMoves() {

        List<FigureMove> moves = new ArrayList<>();
        addBishopMoves(moves, true);
        addBishopMoves(moves, false);
        return moves;
    }

    private void addBishopMoves(List<FigureMove> moves, boolean haveToCapture) {
        for (int delta = -1; delta > -8; delta--)
        moves.add(new FigureMove(delta, delta, false, haveToCapture, false));
        for (int delta = -1; delta > -8; delta--)
        moves.add(new FigureMove(delta, -delta, false, haveToCapture, false));
        for (int delta = 1; delta < 8; delta++)
        moves.add(new FigureMove(delta, delta, false, haveToCapture, false));
        for (int delta = 1; delta < 8; delta++)
        moves.add(new FigureMove(delta, -delta, false, haveToCapture, false));
    }

    @Override
    public String toString() {
        return getColourSymbol() + "B";
    }

    private String getColourSymbol() {
        return (colour == FigureColour.WHITE) ? "w" : "b";
    }
}
