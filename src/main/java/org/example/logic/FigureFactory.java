package org.example.logic;
import org.example.Figure;
import org.example.logic.figures.*;

public class FigureFactory {
    public static Figure createFigureCopy(Figure figure) {
        FigureColour color = figure.getColour();
        if (figure instanceof Pawn)
            return new Pawn(color);
        if (figure instanceof Rook)
            return new Rook(color);
        if (figure instanceof Knight)
            return new Knight(color);
        if (figure instanceof Bishop)
            return new Bishop(color);
        if (figure instanceof Queen)
            return new Queen(color);
        if (figure instanceof King)
            return new King(color);
        throw new RuntimeException("Bad figure type has been found on board");
    }
}
