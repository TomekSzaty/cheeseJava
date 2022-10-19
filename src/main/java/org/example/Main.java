package org.example;

import org.example.logic.Board;
import org.example.logic.FigureColour;
import org.example.logic.Move;
import org.example.logic.figures.Pawn;
import org.example.logic.figures.Rock;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setFigure(0, 0, new Rock(FigureColour.BLACK));
        board.setFigure(0, 6, new Pawn(FigureColour.WHITE));
        System.out.println(board);
        board.move(new Move(0, 6, 0, 5 ));
        System.out.println(board);

    }
}