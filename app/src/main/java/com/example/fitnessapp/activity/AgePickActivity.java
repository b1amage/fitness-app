package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;

import com.example.fitnessapp.R;

public class AgePickActivity extends AppCompatActivity {

    private NumberPicker numberPicker;
    private static final int MIN_AGE = 1;
    private static final int MAX_AGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_pick);

        numberPicker = findViewById(R.id.agePicker);
        numberPicker.setMinValue(MIN_AGE);
        numberPicker.setMaxValue(MAX_AGE);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                System.out.println(newVal);
            }
        });
    }
}