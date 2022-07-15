package com.github.zipcodewilmington.casino.games.connectfour;

import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

public class Board {
    public static final String ANSI_YELLOW = "\u001B[33m"; //replace with AnsiColor enums
    private static int length = 15;
    private static int width = 7;
    public static final Character[][] board = new Character[width][length];


    public Board(Character[][] matrix) {
    }

    //creates board, NOT displays
    static void createGameBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (col % 2 == 0) board[row][col] = '|';
                else {
                    board[row][col] = 'O';
                }
                //top row, "lid"
                if (row == 0) board[row][col] = '_';
            }
        }
    }


    static void displayGameBoard() {
        //TODO number rows to better user's understanding
        int colNums = 0;
        for (Character[] row : board) {
//            System.out.print(rowNums++);
            for (Character ch : row) {
                System.out.print(ANSI_YELLOW + ch);
                System.out.print("\t");
            }
            System.out.println("");
        }
        System.out.println("\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7");
    }


}
