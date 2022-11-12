package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

import com.example.fitnessapp.R;

import pl.droidsonroids.gif.GifImageView;

public class WatchActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private boolean isRunning;
    private long pauseOffSet;
    private long timeWorkout = 0; // milisecond
    private GifImageView gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_view);

        gif = findViewById(R.id.gif);
        gif.setVisibility(View.GONE);
        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
    }

    public void onStartChronometer(View v) {
        if (isRunning) return;

        gif.setVisibility(View.VISIBLE);
        chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffSet);
        chronometer.start();
        isRunning = true;

    }

    public void onPauseChronometer(View v) {
        if (!isRunning) return;

        gif.setVisibility(View.GONE);
        chronometer.stop();
        pauseOffSet = SystemClock.elapsedRealtime() - chronometer.getBase();
        isRunning = false;
        timeWorkout = SystemClock.elapsedRealtime() - chronometer.getBase();
    }

    public void onResetChronometer(View v) {
        gif.setVisibility(View.GONE);
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffSet = 0;
        timeWorkout = 0;
    }

    public void onStopChronometer(View v) {
        gif.setVisibility(View.GONE);
        // save to preference

        // back to previous view
        timeWorkout = SystemClock.elapsedRealtime() - chronometer.getBase();
        Intent intent = new Intent(WatchActivity.this, MainActivity.class);
        System.out.println("Time in second: " + timeWorkout / 1000);
        System.out.println("calories " + (timeWorkout / 1000 / 60) * getIntent().getExtras().getDouble("caloriesPerMinute"));
        intent.putExtra("calories", (timeWorkout / 1000 / 60) * getIntent().getExtras().getDouble("caloriesPerMinute"));
        setResult(RESULT_OK, intent);
        finish();
    }
}