package org.example;

import org.example.logic.FigureColour;
import org.example.logic.FigureMove;

import java.util.List;

public interface Figure {
    FigureColour getColour();
    List<FigureMove> getPossibleMoves();
}
