package com.example.fitnessapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.fitnessapp.R;

public class AgePickActivity extends AppCompatActivity {

    private NumberPicker numberPicker;
    private TextView txtAge;
    private static final int MIN_AGE = 1;
    private static final int MAX_AGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_pick);

        txtAge = findViewById(R.id.txtAge);
        numberPicker = findViewById(R.id.agePicker);
        numberPicker.setMinValue(MIN_AGE);
        numberPicker.setMaxValue(MAX_AGE);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                txtAge.setText(String.valueOf(newVal));
            }
        });
    }
}