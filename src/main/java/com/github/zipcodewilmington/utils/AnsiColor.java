package com.github.zipcodewilmington.utils;

/**
 * Created by leon on 7/21/2020.
 * used to create color for output of `IOConsole`
 */
public enum AnsiColor {
    AUTO("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m");

    private final String color;

    AnsiColor(String ansiColor) {
        this.color = ansiColor;
    }

    public String getColor() {
        return color;
    }

}