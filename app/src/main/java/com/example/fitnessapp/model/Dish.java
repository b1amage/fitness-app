package com.example.fitnessapp.model;

import java.util.ArrayList;

public class Dish {
    private double calories;
    private String name;
    private String img;
    private ArrayList<Ingredient> ingredients;

    public Dish(String name, String img, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.img = img;
        this.ingredients = ingredients;
        calculateCalories();
    }

    public double getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    private void calculateCalories() {
        for (Ingredient i : ingredients) {
            this.calories += i.getCaloriesPerUnit() * i.getAmount();
        }
    }
}
