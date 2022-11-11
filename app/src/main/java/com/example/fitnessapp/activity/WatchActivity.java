package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

import com.example.fitnessapp.R;

public class WatchActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private boolean isRunning;
    private long pauseOffSet;
    private long timeWorkout = 0; // milisecond

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_view);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
    }

    public void onStartChronometer(View v) {
        if (isRunning) return;

        chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffSet);
        chronometer.start();
        isRunning = true;

    }

    public void onPauseChronometer(View v) {
        if (!isRunning) return;

        chronometer.stop();
        pauseOffSet = SystemClock.elapsedRealtime() - chronometer.getBase();
        isRunning = false;
        timeWorkout = SystemClock.elapsedRealtime() - chronometer.getBase();
    }

    public void onResetChronometer(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffSet = 0;
        timeWorkout = 0;
    }

    public void onStopChronometer(View v) {
        // back to previous view return the
        Intent intent = new Intent(WatchActivity.this, MainActivity.class);
        intent.putExtra("calories", (timeWorkout / 1000 / 60) * getIntent().getExtras().getDouble("caloriesPerMinute"));
        setResult(RESULT_OK, intent);
        finish();
    }
}