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
import com.example.fitnessapp.data.MealData;
import com.example.fitnessapp.model.Dish;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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
        meals = MealData.getMealList();

        mealListView = findViewById(R.id.mealListView);
        MealAdapter adapter = new MealAdapter(meals);
        mealListView.setAdapter(adapter);

        mealListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dish meal = (Dish) adapter.getItem(position);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(MealActivity.this, "You have jus absorb " + data.getExtras().getDouble("totalCalo") + " calories!", Toast.LENGTH_LONG).show();
            }
        }
    }
}