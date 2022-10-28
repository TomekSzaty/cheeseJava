package org.example.logic.figures;

import org.example.Figure;
import org.example.logic.FigureColour;
import org.example.logic.FigureMove;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Figure {

    private final FigureColour colour;

    public Pawn(FigureColour colour) {
        this.colour = colour;
    }

    @Override
    public FigureColour getColour() {
        return colour;
    }

    @Override
    public List<FigureMove> getPossibleMoves() {
        List<FigureMove> moves = new ArrayList<>();
        moves.add(new FigureMove(0, 1, true, false, false));
        moves.add(new FigureMove(0, 2, true, false, true));
        moves.add(new FigureMove(-1, 1, true, true, false));
        moves.add(new FigureMove(1, 1, true, true, false));
        moves.add(new FigureMove(0, -1, true, false, false));
        moves.add(new FigureMove(0, -2, true, false, true));
        moves.add(new FigureMove(-1, -1, true, true, false));
        moves.add(new FigureMove(1, -1, true, true, false));
        return moves;
    }

    @Override
    public String toString() {
        return getColourSymbol() + "P";
    }

    private String getColourSymbol() {
        return (colour == FigureColour.WHITE) ? "w" : "b";
    }
}
