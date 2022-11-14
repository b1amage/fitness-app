package com.example.fitnessapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitnessapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    private ImageView avatar;
    private TextView username;
    private TextView weight;
    private TextView height;
    private TextView age;
    private TextView bmi;
    private TextView tdee;
    private TextView caloIn;
    private TextView caloOut;

    private void initComponents() {
        avatar = findViewById(R.id.userAvatar);
        username = findViewById(R.id.profileUsername);
        weight = findViewById(R.id.profileWeightTxt);
        height = findViewById(R.id.profileHeightTxt);
        age = findViewById(R.id.profileAgeTxt);
        bmi = findViewById(R.id.profileBmiTxt);
        tdee = findViewById(R.id.profileTdeeTxt);
        caloIn = findViewById(R.id.profileCaloInTxt);
        caloOut = findViewById(R.id.profileCaloOutTxt);
    }

    private void initData() {
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        username.setText(sh.getString("name", ""));
        weight.setText(String.valueOf(sh.getFloat("weight", 0)));
        height.setText(String.valueOf(sh.getFloat("height", 0)));
        age.setText(String.valueOf(sh.getInt("age", 0)));
        System.out.println("BMI: " + String.valueOf(sh.getFloat("bmi", 0)));
        bmi.setText(String.valueOf((double) Math.round(sh.getFloat("bmi", 0) * 100.0) / 100.0));
        tdee.setText(String.valueOf(Math.round(sh.getFloat("tdee", 0))));

        caloIn.setText(String.valueOf(sh.getFloat("caloIn", 0)));
        caloOut.setText(String.valueOf(sh.getFloat("caloOut", 0)));

        avatar.setImageResource(sh.getString("gender", "m").equals("m") ? R.drawable.male_avatar : R.drawable.female_avatar);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initComponents();
        initData();

        // bototm nav
        bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setSelectedItemId(R.id.profile);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case (R.id.home):
                        intent = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case (R.id.meal):
                        intent = new Intent(ProfileActivity.this, MealActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case (R.id.profile):
                        break;
                }
                return true;
            }
        });
    }
}