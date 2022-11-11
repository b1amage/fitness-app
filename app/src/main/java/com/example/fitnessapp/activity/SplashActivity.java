package com.example.fitnessapp.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessapp.R;

public class SplashActivity extends AppCompatActivity {
    private static final long DURATION = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView logo = findViewById(R.id.logo);
        logo.animate().alpha(0).setDuration(DURATION + 100);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

                boolean passFirstTime = sh.getBoolean("passFirstTime", false);
                System.out.println(sh.getString("name", ""));

                if (passFirstTime) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, NameInputActivity.class));
                }

                finish();
            }
        }, DURATION);
    }
}
