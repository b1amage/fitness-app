package com.example.fitnessapp.helper;

public class StringChecker {
    private StringChecker() {}

    public static boolean containsDigit(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }

        return false;
    }
}
