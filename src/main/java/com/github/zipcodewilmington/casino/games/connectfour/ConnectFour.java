package com.github.zipcodewilmington.casino.games.connectfour;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.*;
import static com.github.zipcodewilmington.casino.games.connectfour.Board.*;


public class ConnectFour implements GameInterface {
//    static ArrayList<Integer> userPositions = new ArrayList<>();
//    static ArrayList<Integer> cpuPositions = new ArrayList<>();
//    List<Token> userTokens = new ArrayList<>();
//    List<Token> cpuTokens = new ArrayList<>();
//    static Map<Character[][], Boolean> indexTracker = new HashMap<>();

    public void playConnectFour() {

        final String ANSI_YELLOW = "\u001B[33m"; //replace with AnsiColor enums
        final String ANSI_RED = "\u001B[31m";
        AnsiColor color;

        Scanner sc = new Scanner(System.in);
        ConnectFourPlayer cfPlayer = new ConnectFourPlayer();
        Board gameBoard;
        IOConsole con = new IOConsole();

        Token userToken = new Token();
        int round = 1;
        Character player = 'R';

        int col;
        boolean winner = false;
        boolean allowedPlacement;

        //public static void main(String[] args) {
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


        while (winner == false && round <= 42) {

            do {
                displayGameBoard();
                con.print("Round #" + round + "\nPlayer " + player +
                        " , enter a number to choose column:");
                cfPlayer.setPositionPlacement(sc.nextInt());
                col = cfPlayer.getPositionPlacement() * 2 - 1;
                allowedPlacement = checkPlacement(col, board);

            } while (allowedPlacement == false);
            for (int row = board.length - 1; row >= 1; row--) {
                if (board[row][col] == 'O') {
                    board[row][col] = player; //TODO
                    break;
                }
            }
            winner = isWinner(player, board);

            if (player == 'R') {
                player = 'B';
            } else {
                player = 'R';
            }
            round++;
        }
        displayGameBoard();
        System.out.println("");

        if (winner) {
            if (player == 'R') {
                System.out.println("Black won!");
            } else {
                System.out.println("Red won!");
            }
            System.out.println("No winners, tied game");
        }


//        ConnectFour(ConnectFourPlayer player) {
//            this.player = cfPlayer;
//        }

//        ConnectFour() {
//        }

/*
    static void placeUserPosition(Character[][] board, String user) {
        char symbol = 'X';
        boolean allowedPlacement = true;
        int roundCounter = 1;

        while (true) { //replace w try, catch block
            System.out.println("Round " +roundCounter +"\n"+
                    "Enter a position to place your token: ");
            cfPlayer.setPositionPlacement(sc.nextInt()); // setting player position based on user input
            int pos = cfPlayer.getPositionPlacement(); //return player's position

            allowedPlacement = checkPlacement(pos, board);
            userToken.setSymbol(symbol);
            Character tok = userToken.getSymbol();

            switch (pos) {
                //y then x
                case 1:
                    board[6][1] = symbol;//column1
                    userPositions.add(pos);
//                    indexTracker.put(board, emptyPosition);
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
*/
    }

        static boolean checkPlacement ( int col, Character[][] board){
            if (col < 1) { //TODO
                System.out.print("ERROR: invalid number");
                return false;
            } else if (board[1][col] != 'O') { //TODO
                return false;
            }
            return true;
        }


        static boolean isWinner (Character player, Character[][]board){
            for (int row = 1; row < board.length; row++) {
                for (int col = 1; col < board[1].length - 2; col++) {
                    if (board[row][col] == player &&
                            board[row][col + 2] == player &&
                            board[row][col + 4] == player &&
                            board[row][col + 6] == player) {
                        return true;
                    }
                }
            }

            for (int row = 1; row < board.length - 3; row++) {
                for (int col = 1; col < board[1].length; col++) {
                    if (board[row][col] == player &&
                            board[row + 2][col] == player &&
                            board[row + 4][col] == player &&
                            board[row + 6][col] == player) {
                        return true;
                    }
                }
            }

            for (int row = 3; row < board.length; row++) {
                for (int col = 1; col < board[1].length - 3; col++) {
                    if (board[row][col] == player &&
                            board[row - 2][col + 2] == player &&
                            board[row - 4][col + 4] == player &&
                            board[row - 6][col + 6] == player) {
                        return true;
                    }
                }
            }

            for (int row = 1; row < board.length - 3; row++) {
                for (int col = 1; col < board[1].length - 3; col++) {
                    if (board[row][col] == player &&
                            board[row + 2][col + 2] == player &&
                            board[row + 4][col + 4] == player &&
                            board[row + 6][col + 6] == player) {
                        return true;

                    }
                }
            }
            return false;
        }


    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        playConnectFour();
    }
}
