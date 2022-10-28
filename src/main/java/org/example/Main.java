package org.example;

import org.example.logic.AI;
import org.example.logic.Board;
import org.example.logic.BoardOrientation;
import org.example.logic.Move;
import org.example.ui.text.UserDialogs;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(BoardOrientation.BLACK_ON_TOP, true);
        board.init();
        System.out.println(board);
        while (true) {
            Move move = UserDialogs.getNextMove();
            if (board.move(move)) {
                if (board.isGameWithComputer()) {
                    Move computerMove = AI.getBestMove(board);
                    board.move(computerMove);
                }
            }
            System.out.println(board);
        }
    }
}