package com.example.fitnessapp.helper;

import com.example.fitnessapp.exception.NegativeNumberException;

public class NumberConverter {
    private NumberConverter() {}
    public static double getDouble(String s) throws NegativeNumberException {
        try {
            double num = Double.parseDouble(s);
            if (num < 0) throw new NegativeNumberException();
            return num;
        } catch (Exception e) {
            throw e;
        }
    }
}
