package com.example.fitnessapp.model;

public class Workout {
    private int id;
    private String category;
    private double time;
    private double caloriesPerMinute;

    public Workout(int id, String category, double time, double caloriesPerMinute) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", time=" + time +
                ", caloriesPerMinute=" + caloriesPerMinute +
                '}';
    }
}
