package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {

   // public static void main(String[] args){

        public static void playSlotsGame(){

        final String RED_BRIGHT = "\033[0;91m";    // RED
        final String TEXT_RESET = "\u001B[0m";

        Random random = new Random();
        int num1;
        int num2;
        int num3;
        Scanner scan = new Scanner(System.in);
        String playerInput;


        do {
            System.out.println("Press 1 to play or Q to quit.");
            playerInput = scan.nextLine();
            System.out.println("\n");

            num1 = random.nextInt(10);
            num2 = random.nextInt(10);
            num3 = random.nextInt(10);

            if(Math.random() <= 0.20) {
                System.out.println( RED_BRIGHT + "CHERRY | CHERRY | CHERRY" + TEXT_RESET + "\n" +
                        "Plus 2 tokens! \n");
            } else {

                System.out.println("$$$$$$$$$$$$$$$\n" +
                        "  " + num1 + " || " + num2 + " || " + num3 + "  \n" +
                        "$$$$$$$$$$$$$$$");

                if (num1 == 7 && num2 == 7 && num3 == 7) {
                    //win jackpot
                    System.out.println("\n" +
                            "Jackpot!! Congratulations!! ;D \n" +
                            "Plus 1,000 tokens!");
                    ;

                } else if (num1 == num2 && num1 == num3) {
                    //win tokens
                    System.out.println("\n" +
                            "Winner!!  Plus 50 tokens! \n");
                } else {
                    System.out.println("\n" +
                            "Loser.  Try again! \n");
                }
            }
        } while (Objects.equals(playerInput, "1"));
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        playSlotsGame();

    }
}
