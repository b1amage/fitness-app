package com.example.fitnessapp.model;

import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private double weight; // in kg
    private double height; // in meter
    private char gender; // f: female, m: male, o: other
    private String goal; // gain, lost, stay
    private ArrayList<Double> weekCaloIn;
    private ArrayList<Double> weekCaloOut;

    public User(String name, int age, double weight, double height, char gender, String goal, ArrayList<Double> weekCaloIn, ArrayList<Double> weekCaloOut) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.goal = goal;
        this.weekCaloIn = new ArrayList<>();
        this.weekCaloOut = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public ArrayList<Double> getWeekCaloIn() {
        return weekCaloIn;
    }

    public void setWeekCaloIn(ArrayList<Double> weekCaloIn) {
        this.weekCaloIn = weekCaloIn;
    }

    public ArrayList<Double> getWeekCaloOut() {
        return weekCaloOut;
    }

    public void setWeekCaloOut(ArrayList<Double> weekCaloOut) {
        this.weekCaloOut = weekCaloOut;
    }

    public double getBMI() {
        return height / (weight * weight);
    }

    public String getBodyStatus() {
        double bmi = getBMI();
        return bmi < 18.5 ? "underweight" :
                (bmi >= 18.5 && bmi < 25) ? "normal" :
                (bmi >= 25 && bmi < 30) ? "overweight" : "obesity";
    }

    public double getCaloriesNeedPerDay() {
        return gender == 'f' ?
                (6.25 * height * 100) + (10 * weight) - (5 * age) - 161 :
                (6.25 * height * 100) + (10 * weight) - (5 * age) + 5;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", gender=" + gender +
                ", goal='" + goal + '\'' +
                ", weekCaloIn=" + weekCaloIn +
                ", weekCaloOut=" + weekCaloOut +
                '}';
    }
}
