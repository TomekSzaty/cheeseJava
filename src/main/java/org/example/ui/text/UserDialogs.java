package org.example.ui.text;

import org.example.logic.Move;

import java.util.Scanner;

public class UserDialogs {
    public static Move getNextmove() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter next move: ");
            String  s  = scanner.nextLine();
            try {
                int colBegin = Integer.parseInt(s.substring(0, 1));
                int rowBegin = Integer.parseInt(s.substring(1, 2));
                int colEnd = Integer.parseInt(s.substring(2, 3));
                int rowEnd = Integer.parseInt(s.substring(3, 4));
                if (colBegin > 7 || rowBegin > 7 || colEnd > 7 || rowEnd > 7)
                    throw new Exception();
                return new Move(colBegin, rowBegin,colEnd, rowEnd);
            } catch (Exception e) {
                System.out.println("Wrong move, try again");
            }
        }
    }
}
