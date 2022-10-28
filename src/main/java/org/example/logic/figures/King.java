package org.example.logic.figures;

import org.example.Figure;
import org.example.logic.FigureColour;
import org.example.logic.FigureMove;

import java.util.ArrayList;
import java.util.List;

public class King implements Figure {

    private final FigureColour colour;

    public King(FigureColour colour) {
        this.colour = colour;
    }

    @Override
    public FigureColour getColour() {
        return colour;
    }

    @Override
    public List<FigureMove> getPossibleMoves() {
        List<FigureMove> moves = new ArrayList<>();
        addKingMoves(moves, false);
        addKingMoves(moves, true);
        return moves;
    }

    private void addKingMoves(List<FigureMove> moves, boolean haveToCapture) {
        moves.add(new FigureMove(-1, -1, false, haveToCapture, false));
        moves.add(new FigureMove(-1, 0, false, haveToCapture, false));
        moves.add(new FigureMove(-1, 1, false, haveToCapture, false));
        moves.add(new FigureMove(0, -1, false, haveToCapture, false));
        moves.add(new FigureMove(0, 1, false, haveToCapture, false));
        moves.add(new FigureMove(1, -1, false, haveToCapture, false));
        moves.add(new FigureMove(1, 0, false, haveToCapture, false));
        moves.add(new FigureMove(1, 1, false, haveToCapture, false));
    }

    @Override
    public String toString() {
    return getColourSymbol() + "X";
    }

    private String getColourSymbol() {
        return (colour == FigureColour.WHITE) ? "w" : "b";
    }
}
