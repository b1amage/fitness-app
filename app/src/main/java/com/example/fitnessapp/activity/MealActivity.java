package com.example.fitnessapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fitnessapp.R;
import com.example.fitnessapp.adapter.MealAdapter;
import com.example.fitnessapp.model.Dish;
import com.example.fitnessapp.model.Ingredient;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MealActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    private List<Dish> meals;
    private ListView mealListView;

    private void initBottomBar() {
        bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setSelectedItemId(R.id.meal);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case (R.id.home):
                        intent = new Intent(MealActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case (R.id.meal):
                        break;
                    case (R.id.profile):
                        intent = new Intent(MealActivity.this, ProfileActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
                return true;
            }
        });
    }

    private void initData() {
        meals = new ArrayList<>();

        Ingredient bean = new Ingredient("Bean", 100, "gram", 1.27);
        Ingredient salad = new Ingredient("Salad", 200, "gram", 2.11);
        Ingredient rice = new Ingredient("Rice", 150, "gram", 1.3);
        Ingredient egg = new Ingredient("Egg", 1, "egg", 78);
        Ingredient chicken = new Ingredient("Chicken", 125, "gram", 2.39);
        Ingredient beef = new Ingredient("Beef", 100, "gram", 2.5);
        Ingredient salmon = new Ingredient("Salmon", 150, "gram", 2.08);
        Ingredient pasta = new Ingredient("Pasta", 200, "gram", 1.31);
        Ingredient pork = new Ingredient("Pork", 150, "gram", 2.42);
        Ingredient tomato = new Ingredient("Tomato", 75, "gram", 0.18);
        Ingredient tofu = new Ingredient("Tofu", 125, "gram", 1.44);
        Ingredient berry = new Ingredient("Berry", 100, "gram", 0.57);
        Ingredient cream = new Ingredient("Cream", 25, "ml", 1.96);
        Ingredient flour = new Ingredient("Flour", 200, "gram", 3.52);
        Ingredient avocado = new Ingredient("Avocado", 100, "gram", 1.6);


        ArrayList<Ingredient> beefRiceIngredients = new ArrayList<>(Arrays.asList(beef, rice, avocado));
        ArrayList<Ingredient> berryCakeIngredients = new ArrayList<>(Arrays.asList(berry, flour, cream));
        ArrayList<Ingredient> chickenSaladIngredients = new ArrayList<>(Arrays.asList(salad, chicken, tomato));
        ArrayList<Ingredient> friedSalmonIngredients = new ArrayList<>(Arrays.asList(salmon, rice, avocado));
        ArrayList<Ingredient> grillChickenIngredients = new ArrayList<>(Arrays.asList(chicken, rice, tomato));
        ArrayList<Ingredient> pastaIngredients = new ArrayList<>(Arrays.asList(pasta, beef, tomato));
        ArrayList<Ingredient> porkSaladIngredients = new ArrayList<>(Arrays.asList(pork, salad, egg));
        ArrayList<Ingredient> tofuSaladIngredients = new ArrayList<>(Arrays.asList(tofu, salad, tomato));
        ArrayList<Ingredient> salmonSaladIngredients = new ArrayList<>(Arrays.asList(salad, salmon, avocado));
        ArrayList<Ingredient> veganSaladIngredients = new ArrayList<>(Arrays.asList(bean, tomato, salad));


        meals.add(new Dish(1, "Beef Rice", R.drawable.beef_rice, beefRiceIngredients));
        meals.add(new Dish(2, "Berry Cake", R.drawable.berry_cake, berryCakeIngredients));
        meals.add(new Dish(3, "Chicken Salad", R.drawable.chicken_salad, chickenSaladIngredients));
        meals.add(new Dish(4, "Fried Salmon", R.drawable.fried_salmon, friedSalmonIngredients));
        meals.add(new Dish(5, "Grill Chicken", R.drawable.grill_chicken, grillChickenIngredients));
        meals.add(new Dish(6, "Pasta", R.drawable.pasta, pastaIngredients));
        meals.add(new Dish(7, "Pork Salad", R.drawable.pork_salad, porkSaladIngredients));
        meals.add(new Dish(8, "Tofu Salad", R.drawable.tofu_salad, tofuSaladIngredients));
        meals.add(new Dish(9, "Salmon Salad", R.drawable.salmon_salad, salmonSaladIngredients ));
        meals.add(new Dish(10, "Vegan salad", R.drawable.meal, veganSaladIngredients));

        mealListView = findViewById(R.id.mealListView);
        MealAdapter adapter = new MealAdapter(meals);
        mealListView.setAdapter(adapter);

        mealListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dish meal = (Dish) adapter.getItem(position);
                Toast.makeText(MealActivity.this, String.valueOf(meal.getId()) , Toast.LENGTH_LONG).show();

                // Go to detail
                Intent intent = new Intent(MealActivity.this, MealDetailActivity.class);
                intent.putExtra("img", meal.getImg());
                intent.putExtra("name", meal.getName());

                intent.putExtra("ingredient1Name", meal.getIngredients().get(0).getName());
                intent.putExtra("ingredient1Calo", meal.getIngredients().get(0).getCaloriesPerUnit() * meal.getIngredients().get(0).getAmount());

                intent.putExtra("ingredient2Name", meal.getIngredients().get(1).getName());
                intent.putExtra("ingredient2Calo", meal.getIngredients().get(1).getCaloriesPerUnit() * meal.getIngredients().get(1).getAmount());

                intent.putExtra("ingredient3Name", meal.getIngredients().get(2).getName());
                intent.putExtra("ingredient3Calo", meal.getIngredients().get(2).getCaloriesPerUnit() * meal.getIngredients().get(2).getAmount());

                intent.putExtra("totalCalo", meal.getCalories());
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

       initBottomBar();
       initData();
    }
}