package com.example.fitnessapp.helper;

import com.example.fitnessapp.model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    private static final String SEPARATOR = ",";

    /**
     * Functionality: write a list of student to csv file
     * @param filePath: path location to write file
     * @throws IOException: cannot create file
     */
    public static void writeUserToFile(String filePath, User user) throws IOException {
        System.out.println("Write to " + filePath);
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));

        String row = user.getName() + SEPARATOR + user.getAge() + SEPARATOR + user.getWeight() + SEPARATOR + user.getHeight() + SEPARATOR + user.getGender() + SEPARATOR + user.getGoal() +"\n";
        bw.write(row);

        bw.close();
    }

}
