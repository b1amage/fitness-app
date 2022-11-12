package com.example.fitnessapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessapp.R;
import com.example.fitnessapp.adapter.WorkoutAdapter;
import com.example.fitnessapp.model.Workout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textName;
    private List<Workout> workoutList;
    private ListView listView;

    private BottomNavigationView bottomNav;

    private void initData() {
        workoutList = new ArrayList<>();

        workoutList.add(new Workout("Basketball", 50, R.drawable.basketball));
        workoutList.add(new Workout("Gym", 60, R.drawable.gym));
        workoutList.add(new Workout("Volleyball", 70, R.drawable.volleyball));
        workoutList.add(new Workout("Yoga", 80, R.drawable.yoga));
        workoutList.add(new Workout("Cardio", 90, R.drawable.cardio));
        workoutList.add(new Workout("Badminton", 100, R.drawable.badminton));
        workoutList.add(new Workout("Tennis", 100, R.drawable.tennis));
        workoutList.add(new Workout("Running", 100, R.drawable.running));
        workoutList.add(new Workout("Cycling", 100, R.drawable.cycling));


        WorkoutAdapter workoutAdapter = new WorkoutAdapter(workoutList);
        bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setSelectedItemId(R.id.home);
        listView = findViewById(R.id.workoutListView);
        listView.setAdapter(workoutAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Workout workout = (Workout) workoutAdapter.getItem(position);
                Toast.makeText(MainActivity.this, workout.getCategory(), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, WatchActivity.class);
                intent.putExtra("category", workout.getCategory());
                intent.putExtra("caloriesPerMinute", workout.getCaloriesPerMinute());

                startActivityForResult(intent, 100);
            }
        });

        // bottom nav
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case (R.id.home):
                        break;
                    case (R.id.meal):
                        intent = new Intent(MainActivity.this, MealActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case (R.id.profile):
                        intent = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
                return true;
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = findViewById(R.id.textNameMain);
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        textName.setText(sh.getString("name", ""));

        initData();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                double workoutCalories = data.getExtras().getDouble("calories");
                Toast.makeText(MainActivity.this, "You have jus burned " + workoutCalories + "calories!", Toast.LENGTH_LONG).show();
            }
        }
    }

}