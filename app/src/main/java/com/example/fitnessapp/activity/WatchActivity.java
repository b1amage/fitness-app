package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.fitnessapp.R;

import org.w3c.dom.Text;

import pl.droidsonroids.gif.GifImageView;

public class WatchActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private boolean isRunning;
    private long pauseOffSet;
    private long timeWorkout = 0; // milisecond
    private GifImageView gif;
    private TextView instructionTxt;

    private void initComponent() {
        instructionTxt = findViewById(R.id.txtInstruction);

        gif = findViewById(R.id.gif);
        gif.setVisibility(View.GONE);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
    }

    private void initContent() {
        String workoutName = getIntent().getExtras().getString("category");
        double caloriesPerMinute = getIntent().getExtras().getDouble("caloriesPerMinute");

        instructionTxt.setText(String.format("You are training %s. The calories consumption is %.2f calo per minutes", workoutName, caloriesPerMinute));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_view);

        initComponent();
        initContent();

    }

    public void onBackBtnClick(View v) {
        Intent intent = new Intent(WatchActivity.this, MainActivity.class);
        setResult(RESULT_CANCELED, intent);
        finish();
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

        // back to previous view
        timeWorkout = SystemClock.elapsedRealtime() - chronometer.getBase();
        Intent intent = new Intent(WatchActivity.this, MainActivity.class);
        intent.putExtra("calories", (timeWorkout / 1000 / 60) * getIntent().getExtras().getDouble("caloriesPerMinute"));
        setResult(RESULT_OK, intent);
        finish();
    }
}