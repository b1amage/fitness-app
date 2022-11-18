package com.example.fitnessapp.data;

import com.example.fitnessapp.R;
import com.example.fitnessapp.model.Dish;
import com.example.fitnessapp.model.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MealData {

    private static final Ingredient bean = new Ingredient("Bean", 100, "gram", 1.27);
    private static final Ingredient salad = new Ingredient("Salad", 200, "gram", 2.11);
    private static final Ingredient rice = new Ingredient("Rice", 150, "gram", 1.3);
    private static final Ingredient egg = new Ingredient("Egg", 1, "egg", 78);
    private static final Ingredient chicken = new Ingredient("Chicken", 125, "gram", 2.39);
    private static final Ingredient beef = new Ingredient("Beef", 100, "gram", 2.5);
    private static final Ingredient salmon = new Ingredient("Salmon", 150, "gram", 2.08);
    private static final Ingredient pasta = new Ingredient("Pasta", 200, "gram", 1.31);
    private static final Ingredient pork = new Ingredient("Pork", 150, "gram", 2.42);
    private static final Ingredient tomato = new Ingredient("Tomato", 75, "gram", 0.18);
    private static final Ingredient tofu = new Ingredient("Tofu", 125, "gram", 1.44);
    private static final Ingredient berry = new Ingredient("Berry", 100, "gram", 0.57);
    private static final Ingredient cream = new Ingredient("Cream", 25, "ml", 1.96);
    private static final Ingredient flour = new Ingredient("Flour", 200, "gram", 3.52);
    private static final Ingredient avocado = new Ingredient("Avocado", 100, "gram", 1.6);

    private static final ArrayList<Ingredient> beefRiceIngredients = new ArrayList<>(Arrays.asList(beef, rice, avocado));
    private static final ArrayList<Ingredient> berryCakeIngredients = new ArrayList<>(Arrays.asList(berry, flour, cream));
    private static final ArrayList<Ingredient> chickenSaladIngredients = new ArrayList<>(Arrays.asList(salad, chicken, tomato));
    private static final ArrayList<Ingredient> friedSalmonIngredients = new ArrayList<>(Arrays.asList(salmon, rice, avocado));
    private static final ArrayList<Ingredient> grillChickenIngredients = new ArrayList<>(Arrays.asList(chicken, rice, tomato));
    private static final ArrayList<Ingredient> pastaIngredients = new ArrayList<>(Arrays.asList(pasta, beef, tomato));
    private static final ArrayList<Ingredient> porkSaladIngredients = new ArrayList<>(Arrays.asList(pork, salad, egg));
    private static final ArrayList<Ingredient> tofuSaladIngredients = new ArrayList<>(Arrays.asList(tofu, salad, tomato));
    private static final ArrayList<Ingredient> salmonSaladIngredients = new ArrayList<>(Arrays.asList(salad, salmon, avocado));
    private static final ArrayList<Ingredient> veganSaladIngredients = new ArrayList<>(Arrays.asList(bean, tomato, salad));

    private static final  List<Dish> mealList = new ArrayList<>(
            Arrays.asList(
                    new Dish(1, "Beef Rice", R.drawable.beef_rice, beefRiceIngredients),
                    new Dish(2, "Berry Cake", R.drawable.berry_cake, berryCakeIngredients),
                    new Dish(3, "Chicken Salad", R.drawable.chicken_salad, chickenSaladIngredients),
                    new Dish(4, "Fried Salmon", R.drawable.fried_salmon, friedSalmonIngredients),
                    new Dish(5, "Grill Chicken", R.drawable.grill_chicken, grillChickenIngredients),
                    new Dish(6, "Pasta", R.drawable.pasta, pastaIngredients),
                    new Dish(7, "Pork Salad", R.drawable.pork_salad, porkSaladIngredients),
                    new Dish(8, "Tofu Salad", R.drawable.tofu_salad, tofuSaladIngredients),
                    new Dish(9, "Salmon Salad", R.drawable.salmon_salad, salmonSaladIngredients),
                    new Dish(10, "Vegan salad", R.drawable.meal, veganSaladIngredients)
            )
    );

    private MealData() {}

    public static List<Dish> getMealList() {
        return mealList;
    }
}
