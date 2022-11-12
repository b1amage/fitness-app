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
import com.example.fitnessapp.model.Workout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
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

        Ingredient bean = new Ingredient("Bean", 100, "gram", 8.5);
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(bean);

        meals.add(new Dish(1, "Vegan salad", R.drawable.meal, ingredients));
        meals.add(new Dish(2, "Vegan salad", R.drawable.meal, ingredients));
        meals.add(new Dish(3, "Vegan salad", R.drawable.meal, ingredients));
        meals.add(new Dish(4, "Vegan salad", R.drawable.meal, ingredients));
        meals.add(new Dish(5, "Vegan salad", R.drawable.meal, ingredients));
        meals.add(new Dish(6, "Vegan salad", R.drawable.meal, ingredients));
        meals.add(new Dish(7, "Vegan salad", R.drawable.meal, ingredients));
        meals.add(new Dish(8, "Vegan salad", R.drawable.meal, ingredients));
        meals.add(new Dish(9, "Vegan salad", R.drawable.meal, ingredients));
        meals.add(new Dish(10, "Vegan salad", R.drawable.meal, ingredients));
        meals.add(new Dish(11, "Vegan salad", R.drawable.meal, ingredients));

        mealListView = findViewById(R.id.mealListView);
        MealAdapter adapter = new MealAdapter(meals);
        mealListView.setAdapter(adapter);

        mealListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dish meal = (Dish) adapter.getItem(position);
                System.out.println("Clicked");
                Toast.makeText(MealActivity.this, String.valueOf(meal.getId()) , Toast.LENGTH_LONG).show();
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