package org.example.logic.figures;

import org.example.Figure;
import org.example.logic.FigureColour;
import org.example.logic.FigureMove;

import java.util.List;

public class Rock implements Figure {

    private final FigureColour colour;

    public Rock(FigureColour colour) {
        this.colour = colour;
    }

    @Override
    public FigureColour getColour() {
        return colour;
    }

    @Override
    public List<FigureMove> getPossibleMoves() {
        return null;
    }

    @Override
    public String toString() {
        return getColourSymbol() + "R";
    }

    private String getColourSymbol() {
        return (colour == FigureColour.WHITE) ? "W" : "B";
    }
}
