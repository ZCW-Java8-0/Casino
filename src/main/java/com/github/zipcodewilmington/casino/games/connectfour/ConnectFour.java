package com.github.zipcodewilmington.casino.games.connectfour;

import com.github.zipcodewilmington.utils.AnsiColor;
import java.util.*;
import static com.github.zipcodewilmington.casino.games.connectfour.Board.*;


public class ConnectFour {
    static ArrayList<Integer> userPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    List<Token> userTokens = new ArrayList<>();
    List<Token> cpuTokens = new ArrayList<>();

    static Map<Character[][], Boolean> indexTracker = new HashMap<Character[][], Boolean>();

    public static final String ANSI_YELLOW = "\u001B[33m"; //replace with AnsiColor enums
    private static final String ANSI_RED = "\u001B[31m";
    static AnsiColor color;


    static Scanner sc = new Scanner(System.in);
    static ConnectFourPlayer cfPlayer = new ConnectFourPlayer();
    static Board gameBoard;

    static Token userToken = new Token();
//    static Token opponentToken = new Token(AnsiColor.BLACK);

    static boolean winner = false;

    public static void main(String[] args) {
//        Character[][] board = {
//                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//                {'|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|'},
//                {'|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|'},
//                {'|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|'},
//                {'|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|'},
//                {'|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|'},
//                {'|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|', 'O', '|'},
//                {'|', '-', '|', '-', '|', '-', '|', '-', '|', '-', '|', '-', '|', '-', '|'},
//        };
//        placeUserPosition(board, "user");
//        System.out.print(userToken);

        gameBoard = new Board(board);
        createGameBoard();

        displayGameBoard();
        placeUserPosition(board, "user");
    }


    ConnectFour(ConnectFourPlayer player) {
        this.cfPlayer = player;
    }

    ConnectFour() {
    }

    static void placeUserPosition(Character[][] board, String user) {
        char symbol = 'X';
        boolean emptyPosition = true;
        boolean emptyColumn = true;
        boolean emptyRow = true;
        int roundCounter = 1;

        while (emptyPosition) { //replace w try, catch block
            System.out.println("Round " +roundCounter +"\n"+
                    "Enter a position to place your token: ");
            cfPlayer.setPositionPlacement(sc.nextInt()); // setting player position based on user input
            int pos = cfPlayer.getPositionPlacement(); //return player's position

            userToken.setSymbol(symbol);
            Character tok = userToken.getSymbol();

            if(pos>8 || pos<1) {
                System.out.print("ERROR: invalid number");
            }
            else {
                emptyPosition = false;
            }

            switch (pos) {
                //y then x
                case 1:
                    board[6][1] = symbol;//column1
                    userPositions.add(pos);
                    indexTracker.put(board, emptyPosition);
                    break;
                case 2:
                    board[6][3] = tok; //column2
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
                    System.out.print("ERROR: invalid number");
                    break;
            }
            roundCounter++;
            System.out.println("\n\n");

            System.out.print(userPositions);
//            System.out.println(indexTracker.);
            displayGameBoard();

        }

//        while (winner==false) {
//
//            if (position>7 || position<0) {
//                System.out.print("ERROR: invalid number");
//            }
//            else {
//                board[6][position] = symbol;
//            }
//        }


    }
}
