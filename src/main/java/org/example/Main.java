package org.example;

import org.example.logic.Board;
import org.example.logic.BoardOrientation;
import org.example.logic.Move;
import org.example.ui.text.UserDialogs;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(BoardOrientation.WHITE_ON_TOP);
        board.init();
        System.out.println(board);
        while (true) {
            Move move = UserDialogs.getNextmove();
            if (board.move(move)) {

            }
            System.out.println(board);
        }
    }
}