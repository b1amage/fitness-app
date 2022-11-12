package com.example.fitnessapp.model;

import java.util.ArrayList;

public class Dish {
    private int id;
    private double calories;
    private String name;
    private int img;
    private ArrayList<Ingredient> ingredients;

    public Dish(int id, String name, int img, ArrayList<Ingredient> ingredients) {
        this.id = id;
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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void calculateCalories() {
        for (Ingredient i : ingredients) {
            this.calories += i.getCaloriesPerUnit() * i.getAmount();
        }
    }
}
