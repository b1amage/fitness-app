package com.example.fitnessapp.model;

public class Workout {
    private String category;
    private double time;
    private double caloriesPerMinute;

    public Workout(String category, double time, double caloriesPerMinute) {
        this.category = category;
        this.time = time;
        this.caloriesPerMinute = caloriesPerMinute;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getCaloriesPerMinute() {
        return caloriesPerMinute;
    }

    public void setCaloriesPerMinute(double caloriesPerMinute) {
        this.caloriesPerMinute = caloriesPerMinute;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "category='" + category + '\'' +
                ", time=" + time +
                ", caloriesPerMinute=" + caloriesPerMinute +
                '}';
    }
}
