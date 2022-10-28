package org.example.logic;

import java.util.ArrayList;
import java.util.List;

public class AI {
    public static Move getBestMove(Board board) {

        //Lista wszystkich mozliwych ruchów dla komputera

        FigureColour computerColor = (board.getBoardOrientation() == BoardOrientation.WHITE_ON_TOP) ?
                    FigureColour.WHITE : FigureColour.BLACK;
        List<Move> allPossibleMoves = new ArrayList<>();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board.getFigure(col, row).getColour() == computerColor) {
                    addPossibleMoves(col, row, allPossibleMoves, board);
                }
            }
        }
        return null;
    }

    private static void addPossibleMoves(int col, int row, List<Move> allPossibleMoves, Board board) {
        for (FigureMove potentialMove : board.getFigure(col, row).getPossibleMoves()) {
            Board boardCopy = board.deepCopy();
            Move moveToCheck = new Move(col, row, potentialMove.getCol() + col, potentialMove.getRow() + row);
            if (boardCopy.move(moveToCheck)) {
                allPossibleMoves.add(moveToCheck);
            }
        }
    }
}
