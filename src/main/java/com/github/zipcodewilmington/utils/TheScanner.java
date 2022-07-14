package com.github.zipcodewilmington.utils;

import java.util.InputMismatchException;

public class TheScanner {
    /**
     * THIS METHOD IS FOR MENU OPTIONS WHICH REQUIRE AN INTEGER INPUT
     * IF THE USER DOES NOT ENTER AN INTEGER, IT WILL NOT LET THEM OUT
     * OF THE LOOP
     */
    static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" is not a number dumdum. Please enter a number.");
            }
        }
    }
}
