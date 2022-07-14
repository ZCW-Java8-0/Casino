package com.github.zipcodewilmington.casino.games.connectfour;

import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ConnectFour {
    static ArrayList<Integer> userPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    List<Token> userTokens = new ArrayList<>();
    List<Token> cpuTokens = new ArrayList<>();

    public static final String ANSI_YELLOW = "\u001B[33m"; //replace with AnsiColor enums
    static AnsiColor color;


    static Scanner sc = new Scanner(System.in);
    static ConnectFourPlayer cfPlayer = new ConnectFourPlayer();
    static Board gameBoard;

    static Token userToken = new Token(AnsiColor.RED);
    static Token opponentToken = new Token(AnsiColor.BLACK);

    public static void main(String[] args) {
        Character[][] board = {
                {'-', '-', '-', '-', '|', '-', '|', '-', '|', '-', '|', '-', '|', '-', '-'},
                {'|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|'},
                {'|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|'},
                {'|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|'},
                {'|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|'},
                {'|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|'},
                {'|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|'},
                {'-', '-', '-', '-', '|', '-', '|', '-', '|', '-', '|', '-', '|', '-', '-'},
        };

        gameBoard = new Board(board);
        displayGameBoard(board);
        placeUserPosition(board, cfPlayer.getPositionPlacement(), "user");

    }


    ConnectFour(ConnectFourPlayer player) {
        this.cfPlayer = player;
    }

    ConnectFour() {
    }

    static void displayGameBoard(Character[][] board) {
        //TODO number rows to better user's understanding
        int rowNums = 1;
        for (Character[] row : board) {
            for (Character ch : row) {
                System.out.print(ANSI_YELLOW+ch);
                System.out.print("\t");
            }
            System.out.println("");
        }
    }

    static void placeUserPosition(Character[][] board, int position, String user) {
        int pos;
        char symbol = 'X';
        System.out.println("Enter a position to place your token: ");
        cfPlayer.setPositionPlacement(sc.nextInt());
        pos = cfPlayer.getPositionPlacement();

        switch (pos) {
            //y then x
            case 1:
                board[6][1] = symbol; //column 1
                break;
            case 2:
                board[6][3] = symbol; //column2
                break;
            case 3:
                board[6][5] = symbol; //column3
                break;
            case 4:
                board[6][7] = symbol; //column4
                break;
            case 5:
                board[6][9] = symbol; //column5
                break;
            case 6:
                board[6][11] = symbol; //column6
                break;
            case 7:
                board[6][13] = symbol; //column7
                break;
            default:
                break;
        }
        System.out.println("\n\n");
        displayGameBoard(board);


/*
    static void placePosition(Character[][] board, int position, String user) {
        char symbol;
        if (user.equals("user")) {
            symbol = AnsiColor.RED;
        }
    }
*/


    }
}
