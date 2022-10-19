package org.example.logic.figures;

import org.example.Figure;
import org.example.logic.FigureColour;
import org.example.logic.FigureMove;

import java.util.List;

public class None implements Figure {
    @Override
    public FigureColour getColour() {
        return FigureColour.NONE;
    }

    @Override
    public List<FigureMove> getPossibleMoves() {
        return null;
    }

    @Override
    public String toString() {
        return "  ";
    }
}
