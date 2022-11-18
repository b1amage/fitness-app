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
import com.example.fitnessapp.data.WorkoutData;
import com.example.fitnessapp.model.Workout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textName;
    private List<Workout> workoutList;
    private ListView listView;

    private BottomNavigationView bottomNav;

    private void initComponent() {
        bottomNav = findViewById(R.id.bottomNavigationView);
        listView = findViewById(R.id.workoutListView);
        textName = findViewById(R.id.textNameMain);
    }

    private void initData() {
        workoutList = WorkoutData.getWorkoutList();

        WorkoutAdapter workoutAdapter = new WorkoutAdapter(workoutList);

        bottomNav.setSelectedItemId(R.id.home);
        listView.setAdapter(workoutAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Workout workout = (Workout) workoutAdapter.getItem(position);

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

        initComponent();

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
                SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sh.edit();

                double caloOut = sh.getFloat("caloOut", 0);
                caloOut += workoutCalories;
                myEdit.putFloat("caloOut", (float) caloOut);

                myEdit.commit();

                Toast.makeText(MainActivity.this, "You have jus burned " + workoutCalories + " calories!", Toast.LENGTH_LONG).show();
            }
        }
    }

}